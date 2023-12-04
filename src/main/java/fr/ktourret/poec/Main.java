package fr.ktourret.poec;

import fr.ktourret.poec.entity.User;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Main {

    public static void main(String[] args) {
//        System.out.println(exo1(42));
//        System.out.println(exo2Hello("Kevin"));
//        System.out.println(exo3("Kevin", 5));
//        recursive(0);
//        User user = new User("Kévin", 42);
//        System.out.println(user.name);
//        User user2 = new User("Nicolas", 42);
//        System.out.println(user2.name);
//        double temp = getRandomBetween(-150, 150);
//        System.out.println(temp);
//        System.out.println(getWaterState(temp));
//        System.out.println(increasePrice(100, 25));
//        System.out.println(celsiusToFahrenheit(30));
//        System.out.println(fahrenheitToCelsius(86));
//        System.out.println(getNumberChain(1));
//        System.out.println(getSubscriptionCost(10, 5));
//        System.out.println(getSubscriptionCost(10, 3));
//        System.out.println(getSubscriptionCost(10, 6));
//        System.out.println(getSubscriptionCost(10, 12));
//        System.out.println(duplicate("Kévin", 12));
//        int[] array = {15, 78, 45, 96, 12, 32, 65, 78, 91};
//        System.out.println(getMinimum(array));
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

    public static String exo3(String firstName, int position) {
        if (firstName == null) {
            return null;
        }
        if (firstName.length() < position || position < 0) {
            return null;
        }
        return "La lettre à la position " + position + " dans " + firstName + " est " + firstName.charAt(position - 1);
    }

    public static double exo4(double uPrice, int qty) {
        return qty * uPrice * 1.196;
    }

    public static String getWaterState(double temp) {
        if (temp <= 0) {
            return "Etat solide";
        }
        if (temp >= 100) {
            return "Etat gazeux";
        }
        return "Etat liquide";
//        String state = "Etat liquide";
//        if (temp <= 0) {
//            state = "Etat solide";
//        }
//        if (temp >= 100) {
//            state = "Etat gazeux";
//        }
//        return state;
    }

    public static void recursive(int i) {
        if (i < 10) {
            System.out.println(i);
            recursive(++i);
        }
    }

    public static double celsiusToFahrenheit(double temp) {
        return temp * 1.8 + 32;
    }

    public static double fahrenheitToCelsius(double temp) {
        return (temp - 32) / 1.8;
    }

    public static double increasePrice(double price, double percent) {
        return price * (1 + (percent / 100));
    }

    public static StringBuilder getNumberChain(int digit) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            int result = digit + digit;
            sb.append(digit)
                .append(" + ")
                .append(digit)
                .append(" = ")
                .append(result)
                .append("\n"); // retour à la ligne
            digit = result;
        }
        return sb;
    }

    private static double getSubscriptionCost(double cost, int duration) {
        double discount = -1;
        if (duration == 3) {
            discount = 5;
        } else if (duration == 6) {
            discount = 10;
        } else if (duration == 12) {
            discount = 25;
        }
        if (discount == -1) {
            return -1;
        }
        return duration * cost * (1 - (discount / 100));
    }

    private static StringBuilder duplicate(String value, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(value).append("\n");
        }
        return sb;
    }

    private static int getMinimum(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        return min;
    }

    private static double getRandomBetween(int min, int max) {
        return (Math.random() * (max - min)) + min;
    }

}