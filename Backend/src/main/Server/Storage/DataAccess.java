package Server.Storage;

import Server.Requests.AddAlgorithmRequest;
import Server.Requests.AuthorizationRequest;
import Server.Requests.IRequest;
import Server.Requests.RegistrationRequest;
import Server.Responses.AddAlgorithmResponse;
import Server.Responses.AuthorizationResponse;
import Server.Responses.IResponse;
import Server.Responses.RegistrationResponse;

import java.lang.reflect.Type;
import java.sql.*;

/**
 * Created by osech on 17.04.2018.
 */
public class DataAccess implements IDataAccess {
    private static final String url = "jdbc:postgresql://localhost:5432/postgres";
    private static final String user = "postgres";
    private static final String password = "123";

    private Connection con;
    private Statement stmt;

    public DataAccess()
    {}

    public IResponse run(IRequest request)
    {
        if (request instanceof RegistrationRequest)
            return execute((RegistrationRequest)request);
        else if (request instanceof AuthorizationRequest)
            return execute((AuthorizationRequest)request);
        else if (request instanceof AddAlgorithmRequest)
            return execute((AddAlgorithmRequest)request);
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
                temp = res.getString("id");
            response = new AuthorizationResponse(temp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return response;
    }

    private AddAlgorithmResponse execute (AddAlgorithmRequest r)
    {
        String query = String.format("INSERT INTO public.\"algorithm\"(" +
                        "\"owner\", \"namealg\", \"cost\"," +
                        "\"description\", \"language\", \"sourceFile\", \"testFile\", \"status\")" +
                        "VALUES('%s','%s',%d,'%s','%s','%s','%s', B'%d')",
                r.owner,r.namealg,r.cost,r.description,r.language,r.sourceFile,r.testFile,0);
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
