package Server.controller.AlgorithmControlSystem;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.Setter;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class AlgorithmListSearch {
    @Setter
    @Getter
    String namealg;
    public AlgorithmListSearch(String n){
        namealg = n;
    }
}
