package org.com.marcosdemo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.ParseException;
import org.com.marcosdemo.utils.NumbersUtils;
import org.com.marcosdemo.validators.NumbersValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class NumbersValidatorTest {

    private NumbersValidator numbersValidator = new NumbersValidator();

    @Test
    public void isNumericTrueTest() throws ParseException {
        String number = "11";

        assertTrue(numbersValidator.isNumeric(number));
    }

    @Test
    public void isNumericFalseTest() throws ParseException {
        String number = "abc";

        assertFalse(numbersValidator.isNumeric(number));
    }


}
