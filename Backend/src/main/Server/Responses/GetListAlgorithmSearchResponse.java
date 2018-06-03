package Server.Responses;

import Server.controller.AlgorithmControlSystem.AlgorithmListSearch;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by osech on 12.05.2018.
 */
public class GetListAlgorithmSearchResponse implements IResponse{

    @Setter
    @Getter
    public List<AlgorithmListSearch> algorithms;

    public GetListAlgorithmSearchResponse()
    {
        algorithms = new ArrayList();
    }

    public void Add(String namealg)
    {
        algorithms.add(new AlgorithmListSearch(namealg));
    }

}
