package Server.Responses;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by osech on 10.05.2018.
 */
public class AddAlgorithmResponse implements IResponse{
    @Getter
    @Setter
    public String answer;

    public AddAlgorithmResponse(String ans)
    {
        answer = ans;
    }
}
