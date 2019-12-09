package org.com.marcosdemo;

import org.assertj.core.api.Assertions;
import org.com.marcosdemo.config.NumbersConfig;
import org.com.marcosdemo.services.NumbersService;
import org.com.marcosdemo.utils.NumbersUtils;
import org.com.marcosdemo.validators.NumbersValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class NumbersConfigTest {

    private final NumbersConfig testInstance = new NumbersConfig();

    @Test
    void numbersService(@Mock NumbersValidator numberValidator, @Mock NumbersUtils numbersUtils){
        NumbersService numbersService = testInstance.getNumbersService(numberValidator, numbersUtils);

        Assertions.assertThat(numbersService).isNotNull();
    }

    @Test
    void numbersUtils(){
        NumbersUtils numbersUtils = testInstance.getNumbersUtils();

        Assertions.assertThat(numbersUtils).isNotNull();
    }

    @Test
    void numbersValidator(){
        NumbersValidator numbersValidator = testInstance.getNumbersValidator();

        Assertions.assertThat(numbersValidator).isNotNull();
    }


}