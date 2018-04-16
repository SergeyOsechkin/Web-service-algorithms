package Server.controller.Authorization;

import Server.controller.Authorization.Storage.IDataAccess;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Authorization  {

    private IDataAccess dataAccess;

    public Authorization(IDataAccess dataAccess) {
        this.dataAccess = dataAccess;
    }

    @RequestMapping(value = "/available")
    public String available() {
        return "Spring in Action";
    }

}
