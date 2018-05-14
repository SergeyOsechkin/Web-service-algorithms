package Server.Requests;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by osech on 14.05.2018.
 */
public class PayRequest implements IRequest{
    @Getter
    @Setter
    public String login;
    @Getter
    @Setter
    public int money;
}
