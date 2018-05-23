package Server.Responses;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by osech on 12.05.2018.
 */
public class GetListAlgorithmUserResponse implements IResponse{
    class Algorithm{
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
        String language; //Правильнее сделать через Enum

        public Algorithm(String alg, String desc, int c, String lang) {
            namealg = alg;
            description = desc;
            cost = c;
            language = lang;
        }
    }

    @Getter
    @Setter
    List<Algorithm> algorithms;

    public GetListAlgorithmUserResponse()
    {
        algorithms = new ArrayList();
    }

    public void Add(String namealg, String description, int cost, String language)
    {
        algorithms.add(new Algorithm(namealg,description,cost,language));
    }

}
