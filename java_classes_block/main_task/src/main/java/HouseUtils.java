import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HouseUtils {

    public static List<House> getHousesByNumberOfRooms(int numberOfRooms, List<House> houseList) {
        List<House> houseListNew = new ArrayList<>();
        for (House house : houseList) {
            if (house.getNumberOfRooms() == numberOfRooms) {
                houseListNew.add(house);
            }
        }
        return houseListNew;
    }

    public static List<House> getHousesWithSquareGreaterThan(int minSquare, List<House> houseList) {
        return houseList
                .stream()
                .filter(house -> house.getSquare() > minSquare)
                .collect(Collectors.toList());
    }

    public static List<House> getHousesByNumberOfRoomsAndFloor(int numberOfRooms, int minFloor, int maxFloor, List<House> houseList) {
        return houseList
                .stream()
                .filter(house -> house.getNumberOfRooms() == numberOfRooms && house.getFloor() >= minFloor && house.getFloor() <= maxFloor)
                .collect(Collectors.toList());
    }

    public static int readIntFromConsole() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number;
        try {
            number = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            throw new IllegalStateException("Cannot parse input string to integer", e);
        }
        return number;
    }

    public static void printHouseListToConsole(List<House> houseList) {
        if (!houseList.isEmpty()) {
            for (House house : houseList) {
                System.out.println(house.toString());
            }
        } else {
            System.out.println("No apartments with such parameters");
        }
    }
}
