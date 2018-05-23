package Server.Requests;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by osech on 13.05.2018.
 */
public class RunTestRequest implements IRequest {
    @Setter
    @Getter
    public String namealg;
    @Setter
    @Getter
    public String testfile;
    @Setter
    @Getter
    public String sourcefile;
    @Setter
    @Getter
    public String language;
}
