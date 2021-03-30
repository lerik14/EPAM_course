public class House {
    private final int id;
    private Integer flatNumber;
    private Double square;
    private Integer floor;
    private Integer numberOfRooms;
    private String street;
    private String buildingType;
    private Double lifetime;

//  I commented constructors because I decided to use design pattern builder. Left them only to show you that I can create them.
//    public House(int id, int flatNumber, int floor, int roomNumber, String street) {
//        this.id = id;
//        this.flatNumber = flatNumber;
//        this.floor = floor;
//        this.roomNumber = roomNumber;
//        this.street = street;
//    }

//    public House(int id, int flatNumber, double square, int floor, String street, String buildingType) {
//        this.id = id;
//        this.flatNumber = flatNumber;
//        this.square = square;
//        this.floor = floor;
//        this.street = street;
//        this.buildingType = buildingType;
//    }

    private House(HouseBuilder builder) {
        this.id = builder.id;
        this.flatNumber = builder.flatNumber;
        this.square = builder.square;
        this.floor = builder.floor;
        this.numberOfRooms = builder.numberOfRooms;
        this.street = builder.street;
        this.buildingType = builder.buildingType;
        this.lifetime = builder.lifetime;
    }

    public int getId() {
        return id;
    }

    public int getFlatNumber() {
        return flatNumber;
    }

    public int getFloor() {
        return floor;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public String getStreet() {
        return street;
    }

    public String getBuildingType() {
        return buildingType;
    }

    public double getLifetime() {
        return lifetime;
    }

    public double getSquare() {
        return square;
    }

    public void setFlatNumber(int flatNumber) {
        this.flatNumber = flatNumber;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public void setRoomNumber(int roomNumber) {
        this.numberOfRooms = roomNumber;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setBuildingType(String buildingType) {
        this.buildingType = buildingType;
    }

    public void setLifetime(double lifetime) {
        this.lifetime = lifetime;
    }


    @Override
    public String toString() {
        return "House{" +
                "id = " + this.id +
                ", flat Number = " + this.flatNumber +
                ", square = " + this.square +
                ", floor = " + this.floor +
                ", roomNumber = " + this.numberOfRooms +
                ", street = '" + this.street + '\'' +
                ", buildingType= '" + this.buildingType + '\'' +
                ", lifetime = " + this.lifetime +
                '}';
    }

    public static class HouseBuilder {

        private final int id; // required parameter
        private int flatNumber;
        private double square;
        private int floor;
        private int numberOfRooms;
        private String street;
        private String buildingType;
        private double lifetime;

        public HouseBuilder(int id) {
            this.id = id;
        }

        public HouseBuilder setFlatNumber(int flatNumber) {
            this.flatNumber = flatNumber;
            return this;
        }

        public HouseBuilder setSquare(double square) {
            this.square = square;
            return this;
        }

        public HouseBuilder setFloor(int floor) {
            this.floor = floor;
            return this;
        }

        public HouseBuilder setRoomNumber(int roomNumber) {
            this.numberOfRooms = roomNumber;
            return this;
        }

        public HouseBuilder setStreet(String street) {
            this.street = street;
            return this;
        }

        public HouseBuilder setBuildingType(String buildingType) {
            this.buildingType = buildingType;
            return this;
        }

        public HouseBuilder setLifetime(double lifetime) {
            this.lifetime = lifetime;
            return this;
        }

        public House build() {
            return new House(this);
        }
    }
}
