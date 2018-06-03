package Server.Requests;

import lombok.Getter;
import lombok.Setter;

public class GetAlgorithmSearchRequest implements IRequest {
    @Setter
    @Getter
    public String namealg;
}
