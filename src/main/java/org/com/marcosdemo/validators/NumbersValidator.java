package org.com.marcosdemo.validators;

public class NumbersValidator {

    public boolean isNumeric(String number) {
        try {
            Double.parseDouble(number);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

}
