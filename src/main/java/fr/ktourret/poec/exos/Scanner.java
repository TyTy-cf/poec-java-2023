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
//        System.out.println(exo7());
//        exo8();
        System.out.println(exo10("Kenzi", -36));
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

    private void exo8() {
        System.out.println("Je réfléchis à un nombre...");
        int guessNumber = (int) Math.floor((Math.random() * 100) + 1);
        System.out.println("Ca y est ! Devine ce nombre, tu as 10 essaies !");
        boolean hasFound = false;
        int turn = 1;
        while (turn <= 10 && !hasFound) {
            System.out.println("Essaie n°" + turn + "...");
            int writtenNumber = sc.nextInt();
            if (writtenNumber > guessNumber) {
                if (turn != 10) {
                    System.out.println("C'est plus petit !");
                }
            } else if (writtenNumber < guessNumber) {
                if (turn != 10) {
                    System.out.println("C'est plus grand !");
                }
            } else {
                hasFound = true;
            }
            if (!hasFound) {
                turn++;
            }
        }
        String message = "Tu as perdu ! Le nombre à deviner était : " + guessNumber;
        if (hasFound) {
            message = "Félicitation ! Tu as trouvé le nombre en " + turn + " tour(s) !";
        }
        System.out.println(message);
    }

    private String exo10(String word, int shift) {
        StringBuilder encrypt = new StringBuilder();
        char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        word = word.toLowerCase();
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            int pos = getPos(alphabet, letter);
            if (pos == -1) {
                return "";
            }
            int newPos = (pos + shift) % 26;
            if (newPos < 0) {
                newPos += 26;
            }
            encrypt.append(alphabet[newPos]);
        }

        return encrypt.toString();
    }

    private int getPos(char[] alphabet, char letter) {
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] == letter) {
                return i;
            }
        }
        return -1;
    }
}
