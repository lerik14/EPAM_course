import Vegetables.Herb;
import Vegetables.LeafyVegetable;
import Vegetables.RegularVegetable;
import Vegetables.Vegetable;

import java.util.ArrayList;
import java.util.List;

public class Ingredients {

    public static final Vegetable SPINACH = new LeafyVegetable("spinach", 20);
    public static final Vegetable TOMATO_CHERRY = new RegularVegetable("tomato", "cherry",35);
    public static final Vegetable TOMATO_PLUM = new RegularVegetable("tomato", "plum",40);
    public static final Vegetable CUCUMBER_PICKLING = new RegularVegetable("cucumber", "pickling",18);
    public static final Vegetable PARSLEY = new Herb("parsley", 15);
    public static final Vegetable BASIL = new Herb("basil", 10);

    public static List<Vegetable> listOfIngredients = new ArrayList<>();
    static {
        listOfIngredients.add(SPINACH);
        listOfIngredients.add(TOMATO_PLUM);
        listOfIngredients.add(TOMATO_CHERRY);
        listOfIngredients.add(PARSLEY);
        listOfIngredients.add(CUCUMBER_PICKLING);
        listOfIngredients.add(BASIL);
    }
}
