/**
 * Manages the Payment details of customer.
 *
 * @author Anna Mary Almeida, Sahaj kishor Jain, Gefferson Nelson
 * @version 22/05/2022
 */

public class Payment {
    private String cardName;
    private String cardNumber;
    private String cardExpiry;
    private String cardCVV;
    /**
     * Constructor for objects of class Payment
     */
    public Payment(String cardName, String cardNumber, String cardExpiry, String cardCVV) {
        this.cardName = cardName;
        this.cardNumber = cardNumber;
        this.cardExpiry = cardExpiry;
        this.cardCVV = cardCVV;
    }

    /**
     * accessor method - returns the card name
     *
     * @return    the card name
     */
    public String getCardName() {
        return cardName;
    }

    /**
     * mutator method - sets a card name
     *
     * @param  cardName a card name of a customer
     */
    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    /**
     * accessor method - returns the card number
     *
     * @return    the card number
     */
    public String getCardNumber() {
        return cardNumber;
    }

    /**
     * mutator method - sets a card number
     *
     * @param  cardNumber a card number of a customer
     */
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    /**
     * accessor method - returns the card expiry number
     *
     * @return    the card expiry
     */
    public String getCardExpiry() {
        return cardExpiry;
    }

    /**
     * mutator method - sets a card expiry
     *
     * @param  cardExpiry a card expiry of a customer
     */
    public void setCardExpiry(String cardExpiry) {
        this.cardExpiry = cardExpiry;
    }

    /**
     * accessor method - returns the card CVV number
     *
     * @return    the card CVV
     */
    public String getCardCVV() {
        return cardCVV;
    }

    public void setCardCVV(String cardCVV) {
        this.cardCVV = cardCVV;
    }
}
