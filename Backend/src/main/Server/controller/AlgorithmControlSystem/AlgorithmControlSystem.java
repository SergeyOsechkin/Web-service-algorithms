package Server.controller.AlgorithmControlSystem;

import Server.Requests.AddAlgorithmRequest;
import Server.Responses.AddAlgorithmResponse;
import Server.Storage.DataAccess;
import Server.Storage.IDataAccess;
import org.springframework.web.bind.annotation.*;

/**
 * Created by osech on 09.05.2018.
 */
@RestController
public class AlgorithmControlSystem {

    private static final IDataAccess data = new DataAccess();

    @RequestMapping(value = "/AddAlgorithm", method = RequestMethod.POST,
            headers = {"Content-type=application/json"})
    @ResponseBody
    public AddAlgorithmResponse AddAlgorithm(@RequestBody AddAlgorithmRequest request) {
        return (AddAlgorithmResponse) data.run(request);
    }

}
