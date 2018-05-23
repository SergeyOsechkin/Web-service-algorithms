package Server.Responses;

import lombok.Getter;
import lombok.Setter;

public class BuyAlgorithmResponse implements IResponse {
    @Setter
    @Getter
    public int money;
    public BuyAlgorithmResponse (int c)
    {
        money = c;
    }
}
