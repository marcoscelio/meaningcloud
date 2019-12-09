package org.com.marcosdemo;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.ParseException;
import java.util.List;
import org.com.marcosdemo.services.NumbersService;
import org.com.marcosdemo.utils.NumbersUtils;
import org.com.marcosdemo.validators.NumbersValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class NumbersServiceTest {

    @Mock
    private NumbersValidator numberValidator;

    @Mock
    private NumbersUtils numbersUtils;

    @InjectMocks
    private NumbersService numbersService;


    @Test
    public void convertToNumericValuesTest() throws Exception {
        String numbers = "1,2,3,4,5";
        when(numberValidator.isNumeric(anyString())).thenCallRealMethod();
        when(numbersUtils.castToNumber(anyString())).thenCallRealMethod();

        List<Number> result = numbersService.convertToNumericValues(numbers);

        assertTrue(!result.isEmpty());
    }

    @Test
    public void convertToNumericValuesExceptionTest() throws Exception {
        String numbers = "1,2,a,d,5";
        when(numberValidator.isNumeric(anyString())).thenCallRealMethod();
        when(numbersUtils.castToNumber(anyString())).thenCallRealMethod();

        assertThrows(RuntimeException.class, () -> {
            numbersService.convertToNumericValues(numbers);
        });
    }

}
