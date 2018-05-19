package Server.controller.TestSystem;

import Server.Requests.RunTestRequest;
import Server.Storage.DataAccess;
import Server.Storage.IDataAccess;

/**
 * Created by osech on 11.05.2018.
 */
public class TestC
{
    private final IDataAccess data = DataAccess.getInstance();

    public static String RunTest(RunTestRequest request) {
        return null;
    }
}
