package Server.Requests;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by osech on 12.05.2018.
 */
public class GetAlgorithmUserRequest implements IRequest {
    @Getter
    @Setter
    public String login;
}
