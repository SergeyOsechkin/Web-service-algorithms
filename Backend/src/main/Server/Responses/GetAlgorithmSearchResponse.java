package Server.Responses;

import lombok.Getter;
import lombok.Setter;

public class GetAlgorithmSearchResponse implements IResponse {
    class Algorithm {
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
    Algorithm algorithm;

    public GetAlgorithmSearchResponse(String owner, String alg, String desc, int cost, String lang,String source,String test)
    {
        algorithm = new Algorithm(owner,alg,desc,cost,lang,source,test);
    }
}
