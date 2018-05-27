package Server.Requests;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by osech on 10.05.2018.
 */
public class AddAlgorithmRequest implements IRequest {
    @Getter
    @Setter
    public String namealg;
    @Getter
    @Setter
    public int cost;
    @Getter
    @Setter
    public String owner;
    @Getter
    @Setter
    public String description;
    @Getter
    @Setter
    public String language;
    @Getter
    @Setter
    public String sourcefile;
    @Getter
    @Setter
    public String testfile;
}
