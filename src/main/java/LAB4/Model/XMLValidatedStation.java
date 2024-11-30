package LAB4.Model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class XMLValidatedStation {

    private String name;
    private String stationCode;
    private int numberOfPlatforms;
    private int platformCapacity;
}
