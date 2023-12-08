package fr.ktourret.poec;

import fr.ktourret.poec.entity.bank.*;
import fr.ktourret.poec.entity.chess.*;
import fr.ktourret.poec.entity.shape.*;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        mapExample();
//        bankExo();
//        (new Algo()).test();
//        (new Scanner()).test();a
//        exceptionExample();
//        ChessBoard chessBoard = new ChessBoard();
//        chessBoard.start();
    }

    private static void exceptionExample() {
        int a = 5;
        try {
            a = a / 0;
        } catch (ArithmeticException e) {
            a = 0;
            System.out.println("Dans l'exception...");
        }
        System.out.println(a);
        System.out.println("-----------------------------------");
        Circle c = new Circle(-5);
    }

    private static void mapExample() {
        Map<Long, AbstractShape> map = new TreeMap<>();
        AbstractShape r1 = new Rectangle(20, 10);
        AbstractShape s1 = new Square(12);
        AbstractShape c1 = new Circle(12);
        map.put(c1.getId(), c1);
        map.put(r1.getId(), r1);
        map.put(s1.getId(), s1);
        // Test pour vérifier que le put modifie la valeur si la K a été trouvé
//        map.put(s1.getClass().getSimpleName(), new Square(15));
        // Même comportement pour le replace... sauf que le replace ne sait pas ajouter
        // si la K n'existe pas (probablement pas très utile...)
//        map.replace(s1.getClass().getSimpleName(), new Square(15));

        for (Map.Entry<Long, AbstractShape> me : map.entrySet()) {
            System.out.println(me.getKey());
            System.out.println(me.getValue());
        }
    }

    private static void bankExo() {
        Calendar cal = Calendar.getInstance();
        cal.set(1990, Calendar.JANUARY,1);
        Client client = new Client(
                "Kévin",
                "Tourret",
                "oui@oui.fr",
                cal.getTime()
        );

        BankAccount ba = new BankAccount();
        ba.setType(BankAccountType.CURRENT);
        ba.setCreatedAt(new Date());
        ba.setOwner(client);
        ba.setIban("FR7698751236987457223");
        ba.addOperation(new Operation(1500.0, "First credit", new Date()));
        ba.addOperation(new Operation(-650.0, "Pay rent", new Date()));
        ba.addOperation(new Operation(-45.0, "Groceries", new Date()));
        ba.addOperation(new Operation(-45.0, "Groceries", new Date()));
        ba.addOperation(new Operation(-45.0, "Groceries", new Date()));
        ba.addOperation(new Operation(-45.0, "Groceries", new Date()));
        ba.addOperation(new Operation(-45.0, "Groceries", new Date()));
        ba.addOperation(new Operation(-30.0, "Bar", new Date()));
        ba.addOperation(new Operation(-90.0, "Fuel", new Date()));
        ba.addOperation(new Operation(-76.0, "Insurance", new Date()));
        ba.addOperation(new Operation(-45.0, "Internet", new Date()));
        ba.addOperation(new Operation(-90.0, "Elec/Gas", new Date()));
    }

    private static double getRandomBetween(int min, int max) {
        return Math.floor((Math.random() * (max - min)) + min);
    }

}