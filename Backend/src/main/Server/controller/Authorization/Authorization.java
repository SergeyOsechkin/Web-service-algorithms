package Server.controller.Authorization;

import Server.Requests.AuthorizationRequest;
import Server.Requests.RegistrationRequest;
import Server.Responses.AuthorizationResponse;
import Server.Responses.IResponse;
import Server.Responses.RegistrationResponse;
import Server.Storage.DataAccess;
import Server.Storage.IDataAccess;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;


@RestController
public class Authorization {

    private final IDataAccess data = DataAccess.getInstance();

    @RequestMapping(value = "/Authorization", method = RequestMethod.POST,
                        headers = {"Content-type=application/json"})
    @ResponseBody
    public AuthorizationResponse Authorize(@RequestBody AuthorizationRequest request,HttpServletResponse res) {
        IResponse obj = data.run(request);
        if (obj == null)
            res.setStatus(HttpServletResponse.SC_NOT_FOUND);
        return (AuthorizationResponse)obj;
    }

    @RequestMapping(value = "/Registration", method = RequestMethod.POST,
            headers = {"Content-type=application/json"})
    @ResponseBody
    public RegistrationResponse Registration(@RequestBody RegistrationRequest request, HttpServletResponse res) {
        IResponse obj = data.run(request);
        if (obj == null)
            res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        return (RegistrationResponse) obj;
    }
}
