package Server.Storage;

import Server.Requests.IRequest;
import Server.Responses.IResponse;

public interface IDataAccess {
    IResponse run(IRequest request);
    static DataAccess getInstance() {
        return null;
    }
}
