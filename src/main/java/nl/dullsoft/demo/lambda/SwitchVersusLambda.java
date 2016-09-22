package nl.dullsoft.demo.lambda;

import java.util.*;
import java.util.function.Supplier;

/**
 * This is an example demonstrating how a switch statement can be replaced with lambda's.
 */
public class SwitchVersusLambda {

    private Map<Bicycle, Supplier<List<String>>> typeMap = new HashMap<Bicycle, Supplier<List<String>>>() {
        {
            put(Bicycle.RACE, () -> listRacers());
            put(Bicycle.ATB, () -> listAtbs());
            put(Bicycle.CITY, () -> listCityBikes());
            put(Bicycle.HPV, () -> listHumanPoweredVehicles());
        }
    };

    public List<String> findUsingSwitch(Bicycle bicycle) {
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

    public List<String> findUsingLambdas(Bicycle bicycle) {
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
        return Arrays.asList("Scott Scale 940", "Cube Aim Pro 29", "Sensa Livigno", "Trek Superfly 8");
    }

    private List<String> listCityBikes() {
        // Retrieve a list of all City bikes
        return Arrays.asList("Giant Expedition", "Koga Myata Traveller", "Cube Touring");
    }

    private List<String> listHumanPoweredVehicles() {
        // Retrieve a list of all HPVs
        return Arrays.asList("Ace R.A.R", "Nazca Gaucho 28 highracer");
    }
}
