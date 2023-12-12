package fr.ktourret.poec.entity.example;

public class Singleton {

    private static Singleton singleton;

    private Singleton() { }

    public static Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }

    private String toto;

    public String getToto() {
        return toto;
    }

    public void setToto(String toto) {
        this.toto = toto;
    }
}
