import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Manages the Meal Database of customer.
 *
 * @author Anna Mary Almeida, Sahaj kishor Jain, Gefferson Nelson
 * @version 22/05/2022
 */
public class MealDatabase {

    private ArrayList<Meal> mealList;

    public MealDatabase() {
        mealList = new ArrayList<>();
        readMealDatabase("meals.txt");
    }

    public ArrayList<Meal> getMealList() {
        return mealList;
    }

    public void setMealList(ArrayList<Meal> mealList) {
        this.mealList = mealList;
    }

    public Meal getMeal(int index) {
        return mealList.get(index);
    }

    public int getSizeOfMealList(){
        return mealList.size();
    }

    public void displayMealListDetail()
    {
        int serialNumber = 1;
        System.out.println("The Meal details are: ");
        for (Meal meal : mealList)
        {
            System.out.print("(" + serialNumber + ") ");
            meal.displayMeal();
            serialNumber++;
        }
    }

    public void displayMealName()
    {
        int serialNumber = 1;
        System.out.println("Meal Menu: ");
        for (Meal meal : mealList)
        {
            System.out.print("(" + serialNumber + ") ");
            System.out.println(meal.getMealName() + " (" + meal.getMealTag() + ")");
            serialNumber++;
        }
    }

    /**
     * read method - reads the file that is input by the user
     *
     * @param filename the name of the file to read
     */
    public void readMealDatabaseNew(String filename) {
        try {
            FileReader inputFile = new FileReader(filename);
            try
            {
                Scanner parser = new Scanner(inputFile);
                while (parser.hasNextLine())
                {
                    String line = parser.nextLine();
                    String[] newLine = line.split(",");
                    for (String string : newLine)
                        mealList.add(readMealFile(string));
                }
            }
            finally
            {
                inputFile.close();
            }
        }
        catch (FileNotFoundException exception)
        {
            System.out.println(filename + " not found");
        }
        catch (IOException exception)
        {
            System.out.println("Unexpected I/O exception");
        }
    }

    /**
     * read method - reads the file that is input by the user
     *
     * @param filename the name of the file to read
     */
    public void readMealDatabase(String filename) {
        int mealID;
        String mealName;
        String mealTag;
        String mealIngredient;
        String mealStep;
        String mealTime;
        ArrayList<String> mealAllergenWarning = new ArrayList<>();
        try {
            FileReader inputFile = new FileReader(filename);
            try
            {
                Scanner parser = new Scanner(inputFile);
                while (parser.hasNextLine())
                {
                    String line = parser.nextLine();
                    String[] newLine = line.split("\\|");
                    mealID = Integer.parseInt(newLine[0]);
                    mealName = newLine[1];
                    mealTag = newLine[2];
                    mealIngredient = newLine[3];
                    mealTime = newLine[4];
                    mealStep = newLine[5];
                    mealAllergenWarning.addAll(Arrays.asList(newLine[6].split(",")));
                    if(mealTag.equalsIgnoreCase("C") | mealTag.equalsIgnoreCase("L") | mealTag.equalsIgnoreCase("B"))
                        mealList.add(new AdjustableProteinMeal(mealID,mealName,mealTag,mealIngredient,mealStep,mealTime,mealAllergenWarning));
                    else
                        mealList.add(new FixedProteinMeal(mealID,mealName,mealTag,mealIngredient,mealStep,mealTime,mealAllergenWarning));
                }
            }
            finally
            {
                inputFile.close();
            }
        }
        catch (FileNotFoundException exception)
        {
            System.out.println(filename + " not found");
        }
        catch (IOException exception)
        {
            System.out.println("Unexpected I/O exception");
        }
    }

    /**
     * read method - reads the file that is input by the user
     *
     * @param string the name of the file to read
     */
    private Meal readMealFile(String string)
    {
        int mealID;
        String mealName;
        String mealTag;
        String mealIngredient;
        String mealStep;
        //int mealCost;
        String mealTime;
        ArrayList<String> mealAllergenWarning = new ArrayList<>();
        Meal meal = new Meal();
        try
        {
            FileReader inputFile = new FileReader("src\\" + string);
            try
            {
                Scanner parser = new Scanner(inputFile);
                while (parser.hasNextLine())
                {
                    String line = parser.nextLine();
                    String[] newLine = line.split("\\|");
                    int i = 0;
                    mealID = Integer.parseInt(newLine[0]);
                    mealName = newLine[1];
                    mealTag = newLine[2];
                    mealIngredient = newLine[3];
                    mealTime = newLine[4];
                    mealStep = newLine[5];
                    int num = 0;
                    //mealCost = Integer.parseInt(newLine[5]);
                    mealAllergenWarning.addAll(Arrays.asList(newLine[6].split(",")));
                    if(mealTag.equalsIgnoreCase("C"))
                        meal = new AdjustableProteinMeal(mealID,mealName,mealTag,mealIngredient,mealStep,mealTime,mealAllergenWarning);
                    else
                        meal = new FixedProteinMeal(mealID,mealName,mealTag,mealIngredient,mealStep,mealTime,mealAllergenWarning);
                }
            }
            finally
            {
                inputFile.close();
            }
        }
        catch (FileNotFoundException exception)
        {
            System.out.println(string + " not found");
        }
        catch (IOException exception)
        {
            System.out.println("Unexpected I/O exception");
        }
        return meal;
    }
}