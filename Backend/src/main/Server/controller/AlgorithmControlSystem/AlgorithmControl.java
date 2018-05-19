package Server.controller.AlgorithmControlSystem;

import Server.Requests.AddAlgorithmRequest;
import Server.Requests.GetAlgorithmRequest;
import Server.Requests.GetAlgorithmUserRequest;
import Server.Responses.AddAlgorithmResponse;
import Server.Responses.GetAlgorithmResponse;
import Server.Responses.GetAlgorithmUserResponse;
import Server.Storage.DataAccess;
import Server.Storage.IDataAccess;
import org.springframework.web.bind.annotation.*;

/**
 * Created by osech on 09.05.2018.
 */
@RestController
public class AlgorithmControl {

    private final IDataAccess data = DataAccess.getInstance();

    @RequestMapping(value = "/AddAlgorithm", method = RequestMethod.POST,
            headers = {"Content-type=application/json"})
    @ResponseBody
    public AddAlgorithmResponse AddAlgorithm(@RequestBody AddAlgorithmRequest request) {
        return (AddAlgorithmResponse) data.run(request);
    }

    @RequestMapping(value = "/GetAlgorithm", method = RequestMethod.POST,
            headers = {"Content-type=application/json"})
    @ResponseBody
    public GetAlgorithmResponse GetAlgorithm(@RequestBody GetAlgorithmRequest request) {
        return (GetAlgorithmResponse) data.run(request);
    }

    @RequestMapping(value = "/GetAlgorithmUser", method = RequestMethod.POST,
            headers = {"Content-type=application/json"})
    @ResponseBody
    public GetAlgorithmUserResponse GetAlgorithm(@RequestBody GetAlgorithmUserRequest request) {
        return (GetAlgorithmUserResponse) data.run(request);
    }

}
