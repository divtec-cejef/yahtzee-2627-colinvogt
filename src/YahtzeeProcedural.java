import java.util.Scanner; // import the Scanner class

public class YahtzeeProcedural {

    static final int NBRE_FACE = 6;
    static final int NBRE_DE = 5;
    static final String regex = "[,\\.\\s]";

    /**
     * Genere des face de dé aleatoire
     *
     * @param nbrFace le nombre de face du dé
     * @return Un face aleatoire du dé
     */
    public static int genereFaceAleatoire(int nbrFace) {
        return (int) (Math.random() * nbrFace + 1);
    }

    /**
     * Affiche les dés de la liste de dé mise en parametre
     *
     * @param deTire La liste de dé
     */
    public static void afficherDee(int[] deTire) {
        for (int index = 0; index < deTire.length; index++) {
            System.out.println("Dé " + (index + 1) + ": " + deTire[index]);
        }
    }

    /**
     * Demande a l'utilisateur si il veut relancer rien ou plusieur dé
     *
     * @return les dé que l'utilisateur a saisie mais converti en int
     */
    public static int[] demandeRelance() {
        System.out.println("\nQuel dés voulez vous relancez ? (Saisir de 1-5 ou 0 si vous ne voulez pas relancer) Atenttion 3 lancé MAX!\n");
        String desChoisi;
        Scanner myObj = new Scanner(System.in);
        desChoisi = myObj.nextLine();
        String[] parts = desChoisi.split(regex);
        int[] indice = new int[parts.length];
        if (desChoisi.equals("0") || desChoisi.isEmpty()) {
            return new int[0];
        } else {
            for (int i = 0; i < parts.length; i++) {
                indice[i] = Integer.parseInt(parts[i]) - 1;
            }
        }
        return indice;
    }

    /**
     * Relance les dés mis en parametre
     *
     * @param deTire    Liste de resultat qui va etre modifier
     * @param desChoisi Liste de dés choisi a etre modifié
     * @return
     */
    public static int[] relanceDe(int[] deTire, int[] desChoisi) {
        for (int i = 0; i < desChoisi.length; i++) {
            deTire[(desChoisi[i])] = genereFaceAleatoire(NBRE_FACE);
        }
        return deTire;
    }

    /**
     *  Compte et renvoi le nombre d'Ocurence
     * @param deTire La liste qui ba etre trier
     * @return Une liste du nombre d'Ocurence pour chacun des chiffre
     */
    public static int[] compteNbreOccurences(int[] deTire) {
        int[] nbrOccuren = new int[NBRE_FACE];
        for (int position = 0; position < deTire.length; position++) {
            nbrOccuren[deTire[position] -1]++;
        }
        return nbrOccuren;
}

/**
 * Point d'entré du progranmme
 *
 * @param args
 */
public static void main(String[] args) {
    int[] deTire = new int[NBRE_DE];

    for (int i = 0; i < deTire.length; i++) {
        deTire[i] = genereFaceAleatoire(NBRE_FACE);
    }
    afficherDee(deTire);
    for (int i = 0; i < 2; i++) {
        int[] position = demandeRelance();
        if (position.length == 0) {
            break;
        } else {
            relanceDe(deTire, position);
            if (i != 1) {
                afficherDee(deTire);
            }
        }
    }
    afficherDee(deTire);
    System.out.println("\n\n");
    for (int index = 0; index < deTire.length + 1; index++) {
        System.out.println("Nombre de fois " + (index + 1) + " dans les de tiré : " + compteNbreOccurences(deTire)[index]);
    }



        /*
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
*/
}

}
