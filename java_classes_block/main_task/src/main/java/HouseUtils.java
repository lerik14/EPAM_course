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
}
