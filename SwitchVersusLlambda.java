package nl.dullaart.demo;

import java.util.*;
import java.util.function.Supplier;

/**
 * Created by marcel on 15-9-2016.
 */
public class SwitchVersusLlambda {

    private Map<Bicycle, Supplier<List<String>>> typeMap = new HashMap<Bicycle, Supplier<List<String>>>() {
        {
            put(Bicycle.RACE, () -> listRacers());
            put(Bicycle.ATB, () -> listAtbs());
            put(Bicycle.CITY, () -> listCityBikes());
            put(Bicycle.HPV, () -> listHumanPoweredVehicles());
        }
    };

    public List<String> find(Bicycle bicycle) {
        switch (bicycle) {
            case RACE:
                return listRacers();
            case ATB:
                return listAtbs();
            case CITY:
                return listCityBikes();
            case HPV:
                return listHumanPoweredVehicles();
            default:
                throw new IllegalArgumentException();
        }
    }

    public List<String> find2(Bicycle bicycle) {
        if (!typeMap.containsKey(bicycle)) {
            throw new IllegalArgumentException(String.format("%s is not supported", bicycle));
        }

        return typeMap.get(bicycle).get();
    }

    private List<String> listRacers() {
        return Arrays.asList("Sensa Romagna", "Jan Jansen Tour de France", "Bianchi Specialissima");
    }

    private List<String> listAtbs() {
        // Retrieve a list of all ATBs
        return new ArrayList<>();
    }

    private List<String> listCityBikes() {
        // Retrieve a list of all City bikes
        return new ArrayList<>();
    }

    private List<String> listHumanPoweredVehicles() {
        // Retrieve a list of all HPVs
        return new ArrayList<>();
    }
}

enum Bicycle {
    RACE,
    ATB,
    CITY,
    HPV;
}
