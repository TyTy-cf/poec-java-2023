package fr.ktourret.poec.courses.design_pattern.decorator;

public class DiscordDecorator extends Decorator {

    @Override
    public void send(String string) {
        System.out.println("Comportement d'envoie une notif Discord pour " + string);
        super.send(string);
    }
}
