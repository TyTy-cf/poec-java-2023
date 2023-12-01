package fr.ktourret.poec;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Main {

    public static void main(String[] args) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(new Date());
        System.out.println(calendar.get(Calendar.YEAR));
    }

}