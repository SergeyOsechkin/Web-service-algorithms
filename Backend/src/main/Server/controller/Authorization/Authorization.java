package Server.controller.Authorization;

import Server.controller.Authorization.Storage.DataAccess;
import Server.controller.Authorization.Storage.IDataAccess;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import lombok.*;

@RestController
public class Authorization  {

    static class RequestAuthorize{
        @Getter
        @Setter
        private String login;
        @Getter
        @Setter
        private String password;
    }

    public IDataAccess data = new DataAccess();

    @RequestMapping(value = "/Authorization", method = RequestMethod.POST,
                        headers = {"Content-type=application/json"})
    public String Authorize(@RequestBody RequestAuthorize request) {
        return request.login + request.password;
    }

}
