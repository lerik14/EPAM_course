import java.util.Arrays;
import java.util.List;

public class ClassesMainTaskMain { //Main tasks in Java Classes block

    public static void main(String[] args) {

//        6. House: id, Номер квартиры, Площадь, Этаж, Количество комнат, Улица, Тип здания, Срок эксплуатации.
//         Создать массив объектов. Вывести:

        House house1 = new House.HouseBuilder(1)
                .setFlatNumber(343)
                .setFloor(15)
                .setSquare(79.8)
                .setStreet("Lenina")
                .setRoomNumber(3)
                .build();

        House house2 = new House.HouseBuilder(2)
                .setFlatNumber(79)
                .setFloor(7)
                .setSquare(56.9)
                .setStreet("Lenina")
                .setRoomNumber(2)
                .build();

        House house3 = new House.HouseBuilder(3)
                .setFlatNumber(2)
                .setFloor(5)
                .setSquare(25.7)
                .setStreet("Lenina")
                .setRoomNumber(1)
                .build();

        House house4 = new House.HouseBuilder(4)
                .setFlatNumber(57)
                .setFloor(3)
                .setSquare(35.4)
                .setRoomNumber(2)
                .setStreet("Lenina")
                .build();

        House house5 = new House.HouseBuilder(5)
                .setFlatNumber(196)
                .setFloor(9)
                .setSquare(20.3)
                .setRoomNumber(1)
                .setStreet("Lenina")
                .build();

        List<House> initialHouseList = Arrays.asList(house1, house2, house3, house4, house5);

        // a) список квартир, имеющих заданное число комнат;
        System.out.println("Enter the number of rooms:");
        int numberOfRooms = HouseUtils.readIntFromConsole();
        List<House> byNumberOfRoomsHouseList = HouseUtils.getHousesByNumberOfRooms(numberOfRooms, initialHouseList);
        HouseUtils.printHouseListToConsole(byNumberOfRoomsHouseList);

        //c) список квартир, имеющих площадь, превосходящую заданную.
        System.out.println("Enter the minimum square value:");
        int minSquare = HouseUtils.readIntFromConsole();
        List<House> withSquareGreaterThanHouseList = HouseUtils.getHousesWithSquareGreaterThan(minSquare, initialHouseList);
       HouseUtils.printHouseListToConsole(withSquareGreaterThanHouseList);

        //b) список квартир, имеющих заданное число комнат и расположенных на этаже, который находится в заданном промежутке;
        System.out.println("Enter the number of rooms:");
        numberOfRooms = HouseUtils.readIntFromConsole();
        System.out.println("Enter the minimum floor:");
        int minFloor = HouseUtils.readIntFromConsole();
        System.out.println("Enter the maximum floor:");
        int maxFloor = HouseUtils.readIntFromConsole();
        List<House> byNumberOfRoomsAndFloorHouseList = HouseUtils.getHousesByNumberOfRoomsAndFloor(numberOfRooms, minFloor, maxFloor, initialHouseList);
        HouseUtils.printHouseListToConsole(byNumberOfRoomsAndFloorHouseList);
    }
}
