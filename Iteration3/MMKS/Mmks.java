import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Manages the Customer details of their Meal Kits
 *
 * @author Sahaj K Jain, Anna Mary Almeida, Gefferson Nelson
 * @version 22/05/2022
 */

public class Mmks {

    private MealDatabase mealDatabase;
    private CustomerDatabase customerDatabase;

    /**
     * Constructor for objects of class Mmks
     */
    public Mmks() {
        customerDatabase = new CustomerDatabase();
        mealDatabase = new MealDatabase();
    }

    /**
     * add method - to add new meals for the customer
     *
     * @param  customer  adds meals to the customer
     */
    private void addMeal (Customer customer){
        Scanner scan = new Scanner(System.in);
        String serial = "";
        int index;
        while (serial!="0")
        {
            customer.getCurrentMealKit().displayMeal();
            mealDatabase.displayMealName();
            if (customer.getCurrentMealKit().getMealList().size() < 10) {
                System.out.println("Please enter the serial number meals you would like to add (add up to 10 meals)");
                System.out.println("Enter 0 to go back");
                System.out.println();
                serial = scan.nextLine().trim();
                System.out.println();
                if (serial.isBlank() || serial.equalsIgnoreCase("0"))
                    return;
                index = Integer.parseInt(serial);
                Meal meal = mealDatabase.getMeal(index - 1);
                customer.getCurrentMealKit().addMeal(meal);
                customer.getCurrentMealKit().displayMeal();
                System.out.println("Meal Added!!");
                System.out.println();
            } else {
                System.out.println("\nMaximum limit of meals reached\n");
                customer.getCurrentMealKit().displayMeal();
                System.out.println("Press any key to go back");
                scan.nextLine().trim();
                System.out.println();
                serial = "0";
            }
        }
    }

    /**
     * change protein method - to change the protein for meals in the current week
     *
     * @param  meal  Changes the protein of the meal
     */
    private void adjustProteinMeal (Meal meal){
        Scanner scanner = new Scanner(System.in);
        String choice = "";
        System.out.println();
        displayAdjustProteinMeal();
        choice = scanner.nextLine().trim();
        System.out.println();
        switch (choice) {
            case "1":
                if(!meal.getMealTag().equalsIgnoreCase("L"))
                {
                    meal.setMealTag("L");
                    if(meal.getMealName().contains("Chicken"))
                        meal.setMealName(meal.getMealName().replace("Chicken", "Lamb"));
                    else
                        meal.setMealName(meal.getMealName().replace("Beef", "Lamb"));
                }
                else
                    System.out.println("It already contains Lamb");
                break;
            case "2":
                if(!meal.getMealTag().equalsIgnoreCase("B"))
                {
                    meal.setMealTag("B");
                    if(meal.getMealName().contains("Chicken"))
                        meal.setMealName(meal.getMealName().replace("Chicken", "Beef"));
                    else
                        meal.setMealName(meal.getMealName().replace("Lamb", "Beef"));
                }
                else
                    System.out.println("It already contains Beef");
                break;
            case "3":
                if(!meal.getMealTag().equalsIgnoreCase("C")) {
                    meal.setMealTag("C");
                    if (meal.getMealName().contains("Lamb"))
                        meal.setMealName(meal.getMealName().replace("Lamb", "Chicken"));
                    else
                        meal.setMealName(meal.getMealName().replace("Beef", "Chicken"));
                }
                else
                    System.out.println("It already contains Chicken");
                break;
            case "0":
                System.out.println("BACK");
                break;
            default:
                System.out.println("Invalid input, try again");
                break;
        }
    }
    /**
     * change size method - to change the serving size for current week
     *
     * @param  customer  Changes the Serving Size for the current week of a customer
     */
    private void changeSize(Customer customer) {
        Scanner scan = new Scanner(System.in);
        String choice = "";
        System.out.println();
        customer.getCurrentMealKit().displayMeal();
        while (!choice.equals("0")) {
            System.out.println("1.Serving Size = 2\n \tCost = $20");
            System.out.println("2. Serving Size = 4\n \tCost = $30");
            System.out.println("Select from the above options to change serving size or 0 to go back");
            choice = scan.nextLine().trim();
            System.out.println();
            switch (choice) {
                case "1":
                    if(customer.getCurrentMealKit().getMealServingSize() != 2) {
                        customer.getCurrentMealKit().setMealServingSize(2);
                        customer.getCurrentMealKit().displayMeal();
                        System.out.println("Serving size has been changed to 2");
                        System.out.println();
                    }
                    else {
                        System.out.println("The serving size is already 2");
                        System.out.println();
                    }
                    break;
                case "2":
                    if(customer.getCurrentMealKit().getMealServingSize() != 4) {
                        customer.getCurrentMealKit().setMealServingSize(4);
                        customer.getCurrentMealKit().displayMeal();
                        System.out.println("Serving size has been changed to 4");
                        System.out.println();
                    }
                    else {
                        System.out.println("The serving size is already 4");
                        System.out.println();
                    }
                    break;
                case "0":
                    System.out.println("BACK");
                    break;
                default:
                    System.out.println("Invalid input, try again");
                    break;
            }

        }
    }

