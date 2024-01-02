package fr.ktourret.poec.courses.design_pattern.decorator;

public class SMSDecorator extends Decorator {

    @Override
    public void send(String string) {
        System.out.println("Comportement d'envoie une notif SMS pour " + string);
        super.send(string);
    }
}
