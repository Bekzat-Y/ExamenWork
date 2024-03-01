package enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)

public enum TypeParkingPlace {
    STANDARD("STANDART"),
    ELECTRICAL("ELECTRICAL"),
    FAMILIAR("FAMILYCAR"),
    DEPRECIABLE("DIABLEPEOPLE");
    String description;
}
