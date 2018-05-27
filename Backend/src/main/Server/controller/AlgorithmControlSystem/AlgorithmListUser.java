package Server.controller.AlgorithmControlSystem;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.Setter;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class AlgorithmListUser {
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

    public AlgorithmListUser(String alg, String desc, int c, String lang) {
        namealg = alg;
        cost = c;
        language = lang;
    }
}
