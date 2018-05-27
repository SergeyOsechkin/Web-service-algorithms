package Server.Responses;

import Server.controller.AlgorithmControlSystem.AlgorithmUser;
import lombok.Getter;
import lombok.Setter;


public class GetAlgorithmUserResponse implements IResponse {
    @Getter
    @Setter
    public AlgorithmUser algorithm;

    public GetAlgorithmUserResponse(String desc, int cost, String lang,String source,String test)
    {
        algorithm = new AlgorithmUser(desc,cost,lang,source,test);
    }
}
