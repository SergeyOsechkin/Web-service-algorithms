package Server.Responses;

/**
 * Created by osech on 13.05.2018.
 */
public class RunTestResponse implements IResponse {
    public RunTestResponse(String ans)
    {
        answer = ans;
    }

    public String answer;
}
