package Server.Requests;

import lombok.Getter;
import lombok.Setter;

public class ChangeAlgorithmRequest implements IRequest {
    @Getter
    @Setter
    public String login;
    @Getter
    @Setter
    public String namealg;
    @Getter
    @Setter
    public String sourcefile;
    @Getter
    @Setter
    public String testfile;
    @Getter
    @Setter
    public String cost;
    @Getter
    @Setter
    public String description;

}
