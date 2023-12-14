package fr.ktourret.poec.courses;

import fr.ktourret.poec.courses.entity.bank.BankAccount;
import fr.ktourret.poec.courses.entity.bank.BankAccountType;
import fr.ktourret.poec.courses.entity.bank.Client;
import fr.ktourret.poec.courses.entity.bank.Operation;
import fr.ktourret.poec.courses.entity.example.Singleton;
import fr.ktourret.poec.courses.entity.recipe_maker.*;
import fr.ktourret.poec.courses.entity.shape.AbstractShape;
import fr.ktourret.poec.courses.entity.shape.Circle;
import fr.ktourret.poec.courses.entity.shape.Rectangle;
import fr.ktourret.poec.courses.entity.shape.Square;
import fr.ktourret.poec.my_mvc.service.Dump;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

public class MainExo {

    public MainExo() {
        //        mapExample();
//        bankExo();
        cookMaker();
//        (new Algo()).test();
//        (new Spotifish()).test();
//        (new Scanner()).test();
//        exceptionExample();
//        ChessBoard chessBoard = new ChessBoard();
//        chessBoard.start();
//        singletonExample();
    }


    private static void singletonExample() {
        Singleton singleton = Singleton.getInstance();
        System.out.println(singleton);

        Singleton singleton2 = Singleton.getInstance();
        System.out.println(singleton2);
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

    private static void cookMaker() {
        Ingredient celeri = new Ingredient();
        celeri.setName("Céleri");
        Ingredient whiteWine = new Ingredient();
        whiteWine.setName("Vin blanc");
        whiteWine.addIngredientType(IngredientType.HAS_ALCOHOL);

        Recipe myRecipe = new Recipe();
        myRecipe.setName("Céleri au vin blanc");
        myRecipe.addRecipeIngredient(new RecipeIngredient(celeri, Unit.GR, 200));
        myRecipe.addRecipeIngredient(new RecipeIngredient(whiteWine, Unit.CL, 25));

        Comment c1 = new Comment();
        c1.setRating(5d);

        Comment c2 = new Comment();
        c2.setRating(4d);

        myRecipe.addComment(c1);
        myRecipe.addComment(c2);

        Dump.dump(myRecipe);
    }

    private static double getRandomBetween(int min, int max) {
        return Math.floor((Math.random() * (max - min)) + min);
    }

}
