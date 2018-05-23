package Server.Requests;

import lombok.Getter;
import lombok.Setter;

public class BuyAlgorithmRequest implements IRequest{
    @Getter
    @Setter
    public String namealg;
    @Getter
    @Setter
    public String login;
    @Getter
    @Setter
    public String description;
    @Getter
    @Setter
    public String language;
    @Getter
    @Setter
    public String sourceFile;
    @Getter
    @Setter
    public String testFile;
    @Getter
    @Setter
    public String owner;
    @Getter
    @Setter
    public int money;
    @Getter
    @Setter
    public int cost;
}
