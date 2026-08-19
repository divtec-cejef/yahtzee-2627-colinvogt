import java.util.Scanner; // import the Scanner class
public class YahtzeeProcedural {

    static final int NBRE_FACE = 6;
    static final int NBRE_DE = 5;

    public static int genereFaceAleatoire(int nbrFace) {
        return (int) (Math.random() * nbrFace + 1);
    }

    public static void afficherDee(int[] deTire) {
        for (int index = 0; index < deTire.length; index++) {
            System.out.println("Dé " + (index + 1) + ": " + deTire[index]);
        }
    }

    public static void main(String[] args) {
        int[] deTire = new int[NBRE_DE];

        for (int i = 0; i < deTire.length; i++) {
            deTire[i] = genereFaceAleatoire(NBRE_FACE);
        }
        afficherDee(deTire);

        System.out.println("\nQuel dés voulez vous relancez ? (Saisir de 1-5 ou 0 si vous ne voulez pas relancer)\n");
        for (int index = 0; index < deTire.length; index++) {
            System.out.println("Dé " + (index + 1));
        }

        String desChoisi;
        Scanner myObj = new Scanner(System.in);


        do {
            desChoisi = myObj.nextLine();

            if (desChoisi == 0 || desChoisi.isEmpty())



        } while ()

    }
}
