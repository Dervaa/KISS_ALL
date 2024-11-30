package LAB4.Model;

import javax.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CodeValidatedStation {

    @NotNull(message = "Название станции не должно быть пустым")
    @Pattern(regexp = "^[A-Za-zА-Яа-яЁё\\s]+$", message = "Название должно содержать только буквы и пробелы")
    private String name;

    // Код станции (не менее 2 букв и 1 цифры)
    @NotNull(message = "Код станции не должен быть пустым")
    @Pattern(regexp = "^(?=(.*[A-Za-zА-Яа-я]){2,})(?=(.*\\d)){1,}.*$", message = "Код станции должен содержать хотя бы 2 буквы и 1 цифру")
    private String stationCode;

    @Min(value = 1, message = "Минимальное количество платформ — 1")
    @Max(value = 10, message = "Максимальное количество платформ — 10")
    private int numberOfPlatforms;

    @Min(value = 0, message = "Вместимость платформы не может быть отрицательной")
    private int platformCapacity;
}
