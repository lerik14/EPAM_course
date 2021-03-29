package Vegetables;

public abstract class Vegetable {

    private String name;
    private int caloriesPer100gr;

    public Vegetable(String name, int caloriesPer100gr) {
        this.caloriesPer100gr = caloriesPer100gr;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getCaloriesPer100gr() {
        return caloriesPer100gr;
    }

    @Override
    public String toString() {
        return name;
    }
}