    /**
     * confirm payment method - Confirms the payment for the current week
     *
     * @param  customer  Confirms the changes made and provides a bill to the customer
     */
    private void confirmPayment (Customer customer) {
        int cost = 0;
        Scanner scan = new Scanner(System.in);
        String input = "";
        String inputName = "";
        String inputNumber = "";
        String inputExpiry = "";
        String inputCVV = "";
        System.out.println("This weeks meal plan subscription");
        MealKit mealkit = customer.getCurrentMealKit();
        int servingSize = mealkit.getMealServingSize();
        for (Meal meal : mealkit.getMealList())
            if (meal.getMealTag().equalsIgnoreCase("B") || meal.getMealTag().equalsIgnoreCase("L")) {
                if (servingSize == 2)
                    cost = cost + 20 + (5 * servingSize);
                else
                    cost = cost + 30 + (5 * servingSize);
            } else {
                if (servingSize == 2)
                    cost = cost + 20;
                else
                    cost = cost + 30;
            }

        mealkit.displayMeal();
        System.out.println("Serving size =" + servingSize);
        System.out.println("Total = $" + cost);
         while (!input.equals("0")) {
             System.out.println();
             System.out.println("********* PAYMENT *********");
             System.out.println("1. To confirm and make payment");
             System.out.println("Enter 0 go back ");
             System.out.println("Please enter from the above options\n");
             input = scan.nextLine().trim();
             System.out.println();
             switch (input) {
                 case "1":
                     System.out.print("Enter Card Name: ");
                     while (!inputName.equals(customer.getPayment().getCardName())) {
                         inputName = scan.nextLine().trim();
                         System.out.println();
                         if (!inputName.equals(customer.getPayment().getCardName()))
                             System.out.println("Please enter valid card name");
                     }
                     System.out.print("Enter Card Number: ");
                     while (!inputNumber.equals(customer.getPayment().getCardNumber())) {
                         inputNumber = scan.nextLine().trim();
                         System.out.println();
                         if (!inputNumber.equals(customer.getPayment().getCardNumber()))
                             System.out.println("Please enter valid card number");
                     }
                     System.out.print("Enter Card Expiry(MM/yy): ");
                     while (!inputExpiry.equals(customer.getPayment().getCardExpiry())) {
                         inputExpiry = scan.nextLine().trim();
                         System.out.println();
                         if (!inputExpiry.equals(customer.getPayment().getCardExpiry()))
                             System.out.println("Please enter valid expiry date");
                     }
                     System.out.print("Enter Card CVV: ");
                     while (!inputCVV.equals(customer.getPayment().getCardCVV())) {
                         inputCVV = scan.nextLine().trim();
                         System.out.println();
                         if (!inputCVV.equals(customer.getPayment().getCardCVV()))
                             System.out.println("Please enter valid CVV date");
                     }
                     System.out.println("Your payment is confirmed. Your meals are on the way!");
                     input = "0";
                     break;
                 case "0":
                     System.out.println("BACK");
                     break;
                 default:
                     System.out.println("Invalid input, try again");
                     break;
             }
         }
    }

