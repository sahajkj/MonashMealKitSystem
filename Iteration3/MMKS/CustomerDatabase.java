import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Manages the Customer Database of customer.
 *
 * @author Anna Mary Almeida, Sahaj kishor Jain, Gefferson Nelson
 * @version 22/05/2022
 */
public class CustomerDatabase {
    private ArrayList<Customer> customerList;

    CustomerDatabase()
    {
        customerList = new ArrayList<>(); //have to read from a file
        readCustomerFile("src\\customers.txt");
    }

    public ArrayList<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(ArrayList<Customer> customerList) {
        this.customerList = customerList;
    }

    public void insertCustomer(Customer customer)
    {
        customerList.add(customer);
    }

    public void readCustomerFile(String filename)
    {
        String customerId;
        String customerEmail;
        String customerPassword;
        String customerFName;
        String customerLName;
        String customerGender;
        String customerDOB;
        String customerPhno;
        String customerAddress;
        String customerReferralCode;
        String cardName;
        String cardNumber;
        String cardExpiry;
        String cardCVV;
        ArrayList<String> customerAllergen;
        ArrayList<MealKit> mealKitList;
        try
        {
            FileReader inputFile = new FileReader(filename);
            try
            {
                Scanner parser = new Scanner(inputFile);
                while(parser.hasNext())
                {
                    String line = parser.nextLine();
                    String[] newLine = line.split("\\|");
                    customerId = newLine[0];
                    customerEmail = newLine[1];
                    customerPassword = newLine[2];
                    customerFName = newLine[3];
                    customerLName = newLine[4];
                    customerGender = newLine[5];
                    customerDOB = newLine[6];
                    customerAllergen = new ArrayList<>(Arrays.asList(newLine[7].split(",")));
                    customerPhno = newLine[8];
                    customerAddress = newLine[9];
                    customerReferralCode = newLine[10];
//                    for(String weekNum : newLine[11].split(","))
//                    {
//
//                    }
                    cardName = newLine[11];
                    cardNumber = newLine[12];
                    cardExpiry = newLine[13];
                    cardCVV = newLine[14];
                    mealKitList = readMealKitData(customerId);
                    Customer customer =new Customer(customerId,customerEmail,customerPassword,customerFName,
                            customerLName,customerGender,customerDOB,customerAllergen,customerPhno,customerAddress,
                            customerReferralCode,mealKitList,new Payment(cardName,cardNumber,cardExpiry,cardCVV));
                    customerList.add(customer);
                }
            }
            finally {
                inputFile.close();
            }
        }
        catch(FileNotFoundException e) {
            System.out.println("Customer file not found");
        }
        catch(IOException e){
            System.out.println("Unexpected I/O exception");
        }
    }

    private ArrayList<MealKit> readMealKitData(String customerId) {
        ArrayList<MealKit> mealKitList = new ArrayList<>();
        try {
            FileReader inFile = new FileReader("src\\kits_" + customerId + ".txt");
            Scanner scanner = new Scanner(inFile);
            while (scanner.hasNextLine()) {
                MealKit mealKit = new MealKit();
                String[] line = scanner.nextLine().split("\\|");
                int weekNumber = Integer.parseInt(line[0].substring(4));
                mealKit.setMealKitWeek(weekNumber);
                String kitStatus = line[1];
                mealKit.setMealWeekStatus(kitStatus);
                String kitDate = line[2];
                mealKit.setMealKitDate(kitDate);
                int servingSize = Integer.parseInt(line[3]);
                mealKit.setMealServingSize(servingSize);
                Meal meal;
                MealDatabase mealDatabase = new MealDatabase();
                String[] mealTag = line[4].split(",");
                String[] mealList = line[5].split(",");
                for (int i = 0 ; i < mealList.length ; i++)
                {
                    meal = mealDatabase.getMeal(Integer.parseInt(mealList[i]) - 1);
                    meal.setMealTag(mealTag[i]);
                    if (meal.getMealTag().equalsIgnoreCase("L")) {
                        if (meal.getMealName().contains("Chicken"))
                            meal.setMealName(meal.getMealName().replace("Chicken", "Lamb"));
                        else
                            meal.setMealName(meal.getMealName().replace("Beef", "Lamb"));
                    }
                    else if (meal.getMealTag().equalsIgnoreCase("B"))
                    {
                        if(meal.getMealName().contains("Chicken"))
                            meal.setMealName(meal.getMealName().replace("Chicken", "Beef"));
                        else
                            meal.setMealName(meal.getMealName().replace("Lamb", "Beef"));
                    }
                    else
                    {
                        if (meal.getMealName().contains("Lamb"))
                            meal.setMealName(meal.getMealName().replace("Lamb", "Chicken"));
                        else
                            meal.setMealName(meal.getMealName().replace("Beef", "Chicken"));
                    }
                    mealKit.getMealList().add(meal);
                }
                mealKitList.add(mealKit);
            }
        }
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        return mealKitList;
    }

    /**
     * write method - writes into the file that is input by the user
     *
     * @param filename the name of the file to write in
     */
    public void writeMealKitData(String filename)
    {
        try
        {
            String output = "";
            PrintWriter outfile = new PrintWriter(filename);
            for (Customer customer : customerList)
            {
                for (MealKit mealKit : customer.getCustMealKit()) {
                    output = "week" + mealKit.getMealKitWeek() + "|" + mealKit.getMealWeekStatus() + "|"+ mealKit.getMealKitDate() + "|" + mealKit.getMealServingSize() + "|" ;
                    for (Meal meal : mealKit.getMealList())
                        output = output.concat(meal.getMealTag() + ",");
                    output = output.concat("|");
                    for (Meal meal : mealKit.getMealList())
                        output = output.concat(meal.getMealID() + ",");
                    output = output.concat("\n");
                    outfile.print(output);
                }
            }
            outfile.close();
        }
        
        catch (IOException exception)
        {
            System.out.println("Unexpected I/O exception");
        }
    }
}
