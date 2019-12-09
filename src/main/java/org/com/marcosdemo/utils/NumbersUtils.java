package org.com.marcosdemo.utils;

import java.text.NumberFormat;
import java.text.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NumbersUtils {

    private static final Logger logger = LoggerFactory.getLogger(NumbersUtils.class);

    public Number castToNumber(String number) throws ParseException {
        return NumberFormat.getInstance().parse(number);
    }

}
