package Server.Responses;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by osech on 09.05.2018.
 */
public class AuthorizationResponse implements IResponse{
    @Getter
    @Setter
    public String answer;
    @Getter
    @Setter
    public int privilege;
    public AuthorizationResponse(String ans, int pr)
    {
        answer = ans;
        privilege = pr;
    }
}
