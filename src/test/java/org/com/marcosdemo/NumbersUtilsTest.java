package org.com.marcosdemo;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.ParseException;
import org.com.marcosdemo.utils.NumbersUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class NumbersUtilsTest {

    private NumbersUtils numbersUtils = new NumbersUtils();

    @Test
    public void castToNumberTest() throws ParseException {
        String numberStr = "11";

        Number number = numbersUtils.castToNumber(numberStr);

        assertTrue(number.toString().equals(numberStr));
    }

    @Test
    public void castToNumberExceptionTest() {
        String numberStr = "abc";

        assertThrows(ParseException.class, () -> {
            numbersUtils.castToNumber(numberStr);
        });
    }


}
