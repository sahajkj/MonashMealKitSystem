import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
/**
 * Manages the Meal Kit details of customer.
 *
 * @author Anna Mary Almeida, Sahaj kishor Jain, Gefferson Nelson
 * @version 22/05/2022
 */
public class MealKit {
    private int mealServingSize;
    private ArrayList<Meal> mealList;
    private int mealKitWeek;
    private String mealKitDate;
    private String mealWeekStatus;
    private ArrayList<String> mealListTag;

    public MealKit() {
        mealServingSize = 0;
        mealList = new ArrayList<>();
        mealKitWeek = 0;
        mealKitDate = null;
        mealWeekStatus = "A";
        mealListTag = new ArrayList<>();
    }
    public MealKit(int weekNumber,String weekStatus ,String kitDate, int servingSize,ArrayList<String> mealTag, ArrayList<Meal> listOfMeals)
    {
        mealServingSize = servingSize;
        mealList = listOfMeals;
        mealKitWeek = weekNumber;
        mealKitDate = kitDate;
        mealWeekStatus = weekStatus;
        mealListTag = mealTag;
    }

    /**
     * display method - to display the meals of the customer
     */
    public void displayMeal()
    {
        if (mealKitWeek == 3)
            System.out.print("Current Week" + " \t");

        System.out.println("\t Date: " +  mealKitDate);
        int serialNumber = 1;
        for(Meal meal : mealList)
        {
            System.out.print("(" + serialNumber++ + ")");
            System.out.println(meal.getMealName() + " ("+ meal.getMealTag() + ")");
        }
        System.out.println("\t Serving Size: " + mealServingSize + "\n");

    }

    /**
     * display method - to display the meal kit of the customer
     */
    public void displayMealKit()
    {
        if (mealKitWeek == 3)
            System.out.print("Current Week" + " \t");
        System.out.println("\t Date: " +  mealKitDate);
        System.out.println("Serving Size: " + mealServingSize);
        for(Meal meal : mealList)
            meal.displayMeal();
    }

    /**
     * display method - to display the meal kit status of the customer
     */
    public void displayMealKitStatus()
    {
        if (mealKitWeek == 3)
            System.out.print("Current Week" + " \t");
        System.out.println("\t cdfDate: " +  mealKitDate);
        System.out.print("Serving Size: " + mealServingSize + " \t");

        if(mealWeekStatus.equalsIgnoreCase("S"))
            System.out.println("\t Status: This week has been Skipped");
        else
            System.out.println("\t Status: This weeks meal is being Prepared");
        int serialNumber = 1;
        for(Meal meal : mealList)
        {
            System.out.print("(" + serialNumber++ + ")");
            System.out.println(meal.getMealName() + " ("+ meal.getMealTag() + ")");
        }
    }

    /**
     * accessor method - returns the meal tag
     *
     * @return    the meal tag
     */
    public ArrayList<String> getMealListTag() {
        return mealListTag;
    }

    /**
     * mutator method - sets a list of meal tag of the current meal kit
     *
     * @param  mealListTag  a list of meal tags
     */
    public void setMealListTag(ArrayList<String> mealListTag) {
        this.mealListTag = mealListTag;
    }

    /**
     * accessor method - returns the status of the meal
     *
     * @return    the meal week status
     */
    public String getMealWeekStatus() {
        return mealWeekStatus;
    }

    /**
     * mutator method - sets a status o the weeks meal
     *
     * @param  mealWeekStatus  a list of meal week status
     */
    public void setMealWeekStatus(String mealWeekStatus) {
        this.mealWeekStatus = mealWeekStatus;
    }

    /**
     * add method - adds the meal of the customer
     *
     * @param meal adds meal
     */
    public void addMeal(Meal meal){
        mealList.add(meal);
    }

    /**
     * change size method - changes the serving size of the meal
     *
     * @param size change the size
     */
    public void changeServingSize(int size){
        setMealServingSize(size);
    }

    /**
     * accessor method - returns the serving size
     *
     * @return    the weeks meals serving size
     */
    public int getMealServingSize() {
        return mealServingSize;
    }

    /**
     * mutator method - sets the size of weeks meal
     *
     * @param  servingSize  a list of meal week status
     */
    public void setMealServingSize(int servingSize) {
        mealServingSize = servingSize;
    }

    /**
     * accessor method - returns the meal list
     *
     * @return    the meals list
     */
    public ArrayList<Meal> getMealList() {
        return mealList;
    }

    /**
     * mutator method - sets the list if meal
     *
     * @param  listOfMeal a list of meals
     */
    public void setMealList(ArrayList<Meal> listOfMeal) {
        mealList = listOfMeal;
    }

    /**
     * accessor method - returns the meal kit week
     *
     * @return    the meals kit week
     */
    public int getMealKitWeek() {
        return mealKitWeek;
    }

    /**
     * mutator method - sets the week
     *
     * @param  weekNumber a week
     */
    public void setMealKitWeek(int weekNumber) {
        mealKitWeek = weekNumber;
    }

    /**
     * accessor method - returns the meal kit date
     *
     * @return    the meals kit date
     */
    public String getMealKitDate() {
        return mealKitDate;
    }

    /**
     * mutator method - sets the date
     *
     * @param  kitDate the date
     */
    public void setMealKitDate(String kitDate) {
        this.mealKitDate = kitDate;
    }

    /**
     * write method - writes into the file that is input by the user
     *
     * @param filename the name of the file to write in
     */
    public void writeCustomerMealKit(String filename)
    {
        try
        {
            PrintWriter outputFile = new PrintWriter(filename);
            outputFile.close();
        }
        catch (IOException exception)
        {
            System.out.println("Unexpected I/O exception");
        }
    }
}
