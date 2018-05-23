package Server.controller.AlgorithmControlSystem;

import Server.Requests.*;
import Server.Responses.*;
import Server.Storage.DataAccess;
import Server.Storage.IDataAccess;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by osech on 09.05.2018.
 */
@RestController
public class AlgorithmControl {

    private final IDataAccess data = DataAccess.getInstance();

    @RequestMapping(value = "/AddAlgorithm", method = RequestMethod.POST,
            headers = {"Content-type=application/json"})
    @ResponseBody
    public AddAlgorithmResponse AddAlgorithm(@RequestBody AddAlgorithmRequest request, HttpServletResponse res) {
        IResponse obj = data.run(request);
        if (obj == null)
            res.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        return (AddAlgorithmResponse)obj;
    }

    @RequestMapping(value = "/GetListAlgorithmSearch", method = RequestMethod.POST,
            headers = {"Content-type=application/json"})
    @ResponseBody
    public GetListAlgorithmSearchResponse GetListAlgorithmSearch(@RequestBody GetListAlgorithmSearchRequest request) {
        return (GetListAlgorithmSearchResponse) data.run(request);
    }

    @RequestMapping(value = "/GetListAlgorithmUser", method = RequestMethod.POST,
            headers = {"Content-type=application/json"})
    @ResponseBody
    public GetListAlgorithmUserResponse GetListAlgorithmUser(@RequestBody GetListAlgorithmUserRequest request) {
        return (GetListAlgorithmUserResponse) data.run(request);
    }

    @RequestMapping(value = "/GetAlgorithmUser", method = RequestMethod.POST,
            headers = {"Content-type=application/json"})
    @ResponseBody
    public GetAlgorithmUserResponse GetAlgorithmUser(@RequestBody GetAlgorithmUserRequest request) {
        return (GetAlgorithmUserResponse) data.run(request);
    }

    @RequestMapping(value = "/GetAlgorithmSearch", method = RequestMethod.POST,
            headers = {"Content-type=application/json"})
    @ResponseBody
    public GetAlgorithmSearchResponse GetAlgorithmSearch(@RequestBody GetAlgorithmSearchRequest request) {
        return (GetAlgorithmSearchResponse) data.run(request);
    }

    @RequestMapping(value = "/BuyAlgorithm", method = RequestMethod.POST,
            headers = {"Content-type=application/json"})
    @ResponseBody
    public BuyAlgorithmResponse BuyAlgorithm(@RequestBody BuyAlgorithmRequest request) {
        return (BuyAlgorithmResponse) data.run(request);
    }

}
