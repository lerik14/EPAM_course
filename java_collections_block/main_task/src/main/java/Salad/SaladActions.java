package Salad;

import Vegetables.Vegetable;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SaladActions {

    public List<Vegetable> sortIngredientsByCaloriesPer100gr(List<Vegetable> listOfIngredients) {
        listOfIngredients.sort(Comparator.comparingInt(Vegetable::getCaloriesPer100gr));
        return listOfIngredients;
    }

    public Map<Vegetable, Double> filterSaladIngredientsByCaloriesRange(int minCalories, int maxCalories, Salad salad) {
       return salad.ingredientsWithWeightInGr.entrySet().stream().filter(
                entry -> countCaloriesPerWeight(entry) >= minCalories && countCaloriesPerWeight(entry) <= maxCalories)
               .collect(Collectors.toMap(Map.Entry::getKey, this::countCaloriesPerWeight));
    }

    public double countCaloriesPerWeight(Map.Entry<Vegetable, Integer> entry) {
        return entry.getKey().getCaloriesPer100gr() * entry.getValue() / 100.0;
    }
    
    public double countCaloriesInSalad(Salad salad) {
        double calories = 0;
        for (Map.Entry<Vegetable, Integer> entry : salad.ingredientsWithWeightInGr.entrySet()) {
            calories += countCaloriesPerWeight(entry);
        }
        return calories;
    }
}
