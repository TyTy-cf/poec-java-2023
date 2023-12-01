package fr.ktourret.poec;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Main {

    public static void main(String[] args) {
        System.out.println(exo1(42));
        System.out.println(exo2Hello("Kevin"));
        System.out.println(exo3("Kevin", 5));
    }

    public static int exo1(int age) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(new Date());
        return calendar.get(Calendar.YEAR) - age;
    }

    public static String exo2Hello(String name) {
        if (name == null) {
            return null;
        }
        return "Bonjour, " + name + " ton nom contient " + name.length() + " lettres";
    }

    public static String exo3(String name, int position) {
        if (name == null) {
            return null;
        }
        if (name.length() < position || position < 0) {
            return null;
        }
        return "La lettre à la position " + position + " dans " + name + " est " + name.charAt(position - 1);
    }

}