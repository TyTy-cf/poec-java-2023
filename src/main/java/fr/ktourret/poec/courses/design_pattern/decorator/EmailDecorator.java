package fr.ktourret.poec.courses.design_pattern.decorator;

public class EmailDecorator extends Decorator {

    @Override
    public void send(String string) {
        System.out.println("Comportement d'envoie une notif Email pour " + string);
        super.send(string);
    }
}
