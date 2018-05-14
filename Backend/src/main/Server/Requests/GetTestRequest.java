package Server.Requests;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by osech on 13.05.2018.
 */
public class GetTestRequest implements IRequest {
    @Getter
    @Setter
    public String login;
}
