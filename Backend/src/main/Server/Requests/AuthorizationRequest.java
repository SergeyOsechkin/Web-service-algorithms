package Server.Requests;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by osech on 09.05.2018.
 */
public class AuthorizationRequest implements IRequest{
    @Getter
    @Setter
    public String login;
    @Getter
    @Setter
    public String password;
}
