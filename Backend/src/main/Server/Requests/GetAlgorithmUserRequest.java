package Server.Requests;


import lombok.Getter;
import lombok.Setter;

public class GetAlgorithmUserRequest implements IRequest {
    @Setter
    @Getter
    public String namealg;
    @Setter
    @Getter
    public String login;
}
