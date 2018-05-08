package Server.controller.Authorization.Storage;

import java.sql.*;

/**
 * Created by osech on 17.04.2018.
 */
public class DataAccess implements IDataAccess {
    private static final String url = "jdbc:mysql://localhost:3306/test";
    private static final String user = "root";
    private static final String password = "root";

    private Connection con;
    private Statement stmt;
    private ResultSet rs;

    public DataAccess()
    {}

    public void Update(String query) throws SQLException {
        con = DriverManager.getConnection(url, user, password);
        stmt = con.createStatement();
        rs = stmt.executeQuery(query);
        con.close();
        stmt.close();
        rs.close();
    }

    public ResultSet execute(String query) throws SQLException
    {
        try {
            con = DriverManager.getConnection(url, user, password);
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);

            return rs;
        }
        finally {
            con.close();
            stmt.close();
            rs.close();
        }
    }

}