    /**
     * Achievement method - counts the total orders placed between the input dates
     *
     * @param  customer customer
     * @param start start date
     * @param end  end date
     */
    private void customerAchievement (Customer customer, Date start, Date end){
        Scanner scanner = new Scanner(System.in);
        String choice = "";
        displayAchievementMenu();
        choice = scanner.nextLine().trim();
        System.out.println();
        System.out.println("Start Date: " + start.toString().substring(0,10) + " " + start.toString().substring(25)
                + "\t End Date: " + end.toString().substring(0,10) + " " + end.toString().substring(25));
        switch (choice) {
            case "1" :
                System.out.println("Number of meals: " + mealCount(customer, start, end));
                System.out.println("Returning to previous menu");
                System.out.println();
                break;
            case "0":
                System.out.println("BACK");
                break;
            default:
                System.out.println("Invalid input, try again");
                break;
        }
    }

    /**
     * display method - displays the achievement menu
     */
    private void displayAchievementMenu() {
        System.out.println("\n********* ACHIEVEMENTS *********");
        System.out.println("1. Number of Meals prepared");
        System.out.println("Enter '0' to go Back");
        System.out.println("Please enter from the above options\n");
    }

    /**
     * display method - displays the Adjust protein meal menu
     */
    private void displayAdjustProteinMeal () {
        System.out.println("\n********* PROTEIN *********");
        System.out.println("1. LAMB");
        System.out.println("2. BEEF");
        System.out.println("3. CHICKEN");
        System.out.println("Enter '0' to go Back");
        System.out.println("Please enter from the above options\n");
    }

    /**
     * display method - displays the edit meal menu
     */
    private void displayEditMealMenu () {
        System.out.println("\n********* EDIT MEALS *********");
        System.out.println("1. Add Meals");
        System.out.println("2. Change Meal Preference Type");
        System.out.println("Enter '0' to go Back");
        System.out.println("Please enter from the above options\n");
    }

    /**
     * display method - displays modify meal menu
     */
    private void displayModifyMealMenu()
    {
        System.out.println("\n********* MODIFY CURRENT MEALS *********");
        System.out.println("1. Edit Meals");
        System.out.println("2. Skip This Week");
        System.out.println("3. Change Serving Size");
        System.out.println("4. Confirm and Continue to Make Payment");
        System.out.println("Enter '0' to go Back");
        System.out.println("Please enter from the above options\n");
    }

    /**
     * display method - displays the order management menu
     */
    private void displayOrderManagementMenu()
    {
        System.out.println("\n********* ORDER MANAGEMENT *********");
        System.out.println("1. View Past Meals");
        System.out.println("2. View Upcoming Meals");
        System.out.println("3. View & Modify Current Meals");
        System.out.println("4. View Achievements");
        System.out.println("5. Help");
        System.out.println("Enter '0' to go Back");
        System.out.println("Please enter from the above options\n");
    }

    /**
     * display method - displays the current meal menu
     */
    private void displayCurrentMealMenu()
    {
        System.out.println("\n********* UPCOMING MEAL MENU *********");
        System.out.println("1. View Current Weeks Meals");
        System.out.println("2. Modify Current Weeks Meals");
        System.out.println("Enter '0' to go Back");
        System.out.println("Please enter from the above options\n");
    }

    /**
     * display method - displays the welcome menu
     */
    private void displayWelcomeMenu()
    {
        System.out.println("\n********* WELCOME *********");
        System.out.println("1. Login");
        System.out.println("Please enter 1 to log in and 0 to exit");
    }

