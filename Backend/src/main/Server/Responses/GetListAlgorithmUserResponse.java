package Server.Responses;

import Server.controller.AlgorithmControlSystem.AlgorithmListUser;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by osech on 12.05.2018.
 */
public class GetListAlgorithmUserResponse implements IResponse{
    @Getter
    @Setter
    public List<AlgorithmListUser> algorithms;

    public GetListAlgorithmUserResponse()
    {
        algorithms = new ArrayList();
    }

    public void Add(String namealg, String description, int cost, String language)
    {
        algorithms.add(new AlgorithmListUser(namealg,description,cost,language));
    }

}
