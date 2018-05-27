package Server.controller.AlgorithmControlSystem;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.Setter;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class AlgorithmUser {
    @Getter
    @Setter
    String description;
    @Getter
    @Setter
    int cost;
    @Getter
    @Setter
    String language;
    @Getter
    @Setter
    String sourcefile;
    @Getter
    @Setter
    String testfile;

    public AlgorithmUser(String desc, int c, String lang,String source,String test) {
        description = desc;
        cost = c;
        language = lang;
        sourcefile = source;
        testfile = test;
    }
}
