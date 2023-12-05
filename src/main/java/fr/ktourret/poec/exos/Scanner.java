package fr.ktourret.poec.exos;

public class Scanner {

    private final java.util.Scanner sc = new java.util.Scanner(System.in);

    public void test() {
//        System.out.println(exo1());
//        System.out.println(exo2());
//        System.out.println(exo3());
//        System.out.println(exo4());
//        System.out.println(exo5());
//        System.out.println(exo6());
        System.out.println(exo7());
    }

    private double exo1() {
        System.out.println("Donne moi deux chiffres ?");
        return (sc.nextDouble() + sc.nextDouble()) / 2;
    }

    private boolean exo2() {
        return sc.nextInt() % 2 == 0;
    }

    private int exo3() {
        return sc.nextLine().length();
    }

    private int exo4() {
        System.out.println("How much integers ?");
        int sum = 0;
        int[] array = new int[sc.nextInt()];
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
            sum += array[i];
        }
        return sum;
    }

    private int exo5() {
        return (int) Math.floor((Math.random() * 6) + 1);
    }

    private int exo6() {
        System.out.println("Give me one word");
        String word = sc.nextLine();
        int nbVowels = 0;
        for (int i = 0; i < word.length(); i++) {
            String str = word.charAt(i) +  "";
//            if (word.charAt(i) == 'a' || word.charAt(i) == 'e' || word.charAt(i) == 'i' ||
//                word.charAt(i) == 'o' || word.charAt(i) == 'u' || word.charAt(i) == 'y'
//            ) {
            if (str.matches("[aeiouy]")) {
                nbVowels++;
            }
        }
        return nbVowels;
    }

    private double exo7() {
        return Math.sqrt(sc.nextDouble());
    }

}