    /**
     * edit meal method - edits meals of customer
     *
     * @param customer edits meals for a customer
     */
    private void editMeal (Customer customer){
        Scanner scanner = new Scanner(System.in);
        String choice = "";
        System.out.println();
        while (!choice.equals("0")) {
            displayEditMealMenu();
            choice = scanner.nextLine().trim();
            System.out.println();
            switch (choice) {
                case "1":
                    addMeal(customer);
                    break;
                case "2":
                    editMealPreference(customer);
                    break;
                case "0":
                    System.out.println("BACK");
                    break;
                default:
                    System.out.println("Invalid input, try again");
                    break;
            }
        }
    }

    /**
     * edit method - edits the meal protein preference
     *
     * @param customer edits the customer's meal preference
     */
    private void editMealPreference (Customer customer){
        Scanner scan = new Scanner(System.in);
        customer.getCurrentMealKit().displayMeal();
        System.out.println("Please select from a meal above or 0 to go back: ");
        String choice = scan.nextLine();
        System.out.println();
        if(!choice.equals("0"))
        {
            Meal meal = customer.getCurrentMealKit().getMealList().get(Integer.parseInt(choice) - 1);
            String tag = meal.getMealTag();
            if (tag.equalsIgnoreCase("L") || tag.equalsIgnoreCase("B") || tag.equalsIgnoreCase("C")) {
                System.out.println("Enter you choice of protein from the below options");
                System.out.println();
                adjustProteinMeal(meal);
                System.out.println("Protein Changed");
            } else {
                System.out.println("The meal you have selected is tagged as V or VG and source of protein can not be added.");
                System.out.println();
            }
            customer.getCurrentMealKit().displayMeal();
        }
        else
            System.out.println("Invalid Option");
    }

    /**
     * help method - provides a brief description of the application
     */
    private void help() {
        System.out.println("********* HELP *********");
        System.out.println("Monash Meal Kit System is used to provide a weekly subscription of meals for students of \n" +
                "Monash University.\n" +
                "Once a student has logged in, they can view meals from their past 2 weeks, meals of their upcoming 2 " +
                "\nweeks and make any changes as they deem necessary for the current week's meal kit. \n" +
                "To make any changes to the meal kit, students need to go to the 'Current Week's Meal' section under " +
                "\n'Upcoming meals'.\n" +
                "Students can choose to skip the meal kit for that week, they can choose how many meals they require " +
                "\n(3 meals a week being the minimum and 10 meals being the maximum)\n" +
                "Each meal comes by default with 2 servings.\n" +
                "Student can choose between 2 and 4 servings per meal. \n" +
                "2 Servings = $20\t 4 Servings = $30\n" +
                "Meals are marked with their types:\nVegetarian(V) \nVegan(VG) \nChicken(C) \nLamb(L) \nBeef(B) \n" +
                "Choosing L or B incurs an extra charge of $5 per serving\n" +
                "The payment for the meal for that week has to be done by tuesday 11:59pm for the delivery to be done by " +
                "\nSaturday that week. If payment is made after tuesday, the meal kit will be delivered by the saturday " +
                "\nof next week.\n" +
                "All meals are marked with allergen information so that students can be vary of the meals they are " +
                "\nopting for.\n" +
                "Press any key to go back:\n");
    }

    /**
     * login method - allows the existing customer to login
     */
    private void login() {
        Scanner scanner = new Scanner(System.in);
        String email = "";
        String password;
        boolean valid = false;
        System.out.println("Enter login details or press '0' to go back");
        while (!valid)
        {
            System.out.print("Enter Email ID: ");
            email = scanner.nextLine().trim().toLowerCase();
            valid =!email.isEmpty();
            if (!valid)
                System.out.println("Invalid email id. Please try again... \n");
        }
        System.out.println();
        for (Customer customer : customerDatabase.getCustomerList()) {
            if (customer.getCustEmail().equals(email)) {
                System.out.print("Enter Password: ");
                password = scanner.nextLine().trim();
                System.out.println();
                if (customer.getCustPassword().equals(password)) {
                    System.out.println("Successfully Logged in");
                    orderManagement(customer);
                }
                else
                    System.out.println("Invalid Password");
            } else
                System.out.println("Invalid Email Address");
        }
    }

