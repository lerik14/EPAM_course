import Salad.Salad;
import Salad.SaladActions;
import Vegetables.Vegetable;

import java.util.HashMap;

public class MainTaskMain {

    public static void main(String[] args) {

       SaladActions saladActions = new SaladActions();
       System.out.println("Sorted list of ingredients by calorie content per 100 gram:");
       System.out.println(saladActions.sortIngredientsByCaloriesPer100gr(Ingredients.listOfIngredients));

        HashMap<Vegetable, Integer> ingredientsForChefSalad = new HashMap<Vegetable, Integer>() {{
            put(Ingredients.TOMATO_CHERRY, 150);
            put(Ingredients.SPINACH, 100);
            put(Ingredients.PARSLEY, 30);
            put(Ingredients.BASIL, 30);
        }};
        ingredientsForChefSalad.put(Ingredients.CUCUMBER_PICKLING, 159);
        Salad chefSalad = new Salad("chef's salad", ingredientsForChefSalad);

        HashMap<Vegetable, Integer> ingredientsForRussianSalad = new HashMap<Vegetable, Integer>() {{
            put(Ingredients.TOMATO_PLUM, 200);
            put(Ingredients.CUCUMBER_PICKLING, 200);
        }};
        Salad russianSalad = new Salad("russian salad", ingredientsForRussianSalad);

        System.out.println("Filtered list of ingredients in salad by calories range:");
        System.out.println("Chef's salad: " + saladActions.filterSaladIngredientsByCaloriesRange(4, 50, chefSalad));
        System.out.println("Russian salad: " + saladActions.filterSaladIngredientsByCaloriesRange(25, 100, russianSalad));

        System.out.println("Number of calories in salad:");
        System.out.println("Chef's salad: " + saladActions.countCaloriesInSalad(chefSalad));
        System.out.println("Russian salad: " + saladActions.countCaloriesInSalad(russianSalad));
    }
}
