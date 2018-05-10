package Server.Storage;

import Server.Requests.IRequest;
import Server.Responses.IResponse;

public interface IDataAccess {
    public IResponse run(IRequest request);
}
