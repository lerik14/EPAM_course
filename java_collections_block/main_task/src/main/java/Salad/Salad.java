package Salad;

import Vegetables.Vegetable;

import java.util.HashMap;
import java.util.Map;

public class Salad {

    public String saladName;
    public Map<Vegetable, Integer> ingredientsWithWeightInGr;

    public Salad(String saladName, HashMap<Vegetable, Integer> ingredientsWithWeightInGr) {
        this.saladName = saladName;
        this.ingredientsWithWeightInGr = ingredientsWithWeightInGr;
    }

    @Override
    public String toString() {
        return "Salad{" +
                "saladName='" + saladName + '\'' +
                ", ingredientsWithWeightInGr=" + ingredientsWithWeightInGr +
                '}';
    }
}
