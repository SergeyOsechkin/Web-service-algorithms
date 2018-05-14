package Server.controller.TestSystem;

import Server.Requests.RunTestRequest;
import Server.Responses.RunTestResponse;

import org.springframework.web.bind.annotation.*;

/**
 * Created by osech on 13.05.2018.
 */
@RestController
public class TestControl{

    @RequestMapping(value = "/RunTest", method = RequestMethod.POST,
            headers = {"Content-type=application/json"})
    @ResponseBody
    public RunTestResponse RunTest(@RequestBody RunTestRequest request) {
        if (request.language == "C++")
            return new RunTestResponse(TestC.RunTest(request));
        return null;
    }
}
