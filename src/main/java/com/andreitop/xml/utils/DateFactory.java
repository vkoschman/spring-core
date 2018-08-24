package com.andreitop.xml.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFactory {

    public static Date createDate(String date) throws ParseException {
        return new SimpleDateFormat("dd-mm-yyyy").parse(date);
    }
}
