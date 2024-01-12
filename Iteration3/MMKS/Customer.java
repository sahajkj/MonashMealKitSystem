import java.util.ArrayList;

/**
 * Customer class is created to maintain customer's details.
 *
 * @author Sahaj K Jain, Anna Mary Almeida, Gefferson Nelson
 * @version 22/05/2022
 */
public class Customer {
    private String custID;
    private String custEmail;
    private String custPassword;
    private String custFname;
    private String custLname;
    private String custGender;
    private String custDob;
    private ArrayList<String> custAllergen;
    private String custPhone;
    private String custAddress;
    private String custReferral;
    private ArrayList<MealKit> custMealKit;
    private Payment payment;
    private final int CURRENT = 2;

    /**
     * Constructor for objects of class Customer initialises the fields.
     *
     * @param  custID         new customer ID
     * @param  custEmail      new customer email
     * @param  custPassword   customer password
     * @param  custFname      new customer first name
     * @param  custLname      new customer last name
     * @param  custGender     customer gender
     * @param  custDob        new customer date of birth
     * @param  custAllergen   list of customer allergens
     * @param  custPhone      customer phone number
     * @param  custAddress    new customer address
     * @param  custReferral   new customer referral code
     * @param  custMealKit    customer meal kit
     * @param  payment        customer payment
     *
     */
    public Customer(String custID, String custEmail, String custPassword, String custFname, String custLname, String custGender, String custDob, ArrayList<String> custAllergen, String custPhone, String custAddress, String custReferral, ArrayList<MealKit> custMealKit, Payment payment) {
        this.custID = custID;
        this.custEmail = custEmail;
        this.custPassword = custPassword;
        this.custFname = custFname;
        this.custLname = custLname;
        this.custGender = custGender;
        this.custDob = custDob;
        this.custAllergen = custAllergen;
        this.custPhone = custPhone;
        this.custAddress = custAddress;
        this.custReferral = custReferral;
        this.custMealKit = custMealKit;
        this.payment = payment;
    }

    /**
     * accessor method - returns the ID of a customer
     *
     * @return    Customer's ID number
     */
    public String getCustID() {
        return custID;
    }

    /**
     * Mutator method - sets the ID of the customer
     * @param custID
     */
    public void setCustID(String custID) {
        this.custID = custID;
    }

    /**
     * accessor method - returns the email ID of a customer
     *
     * @return    the email ID of customer
     */
    public String getCustEmail() {
        return custEmail;
    }

    /**
     * mutator method - sets the email id of the customer
     * @param custEmail
     */
    public void setCustEmail(String custEmail) {
        this.custEmail = custEmail;
    }

    /**
     * accessor method - returns the password of a customer
     *
     * @return    the password of customer
     */
    public String getCustPassword() {
        return custPassword;
    }

    /**
     * mutator method - to set the password for a customer
     * @param custPassword
     */
    public void setCustPassword(String custPassword) {
        this.custPassword = custPassword;
    }

    /**
     * accessor method - returns the first name of a customer
     *
     * @return    customer first name
     */
    public String getCustFname() {
        return custFname;
    }

    /**
     * mutator method - sets the first name of the customer
     * @param custFname
     */

    public void setCustFname(String custFname) {
        this.custFname = custFname;
    }

    /**
     * accessor method - returns the last name of a customer
     *
     * @return    customer last name
     */
    public String getCustLname() {
        return custLname;
    }

    /**
     * mutator method - sets the last name of the customer
     * @param custLname
     */
    public void setCustLname(String custLname) {
        this.custLname = custLname;
    }

    /**
     * accessor method - returns the gender of a customer
     *
     * @return    customer gender
     */
    public String getCustGender() {
        return custGender;
    }

    /**
     * mutator method - sets the gender of the customer
     *
     * @param custGender
     */
    public void setCustGender(String custGender) {
        this.custGender = custGender;
    }

    /**
     * accessor method - returns the date of birth of a customer
     *
     * @return    customer date of birth
     */
    public String getCustDob() {
        return custDob;
    }

    /**
     * mutator method - set the date of birth of a customer
     * @param custDob
     */

    public void setCustDob(String custDob) {
        this.custDob = custDob;
    }

    /**
     * accessor method - returns the allergen list of a customer
     *
     * @return    the allergen list
     */
    public ArrayList<String> getCustAllergen() {
        return custAllergen;
    }

    /**
     * Mutator method - sets the allergen list of a customer
     * @param custAllergen
     */
    public void setCustAllergen(ArrayList<String> custAllergen) {
        this.custAllergen = custAllergen;
    }

    /**
     * accessor method - returns the phone number of a customer
     *
     * @return    customer phone number
     */
    public String getCustPhone() {
        return custPhone;
    }

    /**
     * mutator method - sets the phone number of customer
     * @param custPhone
     */
    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }

    /**
     * accessor method - returns the address of a customer
     *
     * @return    customer address
     */
    public String getCustAddress() {
        return custAddress;
    }

    /**
     * mutator method - sets the address of the customer
     * @param custAddress
     */
    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    /**
     * accessor method - returns the referral code of a customer
     *
     * @return    the referral code
     */
    public String getCustReferral() {
        return custReferral;
    }

    /**
     * mutator method - sets the referral code of the customer
     * @param custReferral
     */
    public void setCustReferral(String custReferral) {
        this.custReferral = custReferral;
    }

    /**
     * accessor method - returns all the Meal kits of a customer
     *
     * @return    ArrayList of all MealKits
     */
    public ArrayList<MealKit> getCustMealKit() {
        return custMealKit;
    }

    /**
     * accessor method - returns the past meal kits of a customer
     *
     * @return    ArrayList of past MealKits
     */
    public ArrayList<MealKit> getPastMealKit()
    {
        return new ArrayList<MealKit>(custMealKit.subList(0,2));
    }

    /**
     * accessor method - returns the upcoming meal kits of a customer
     *
     * @return    ArrayList of upcoming MealKits
     */
    public ArrayList<MealKit> getUpcomingMealKit()
    {
        return new ArrayList<MealKit>(custMealKit.subList(3,5));
    }

    /**
     * accessor method - returns the current MealKit of a customer
     *
     * @return    MealKit of current week
     */
    public MealKit getCurrentMealKit()
    {
        return custMealKit.get(CURRENT);
    }

    /**
     * Mutator Method - sets the list of all mealkits of a customer
     * @param custMealKit
     */
    public void setCustMealKit(ArrayList<MealKit> custMealKit) {
        this.custMealKit = custMealKit;
    }

    /**
     * accessor method - returns the payment info of a customer
     *
     * @return    the Payment
     */
    public Payment getPayment() {
        return payment;
    }

    /**
     * Mutator Method - sets the payment of a customer
     * @param payment
     */
    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
