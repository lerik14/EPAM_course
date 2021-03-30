package Vegetables;

public class RegularVegetable extends Vegetable {

    private String variety;

    public RegularVegetable(String name, String variety, int caloriesPer100gr) {
        super(name, caloriesPer100gr);
        this.variety = variety;
    }
    public RegularVegetable(String name, int caloriesPer100gr) {
        super(name, caloriesPer100gr);
    }

    public String getVariety() {
        return variety;
    }

    @Override
    public String toString() {
        return  getName() +"-"+ variety;
    }
}
