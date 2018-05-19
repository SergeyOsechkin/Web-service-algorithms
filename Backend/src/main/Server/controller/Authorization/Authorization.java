package Server.controller.Authorization;

import Server.Requests.AuthorizationRequest;
import Server.Requests.RegistrationRequest;
import Server.Responses.AuthorizationResponse;
import Server.Responses.RegistrationResponse;
import Server.Storage.DataAccess;
import Server.Storage.IDataAccess;
import org.springframework.web.bind.annotation.*;

@RestController
public class Authorization {

    private final IDataAccess data = DataAccess.getInstance();

    @RequestMapping(value = "/Authorization", method = RequestMethod.POST,
                        headers = {"Content-type=application/json"})
    @ResponseBody
    public AuthorizationResponse Authorize(@RequestBody AuthorizationRequest request) {
        return (AuthorizationResponse) data.run(request);
    }

    @RequestMapping(value = "/Registration", method = RequestMethod.POST,
            headers = {"Content-type=application/json"})
    @ResponseBody
    public RegistrationResponse Registration(@RequestBody RegistrationRequest request) {
        return (RegistrationResponse) data.run(request);
    }
}
