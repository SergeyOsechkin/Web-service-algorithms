package Server.Responses;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by osech on 14.05.2018.
 */
public class PayResponse implements IResponse{
    @Setter
    @Getter
    public int money;

    public PayResponse(int ans)
    {
        money = ans;
    }
}
