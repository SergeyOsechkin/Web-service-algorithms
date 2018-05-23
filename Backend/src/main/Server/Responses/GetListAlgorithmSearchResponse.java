package Server.Responses;

import lombok.Getter;
import lombok.Setter;

import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by osech on 12.05.2018.
 */
public class GetListAlgorithmSearchResponse implements IResponse{

    class Algorithm{
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

        public Algorithm(String own, String alg, String desc, int c, String lang) {
            owner = own;
            namealg = alg;
            description = desc;
            cost = c;
            language = lang;
        }
    }

    @Getter
    @Setter
    List<Algorithm> algorithms;

    public GetListAlgorithmSearchResponse()
    {
        algorithms = new ArrayList();
    }

    public void Add(String owner, String namealg, String description, int cost, String language)
    {
        algorithms.add(new Algorithm(owner,namealg,description,cost,language));
    }

}
