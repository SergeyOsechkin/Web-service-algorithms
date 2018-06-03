package Server.controller.PaymentSystem;

import Server.Requests.PayRequest;
import Server.Responses.PayResponse;
import Server.Responses.RegistrationResponse;
import Server.Storage.DataAccess;
import Server.Storage.IDataAccess;
import org.springframework.web.bind.annotation.*;

/**
 * Created by osech on 14.05.2018.
 */
@RestController
public class Payment {

    private final IDataAccess data = DataAccess.getInstance();

    @RequestMapping(value = "/Pay", method = RequestMethod.POST,
            headers = {"Content-type=application/json"})
    @ResponseBody
    public PayResponse Pay(@RequestBody PayRequest request) {

        return (PayResponse) data.run(request);
    }
}
