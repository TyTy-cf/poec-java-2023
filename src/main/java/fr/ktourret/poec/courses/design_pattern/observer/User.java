package fr.ktourret.poec.courses.design_pattern.observer;

public class User implements Observer {

    @Override
    public void myNotify(String content) {
        System.out.println("On m'a envoyé une notif, la voici :");
        System.out.println(content);
    }

}
