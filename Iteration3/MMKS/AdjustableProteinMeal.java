import java.util.ArrayList;

/**
 * Class created to have only certain meals that can have their protein changed.
 * This class inherits the Meal class
 *
 * @author Gefferson Nelson
 * @version 22/05/2022
 */
public class AdjustableProteinMeal extends Meal{

    /**\
     * Parameterised constructer for AdjustableProteinMeal
     *
     * @param mealID Meal ID
     * @param mealName Meal Name
     * @param mealTag Meal Tag
     * @param mealIngredient Ingredients for a Meal
     * @param mealStep steps to cook the meal
     * @param mealTime preparation time
     * @param mealAllergenWarning Allergen
     */
    public AdjustableProteinMeal(int mealID, String mealName, String mealTag, String mealIngredient, String mealStep, String mealTime, ArrayList<String> mealAllergenWarning)
    {
        super(mealID, mealName, mealTag,mealIngredient, mealStep, mealTime, mealAllergenWarning);
    }
}