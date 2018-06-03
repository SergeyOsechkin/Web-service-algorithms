package Server.Storage;

import Server.Requests.*;
import Server.Responses.*;

import java.sql.*;

/**
 * Created by osech on 17.04.2018.
 */
public class DataAccess implements IDataAccess {
    private final String url = "jdbc:postgresql://localhost:5432/postgres";
    private final String user = "postgres";
    private final String password = "postgres";

    private static DataAccess instance;

    private DataAccess()
    {}

    public static DataAccess getInstance()
    {
        if (instance == null)
            instance = new DataAccess();
        return instance;
    }

    public IResponse run(IRequest request)
    {
        if (request instanceof RegistrationRequest)
            return execute((RegistrationRequest)request);
        else if (request instanceof AuthorizationRequest)
            return execute((AuthorizationRequest)request);
        else if (request instanceof AddAlgorithmRequest)
            return execute((AddAlgorithmRequest)request);
        else if (request instanceof GetListAlgorithmSearchRequest)
            return execute((GetListAlgorithmSearchRequest)request);
        else if (request instanceof GetListAlgorithmUserRequest)
            return execute((GetListAlgorithmUserRequest)request);
        else if (request instanceof GetAlgorithmUserRequest)
            return execute((GetAlgorithmUserRequest)request);
        else if (request instanceof GetAlgorithmSearchRequest)
            return execute((GetAlgorithmSearchRequest)request);
        else if (request instanceof PayRequest)
            return execute((PayRequest)request);
        else if (request instanceof BuyAlgorithmRequest)
            return execute((BuyAlgorithmRequest)request);
        else
            return null;
    }

    private RegistrationResponse execute (RegistrationRequest r){
        String query = String.format("INSERT INTO public.\"userspace\"(" +
                "\"firstname\", \"secondname\", " +
                "\"middlename\", \"login\", \"password\", money)" +
                "VALUES('%s','%s','%s','%s','%s',%d)",
                    r.firstname,r.secondname,r.middlename,r.login,r.password,100);
        try {
            update(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return new RegistrationResponse("OK");
    }

    private AuthorizationResponse execute (AuthorizationRequest r) {
        String query = String.format("SELECT * FROM public.\"userspace\"" +
                        "where \"login\" = '%s' AND \"password\" = '%s' limit 1",
                r.login, r.password);
        AuthorizationResponse response = null;
        try {
            ResultSet res = select(query);
            if (res.next())
                response = new
                        AuthorizationResponse(
                            res.getString("login"),
                            res.getInt("privilege"));
            res.getStatement().close();
            res.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return response;
    }

    private AddAlgorithmResponse execute (AddAlgorithmRequest r)
    {
        String query = String.format("INSERT INTO public.\"algorithm\"(" +
                        "\"owner\", \"namealg\", \"cost\"," +
                        "\"description\", \"language\", \"sourcefile\", \"testfile\")" +
                        "VALUES('%s','%s',%d,'%s','%s','%s','%s')",
                r.owner,r.namealg,r.cost,r.description,r.language,r.sourcefile,r.testfile);
        AddAlgorithmResponse response = new AddAlgorithmResponse("OK");
        try {
            update(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return response;
    }

    private BuyAlgorithmResponse execute (BuyAlgorithmRequest r)
    {
        BuyAlgorithmResponse response = new BuyAlgorithmResponse(r.money);
        if (r.cost > r.money)
            return null;
        response.money = response.money - r.cost;
        String query = String.format("INSERT INTO public.algorithm(\n" +
                        "\towner, namealg, description, language, sourcefile, testfile, cost)\n" +
                        "\tSelect '%s', namealg, description, language, sourcefile, testfile, cost\n" +
                        "\tfrom public.algorithm\n" +
                        "\twhere owner ='%s' and namealg = '%s'",
                r.login,r.owner,r.namealg);
        String query2 = String.format("UPDATE public.\"userspace\"" +
                                        "SET money = %d" +
                                        "WHERE login = '%s'",response.money,r.login);
        String query3 = String.format("UPDATE public.\"userspace\"" +
                "SET money = money + %d" +
                "WHERE login = '%s'",r.cost,r.owner);
        try {
            update(query);
            update(query2);
            update(query3);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return response;
    }

    private GetListAlgorithmSearchResponse execute (GetListAlgorithmSearchRequest r)
    {
        String query = "select * from public.\"algorithm\"" +
                                    "WHERE \"namealg\" like '%" + r.search + "%' and \"owner\" != '" + r.login + "';";
        GetListAlgorithmSearchResponse response = new GetListAlgorithmSearchResponse();
        try {
            ResultSet res = select(query);
            while(res.next())
            {
                String namealg = res.getString("namealg");
                response.Add(namealg);
            }
            res.getStatement().close();
            res.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return response;
    }

    private GetAlgorithmSearchResponse execute (GetAlgorithmSearchRequest r)
    {
        String query = String.format("select * from public.\"algorithm\"" +
                "WHERE \"namealg\" = '" + r.namealg+"'");
        GetAlgorithmSearchResponse response = null;
        try {
            ResultSet res = select(query);
            if(res.next()){
            String own = res.getString("owner");
            String namealg = res.getString("namealg");
            String description = res.getString("description");
            int cost = res.getInt("cost");
            String language = res.getString("language");
            String source = res.getString("sourcefile");
            if (cost != 0)
                source = "";
            String test = res.getString("testfile");
            response = new GetAlgorithmSearchResponse(
                    own,namealg,description,cost,language,source,test
            );}
            res.getStatement().close();
            res.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return response;
    }

    private GetAlgorithmUserResponse execute (GetAlgorithmUserRequest r)
    {
        String query = String.format("select * from public.\"algorithm\"" +
                "WHERE namealg = '" + r.namealg + "' and owner = '"+r.login+"';");
        GetAlgorithmUserResponse response = null;
        try {
            ResultSet res = select(query);
            res.next();
            String description = res.getString("description");
            int cost = res.getInt("cost");
            String language = res.getString("language");
            String source = res.getString("sourcefile");
            String test = res.getString("testfile");
            response = new GetAlgorithmUserResponse(
                   description,cost,language,source,test
            );
            res.getStatement().close();
            res.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return response;
    }

    public GetListAlgorithmUserResponse execute (GetListAlgorithmUserRequest r)
    {
        String query = String.format("select * from public.\"algorithm\"" +
                "WHERE \"owner\" = '%s'", r.login);
        GetListAlgorithmUserResponse response = new GetListAlgorithmUserResponse();
        try {
            ResultSet res = select(query);
            while(res.next())
            {
                String namealg = res.getString("namealg");
                String description = res.getString("description");
                int cost = res.getInt("cost");
                String language = res.getString("language");
                response.Add(namealg,description,cost,language);
            }
            res.getStatement().close();
            res.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return response;
    }

    public PayResponse execute (PayRequest r)
    {
        String query = String.format("Select * from public.\"userspace\"" +
                "WHERE \"login\" = '%s'",r.login);
        PayResponse response = null;
        try {
            ResultSet res = select(query);
            if(res.next())
                response = new PayResponse(res.getInt("money")) ;
            res.getStatement().close();
            res.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return response;
    }

    public void update(String query) throws SQLException {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt = con.createStatement();
            stmt.execute(query);
            con.close();
            stmt.close();
    }

    public ResultSet select(String query) throws SQLException
    {
        Connection con = DriverManager.getConnection(url, user, password);
        Statement stmt = con.createStatement();
        stmt.executeQuery(query);
        con.close();
        return stmt.getResultSet();
    }
}
