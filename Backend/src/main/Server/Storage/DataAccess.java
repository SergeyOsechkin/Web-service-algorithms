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
    private final String password = "123";

    private static DataAccess instance;

    private Connection con;
    private Statement stmt;

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
        else if (request instanceof GetAlgorithmRequest)
            return execute((GetAlgorithmRequest)request);
        else if (request instanceof GetAlgorithmUserRequest)
            return execute((GetAlgorithmUserRequest)request);
        else if (request instanceof PayRequest)
            return execute((PayRequest)request);
        else
            return null;
    }

    private RegistrationResponse execute (RegistrationRequest r){
        String query = String.format("INSERT INTO public.\"userspace\"(" +
                "\"firstname\", \"secondname\", " +
                "\"middlename\", \"login\", \"password\")" +
                "VALUES('%s','%s','%s','%s','%s')",
                    r.firstname,r.secondname,r.middlename,r.login,r.password);
        RegistrationResponse response = new RegistrationResponse("OK");
        try {
            update(query);
        } catch (SQLException e) {
            e.printStackTrace();
            response.answer = "Error";
        }
        return response;
    }

    private AuthorizationResponse execute (AuthorizationRequest r) {
        String query = String.format("SELECT * FROM public.\"userspace\"" +
                        "where \"login\" = '%s' AND \"password\" = '%s' limit 1",
                r.login, r.password);
        AuthorizationResponse response = null;
        try {
            ResultSet res = select(query);
            String temp;
            if (!res.next())
                temp = "Error";
            else
                temp = res.getString("login");
            response = new AuthorizationResponse(temp,res.getInt("privilege"));
        } catch (SQLException e) {
            e.printStackTrace();
            response = new AuthorizationResponse("Error",0);
        }
        return response;
    }

    private AddAlgorithmResponse execute (AddAlgorithmRequest r)
    {
        String query = String.format("INSERT INTO public.\"algorithm\"(" +
                        "\"owner\", \"namealg\", \"cost\"," +
                        "\"description\", \"language\", \"sourceFile\", \"testFile\")" +
                        "VALUES('%s','%s',%d,'%s','%s','%s','%s')",
                r.owner,r.namealg,r.cost,r.description,r.language,r.sourceFile,r.testFile);
        AddAlgorithmResponse response = null;
        try {
            response = new AddAlgorithmResponse("OK");
            update(query);
        } catch (SQLException e) {
            e.printStackTrace();
            response = new AddAlgorithmResponse("Error");
        }
        return response;
    }

    private GetAlgorithmResponse execute (GetAlgorithmRequest r)
    {
        String query = String.format("select * from public.\"algorithm\"" +
                                    "WHERE \"namealg\" like '%" + r.search + "%';");
        GetAlgorithmResponse response = new GetAlgorithmResponse();
        try {
            ResultSet res = select(query);
            while(res.next())
            {
                String own = res.getString("owner");
                String namealg = res.getString("namealg");
                String description = res.getString("description");
                int cost = res.getInt("cost");
                String language = res.getString("language");
                response.Add(own,namealg,description,cost,language);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return response;
    }

    public GetAlgorithmUserResponse execute (GetAlgorithmUserRequest r)
    {
        String query = String.format("select * from public.\"algorithm\"" +
                "WHERE \"owner\" = '%s'",r.login);
        GetAlgorithmUserResponse response = new GetAlgorithmUserResponse();
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
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return response;
    }

    public PayResponse execute (PayRequest r)
    {
        String query = String.format("UPDATE public.\"userspace\"" +
                "SET money = %s" +
                "WHERE \"login\" = '%s'",r.money,r.login);
        PayResponse response = new PayResponse("Error");
        try {
            update(query);
            response.answer = "OK";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return response;
    }

    private void update(String query) throws SQLException {
        try {
            con = DriverManager.getConnection(url, user, password);
            stmt = con.createStatement();
            stmt.execute(query);
        }
        finally {
            con.close();
            stmt.close();
        }
    }

    public ResultSet select(String query) throws SQLException
    {
        try {
            con = DriverManager.getConnection(url, user, password);
            stmt = con.createStatement();
            return stmt.executeQuery(query);
        }
        finally {
            con.close();
        }
    }
}