    /**
     * main method of the application
     */
    public static void main(String[] args) {
        Mmks mmks = new Mmks();
        mmks.runSystem();
    }

    /**
     * count method - counts the number of meals between 2 dates
     *
     * @param customer the customer
     * @param  start start date
     * @param  end  end dates
     */
    private int mealCount (Customer customer, Date start, Date end){
        int count = 0;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        for (MealKit mealKit : customer.getPastMealKit()) {
            try {
                Date kitDate = simpleDateFormat.parse(mealKit.getMealKitDate());
                int startResult = kitDate.compareTo(start);
                int endResult = kitDate.compareTo(end);
                if (startResult >= 0 && endResult <= 0)
                    count = count + mealKit.getMealList().size();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return count;
    }

    /**
     * modify method - makes changes to the current meals
     *
     * @param customer makes changes to the customers current week meal
     */
    private void modifyCurrentMeal(Customer customer) {
        Scanner scanner = new Scanner(System.in);
        String choice = "";
        String input = "";
        System.out.println();
        if (customer.getCurrentMealKit().getMealWeekStatus().equalsIgnoreCase("S"))
        {
            System.out.println("You have chosen to skip this week's meal kit and so cannot modify it.");
            System.out.println("Do you want change re-subscribe to this weeks kit?");
            System.out.println("Yes(Y) \nNo(N) \n Press any other key to go back...");
            input = scanner.nextLine().trim().toLowerCase();
            System.out.println();
            switch (input)
            {
                case "y":
                    customer.getCurrentMealKit().setMealWeekStatus("A"); break;
                case "n":
                    System.out.println("Cannot modify skipped meal kit"); break;
                default:
                    System.out.println("Invalid input, returning to previous menu..."); break;
            }
        }
        if (customer.getCurrentMealKit().getMealWeekStatus().equalsIgnoreCase("A"))
        {
            while (!choice.equals("0")) {
                displayModifyMealMenu();
                choice = scanner.nextLine().trim();
                System.out.println();
                switch (choice) {
                    case "1":
                        editMeal(customer);
                        break;
                    case "2":
                        skipWeek(customer);
                        choice = "0";
                        break;
                    case "3":
                        changeSize(customer);
                        break;
                    case "4":
                        confirmPayment(customer);
                        break;
                    case "0":
                        System.out.println("BACK");
                        break;
                    default:
                        System.out.println("Invalid input, try again");
                        break;
                }
            }
        }
    }

    /**
     * order management method - view or modify meals
     *
     * @param customer allows the customer to choose to either view or modify meals
     */
    private void orderManagement(Customer customer) {
        Scanner scanner = new Scanner(System.in);
        String choice = "";
        System.out.println();
        while (!choice.equals("0")) {
            displayOrderManagementMenu();
            choice = scanner.nextLine().trim();
            System.out.println();
            switch (choice) {
                case "1":
                    pastMeal(customer);
                    break;
                case "2":
                    viewUpcomingMeal(customer);
                    break;
                case "3":
                    currentMeal(customer);
                    break;
                case "4":
                    viewAchievement(customer);
                    break;
                case "5":
                    help();
                    scanner.nextLine();
                    break;
                case "0":
                    System.out.println("BACK");
                    break;
                default:
                    System.out.println("Invalid input, try again");
                    break;
            }
        }
    }

    /**
     * view method - views the customers upcoming meals
     *
     * @param customer  views the customers future meals
     */
    private void viewUpcomingMeal(Customer customer) {
        System.out.println("Upcoming Weeks' Meal Kit: ");
        System.out.println();
        for (MealKit mealKit : customer.getUpcomingMealKit())
            mealKit.displayMeal();
    }

    /**
     * view method - views the customers past meals
     *
     * @param customer  views the customers past meals
     */
    private void pastMeal(Customer customer) {
        System.out.println("Past Weeks' Meal Kit: ");
        System.out.println();
        for (MealKit mealKit : customer.getPastMealKit())
            mealKit.displayMeal();
    }


    /**
     * run method - allows the existing customers to log in
     *
     */
    public void runSystem() {
        Scanner scanner = new Scanner(System.in);
        String choice = "";
        while (!choice.equals("0")) {
            displayWelcomeMenu();
            choice = scanner.nextLine().trim();
            System.out.println();
            switch (choice) {
                case "1":
                    login(); break;
                case "0":
                    System.out.println("Goodbye!"); break;
                default:
                    System.out.println("Invalid input, try again"); break;
            }
        }
    }

    /**
     * skip method - customer can skipp the present weeks menu
     *
     * @param customer  allows the customer to skip current week meals
     */
    private void skipWeek (Customer customer){
        Scanner scan = new Scanner(System.in);
        String choice = "";
        System.out.println();
        customer.getCurrentMealKit().displayMealKitStatus();
        while (!choice.equals("0")) {
            System.out.println("Enter 1 to confirm to the skip this week or 0 to exit");
            choice = scan.nextLine().trim();
            System.out.println();
            switch (choice) {
                case "1":
                    customer.getCurrentMealKit().setMealWeekStatus("S");
                    System.out.println("This weeks meal has been successfully skipped");
                    System.out.println();
                    customer.getCurrentMealKit().displayMealKitStatus();
                    choice = "0";
                    break;
                case "0":
                    System.out.println("BACK");
                    break;
                default:
                    System.out.println("Invalid input, try again");
                    break;
            }
        }
    }

    /**
     * current meal method - view or modify current week
     *
     * @param customer  the customer can either view or modify their current weeks meal
     */
    private void currentMeal(Customer customer) {
        Scanner scanner = new Scanner(System.in);
        String choice = "";
        System.out.println();
        while (!choice.equals("0")) {
            displayCurrentMealMenu();
            choice = scanner.nextLine().trim();
            System.out.println();
            switch (choice) {
                case "1":
                    viewCurrentMeal(customer);
                    break;
                case "2":
                    modifyCurrentMeal(customer);
                    break;
                case "0":
                    System.out.println("BACK");
                    break;
                default:
                    System.out.println("Invalid input, try again");
                    break;
            }
        }
    }
    /**
     * view method - views the customers current meals
     *
     * @param customer  views the customers present meals
     */
    private void viewCurrentMeal(Customer customer){
        System.out.println("Current Week's Meal Kit: ");
        customer.getCurrentMealKit().displayMeal();
    }

    /**
     * view method - views the customers achievements
     *
     * @param customer  views the numbers of meals ordered between the dates provided
     */
    private void viewAchievement (Customer customer){
        Scanner scan = new Scanner(System.in);
        String startDate = "";
        String endDate = "";
        boolean valid = false;
        while (!valid) {
            System.out.println("Enter Start Date (dd/mm/yyyy): ");
            startDate = scan.nextLine().trim();
            valid = Validator.checkDate(startDate);
        }
        valid = false;
        while (!valid) {
            System.out.println("Enter End Date (dd/mm/yyyy): ");
            endDate = scan.nextLine().trim();
            valid = Validator.checkDate(endDate);
        }
        System.out.println();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date start;
        Date end;
        try {
            end = simpleDateFormat.parse(endDate);
            start = simpleDateFormat.parse(startDate);
            int result = start.compareTo(end);
            if (result <= 0)
                customerAchievement(customer, start, end);
        } catch (ParseException e) {
            System.out.println("Invalid date");
        }
    }
}
