import java.util.ArrayList;

/**
 * Class created to have only certain meals that can have their protein changed.
 * This class inherits the Meal class
 *
 * @author Gefferson Nelson
 * @version 22/05/2022
 */

public class FixedProteinMeal extends Meal{
    public FixedProteinMeal(int mealID, String mealName, String mealTag, String mealIngredient, String mealStep, String mealTime, ArrayList<String> mealAllergenWarning) {
        super(mealID, mealName, mealTag, mealIngredient, mealStep, mealTime, mealAllergenWarning);
    }
}
