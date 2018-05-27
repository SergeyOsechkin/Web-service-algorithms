package Server.Responses;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by osech on 13.05.2018.
 */
public class RunTestResponse implements IResponse {
    public RunTestResponse(String ans, char success)
    {
        answer = ans;
        successful = success;
    }

    @Getter
    @Setter
    public String answer;

    @Getter
    @Setter
    public char successful;
}
