package Server.Responses;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.Setter;

public class GetAlgorithmSearchResponse implements IResponse {
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public class Algorithm {
        @Getter
        @Setter
        String owner;
        @Getter
        @Setter
        String namealg;
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

        public Algorithm(String own, String alg, String desc, int c, String lang,String source,String test) {
            owner = own;
            namealg = alg;
            description = desc;
            cost = c;
            language = lang;
            sourcefile = source;
            testfile = test;
        }
    }

    @Getter
    @Setter
    public Algorithm algorithm;

    public GetAlgorithmSearchResponse(String owner, String alg, String desc, int cost, String lang,String source,String test)
    {
        algorithm = new Algorithm(owner,alg,desc,cost,lang,source,test);
    }
}
