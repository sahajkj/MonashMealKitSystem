import java.util.ArrayList;

/**
 * Manages the Meals.
 *
 * @author Anna Mary Almeida, Sahaj kishor Jain, Gefferson Nelson
 * @version 22/05/2022
 */
public class Meal {
    private int mealID;
    private String mealName;
    private String mealTag;
    private String mealIngredient;
    private String mealStep;
    private String mealTime;
    private ArrayList<String> mealAllergenWarning;

    public Meal()
    {
    }

    public Meal(int mealID, String mealName, String mealTag,String mealIngredient, String mealStep, String mealTime, ArrayList<String> mealAllergenWarning) {
        this.mealID = mealID;
        this.mealName = mealName;
        this.mealTag = mealTag;
        this.mealIngredient = mealIngredient;
        this.mealStep = mealStep;
        this.mealTime = mealTime;
        this.mealAllergenWarning = mealAllergenWarning;
    }

    public void displayMeal() {
        System.out.println(getMealName() + "(" + getMealTag() + ")");
        System.out.println("Ingredients:");
        System.out.println(getMealIngredient());
        System.out.println("Prep Time:" + getMealTime());
        System.out.println("Steps:");
        System.out.println(getMealStep());
        System.out.println("Allergen Warning: ");
        System.out.println(getMealAllergenWarning());
        System.out.println("\n\n");
    }

    public int getMealID() {
        return mealID;
    }

    public void setMealID(int mealID) {
        this.mealID = mealID;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public String getMealTag() {
        return mealTag;
    }

    public void setMealTag(String mealTag) {
        this.mealTag = mealTag;
    }

    public String getMealIngredient() {
        return mealIngredient;
    }

    public void setMealIngredient(String mealIngredient) {
        this.mealIngredient = mealIngredient;
    }

    public String getMealStep() {
        return mealStep;
    }

    public void setMealStep(String mealStep) {
        this.mealStep = mealStep;
    }

    public String getMealTime() {
        return mealTime;
    }

    public void setMealTime(String mealTime) {
        this.mealTime = mealTime;
    }

    public ArrayList<String> getMealAllergenWarning() {
        return mealAllergenWarning;
    }

    public void setMealAllergenWarning(ArrayList<String> mealAllergenWarning) {
        this.mealAllergenWarning = mealAllergenWarning;
    }
}

