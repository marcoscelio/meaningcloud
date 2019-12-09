package org.com.marcosdemo.services;

import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.com.marcosdemo.utils.NumbersUtils;
import org.com.marcosdemo.validators.NumbersValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NumbersService {

    private static final Logger logger = LoggerFactory.getLogger(NumbersService.class);
    private NumbersValidator numberValidator;
    private NumbersUtils numbersUtils;

    public NumbersService(NumbersValidator numberValidator, NumbersUtils numbersUtils) {
        this.numberValidator = numberValidator;
        this.numbersUtils = numbersUtils;
    }

    public List<Number> convertToNumericValues(String numbers) throws Exception {
        if (numbers == null || numbers.trim().equals("")) {
            throw new Exception("Empty list of numbers");
        }
        return Arrays.stream(numbers.replace(" ", "").split(",")).map(value -> {
            if (!numberValidator.isNumeric(value)) {
                throw new RuntimeException("Number " + value + " is invalid");
            }
            try {
                return numbersUtils.castToNumber(value);
            } catch (ParseException e) {
                logger.error("Error when casting string to number");
                throw new RuntimeException("Error when casting string to number");
            }
        }).collect(Collectors.toList());
    }

}
