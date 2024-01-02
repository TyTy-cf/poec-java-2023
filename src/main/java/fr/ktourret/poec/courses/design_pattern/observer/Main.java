package fr.ktourret.poec.courses.design_pattern.observer;

public class Main {

    public static void main(String[] args) {
        User ao = new User();
        TwitterAccount account = new TwitterAccount();
        account.registerObserver(ao);
        account.publishedFeed("Voici un contenu de qualité");
    }

}
