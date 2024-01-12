public class Validator {
    /**
     * Constructor for objects of class Validator
     */
    public Validator()
    {
    }
    /**
     * A boolean method that returns true if the string contains numeric value and false otherwise.
     *
     * @param  word  a String to check
     * @return    true or false
     */
    public static boolean isStringNumeric(String word)
    {
        boolean flag = true;
        for (int i = 0; i < (word.length()); i++)
        {
            flag = Character.isDigit(word.charAt(i));
            if (flag == false)
                return false;
        }
        return true;
    }

    /**
     * A boolean method that returns true if the string contains characters and false otherwise
     *
     * @param  word  a String to check
     * @return    true or false
     */
    public static boolean isAlphabet(String word)
    {
        boolean flag = true;
        for (int i = 0; i < (word.length()); i++)
        {
            flag = Character.isLetter(word.charAt(i)) || Character.isSpace(word.charAt(i)) ;
            if (flag == false)
                return false;
        }
        return true;
    }

    /**
     * A boolean method that returns true for alphanumeric string and false otherwise
     *
     * @param  word  a String to check
     * @return    true or false
     */
    public static boolean isAlphaNumeric(String word)
    {
        boolean flag = true;
        for (int i = 0; i < (word.length()); i++)
        {
            flag = Character.isLetterOrDigit(word.charAt(i)) || Character.isSpace(word.charAt(i));
            if (flag == false)
                return false;
        }
        return true;
    }
    /**
     * Method to check an integer is between a specified range
     *
     * @param newId  integer to be checked
     * @param low  lower limit of the range
     * @param high higher limit of the range
     */
    public static boolean checkRange(int newId, int low, int high)
    {
        if (newId > low && newId < high)
            return true;
        return false;
    }

    /**
     * Method to check if a string is in date
     *
     * @param date  string to be checked
     */
    public static boolean checkDate(String date)
    {
        int checker = 3;
        if (!date.contains("/"))
            System.out.println("Please enter a date in the format - dd/mm/yyyy");
        else {
            if (date.split("/").length != 3)
                System.out.println("Please enter a date in the format - dd/mm/yyyy");
            else {
                String dd = date.split("/")[0];
                String month = date.split("/")[1];
                String year = date.split("/")[2];
                if (isStringNumeric(dd)) {
                    if (!checkRange(Integer.parseInt(dd), 1, 31))
                        System.out.println("Date is not valid - between 1 and 31");
                    else
                        checker--;
                }
                else
                    System.out.println("Please enter a numeric value for date");
                if (isStringNumeric(month)) {
                    if (!checkRange(Integer.parseInt(month), 1, 12))
                        System.out.println("Month is not valid - between 1 and 12");
                    else
                        checker--;
                }
                else
                    System.out.println("Please enter a numeric value for month");
                if (!isStringNumeric(year))
                    System.out.println("Please enter a numeric value for year");
                else
                    checker--;
                if (checker == 0)
                    return true;
            }
        }
        return false;
    }
}
