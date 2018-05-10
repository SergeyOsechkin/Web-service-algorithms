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

    public AuthorizationResponse(String ans)
    {
        answer = ans;
    }
}
