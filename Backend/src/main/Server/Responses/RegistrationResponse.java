package Server.Responses;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by osech on 09.05.2018.
 */
public class RegistrationResponse implements IResponse {
    @Getter
    @Setter
    public String answer;

    public RegistrationResponse(String ans)
    {
        answer = ans;
    }
}
