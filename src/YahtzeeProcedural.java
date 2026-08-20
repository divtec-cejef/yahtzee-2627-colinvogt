import java.util.Scanner; // import the Scanner class

public class YahtzeeProcedural {

    static final int NBRE_FACE = 6;
    static final int NBRE_DE = 5;
    static final String regex = "[,\\.\\s]";

    public static int genereFaceAleatoire(int nbrFace) {
        return (int) (Math.random() * nbrFace + 1);
    }

    public static void afficherDee(int[] deTire) {
        for (int index = 0; index < deTire.length; index++) {
            System.out.println("Dé " + (index + 1) + ": " + deTire[index]);
        }
    }


    public static int demandeRelance (int[] deTire) {
        System.out.println("\nQuel dés voulez vous relancez ? (Saisir de 1-5 ou 0 si vous ne voulez pas relancer) Atenttion 3 lancé MAX!\n");
        for (int index = 0; index < deTire.length; index++) {
            System.out.println("Dé " + (index + 1));

            String desChoisi;
            Scanner myObj = new Scanner(System.in);
            int compteur = 1;
            desChoisi = myObj.nextLine();
            if (desChoisi.equals("0") || desChoisi.isEmpty()) {
                return 0;
            } else {
                return desChoisi.split(regex);
            }
        }
    }


    public static void main(String[] args) {
        int[] deTire = new int[NBRE_DE];

        for (int i = 0; i < deTire.length; i++) {
            deTire[i] = genereFaceAleatoire(NBRE_FACE);
        }
        afficherDee(deTire);

        System.out.println("\nQuel dés voulez vous relancez ? (Saisir de 1-5 ou 0 si vous ne voulez pas relancer) Atenttion 3 lancé MAX!\n");
        for (int index = 0; index < deTire.length; index++) {
            System.out.println("Dé " + (index + 1));}

            String desChoisi;
            Scanner myObj = new Scanner(System.in);
            int compteur = 1;

            do {
                desChoisi = myObj.nextLine();
                if (desChoisi.equals("0") || desChoisi.isEmpty()) {
                    afficherDee(deTire);
                    break;
                } else {
                    for (int i = 0; i < desChoisi.split(regex).length; i++) {
                        deTire[(Integer.parseInt(desChoisi.split(regex)[i]) - 1)] = genereFaceAleatoire(NBRE_FACE);
                    }
                    afficherDee(deTire);
                    compteur++;
                }
            } while (compteur <= 2);

        }

    }
