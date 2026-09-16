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
     * Compte et renvoi le nombre d'Ocurence
     *
     * @param deTire La liste qui ba etre trier
     * @return Une liste du nombre d'Ocurence pour chacun des chiffre
     */
    public static int[] compteNbreOccurences(int[] deTire) {
        int[] nbrOccuren = new int[NBRE_FACE];
        for (int position = 0; position < deTire.length; position++) {
            nbrOccuren[deTire[position] - 1]++;
        }
        return nbrOccuren;
    }

    /**
     * Detecte un paire
     * @param nbreOccuren
     * @return
     */
    public static int unePaire(int[] nbreOccuren) {
        for (int i = 0; i < nbreOccuren.length; i++) {
            if (nbreOccuren[i] >= 2) {
                return 5;
            }
        }
        return 0;
    }

    /**
     * Verifie si il y a une double paire
     * @param nbreOccuren
     * @return
     */
    public static int deuxPaire(int[] nbreOccuren) {
        int nbrPaire = 0;
        for (int i = 0; i < nbreOccuren.length; i++) {
            if (nbreOccuren[i] >= 2) {
                nbrPaire++;
            }
        }
        if (nbrPaire == 2) {
            return 10;
        }
        return 0;
    }

    /**
     * Verifie si il y a un brelan
     * @param nbreOccuren
     * @return
     */
    public static int brelan(int[] nbreOccuren) {
        for (int i = 0; i < nbreOccuren.length; i++) {
            if (nbreOccuren[i] >= 3) {
                return (i + 1) * 3;
            }
        }
        return 0;
    }

    /**
     * Verifie si il y a un carre
     * @param nbreOccuren
     * @return
     */
    public static int carre(int[] nbreOccuren) {
        for (int i = 0; i < nbreOccuren.length; i++) {
            if (nbreOccuren[i] >= 4) {
                return (i + 1) * 4;
            }
        }
        return 0;
    }

    /**
     * Verifie si il y a une full House
     * @param nbreOccuren
     * @return
     */
    public static int fullHouse(int[] nbreOccuren) {
        boolean possedePaire = false;
        for (int i = 0; i < nbreOccuren.length; i++) {
            if (nbreOccuren[i] == 2) {
                possedePaire = true;
            }
        }
        if (brelan(nbreOccuren) != 0 && possedePaire) {
            return 25;
        }
        return 0;
    }

    /**
     * Verifie si il y a une Petite Suite
     * @param nbreOccuren
     * @return
     */
    public static int petiteSuite(int[] nbreOccuren) {
        for (int i = 0; i < 3; i++) {
            if (nbreOccuren[i] >= 1 && nbreOccuren[i + 1] >= 1 && nbreOccuren[i + 2] >= 1 && nbreOccuren[i + 3] >= 1) {
                return 30;
            }
        }
        return 0;
    }

    /**
     * Verifie si il y a une grande suite
     * @param nbreOccuren
     * @return
     */
    public static int grandeSuite(int[] nbreOccuren) {
        for (int i = 0; i < 2; i++) {
            if (nbreOccuren[i] >= 1 && nbreOccuren[i + 1] >= 1 && nbreOccuren[i + 2] >= 1 && nbreOccuren[i + 3] >= 1 && nbreOccuren[i + 4] >= 1) {
                return 40;
            }
        }
        return 0;
    }

    /**
     * Verifie si il y a un Yahtzee
     * @param nbreOccuren
     * @return
     */
    public static int yahtzee(int[] nbreOccuren) {
        for (int i = 0; i < nbreOccuren.length; i++) {
            if (nbreOccuren[i] == 5) {
                return 50;
            }
        }
        return 0;
    }

    public static int calculeTotal (String[] combinaison, int[] point, boolean[] dejaUtiliser) {
        int totalPoint = 0;
        System.out.println("\n");
        for (int i = 0; i < combinaison.length; i++) {
            if (!dejaUtiliser[i]) {
                System.out.printf("%d.%-15s [%d pts]\n", i + 1, combinaison[i], point[i]);
            }
        }

        int combinaisonsChoisi;
        Scanner myObj = new Scanner(System.in);
        combinaisonsChoisi = myObj.nextInt();
        if (combinaisonsChoisi != 0) {
            totalPoint += point[combinaisonsChoisi - 1];
            dejaUtiliser[combinaisonsChoisi - 1] = true;
        }
        return totalPoint;
    }

    /**
     * Point d'entré du progranmme
     *
     * @param args
     */
    public static void main(String[] args) {
        int pointTotal = 0;
        boolean[] dejaUtiliser = new boolean[8];
        for (int i = 0; i < 5; i++) {
            System.out.println("\nMANCHE " + (i+1) + "\n");
            int[] deTire = new int[NBRE_DE];

            for (int index = 0; index < deTire.length; index++) {
                deTire[index] = genereFaceAleatoire(NBRE_FACE);
            }
            afficherDee(deTire);
            for (int j = 0; j < 2; j++) {
                int[] position = demandeRelance();
                if (position.length == 0) {
                    break;
                } else {
                    relanceDe(deTire, position);
                    if (j != 1) {
                        afficherDee(deTire);
                    }
                }
            }
            afficherDee(deTire);
            System.out.println("\n\n");


            String[] combinaison = {
                    "Une paire",
                    "Deux paire",
                    "Brelan",
                    "Carre",
                    "FullHouse",
                    "PetiteSuite",
                    "GrandeSuite",
                    "Yatzee"
            };

            int[] nbreOccurent = compteNbreOccurences(deTire);
            int[] point = {
                    unePaire(nbreOccurent),
                    deuxPaire(nbreOccurent),
                    brelan(nbreOccurent),
                    carre(nbreOccurent),
                    fullHouse(nbreOccurent),
                    petiteSuite(nbreOccurent),
                    grandeSuite(nbreOccurent),
                    yahtzee(nbreOccurent)
            };

           pointTotal += calculeTotal(combinaison, point, dejaUtiliser);
            System.out.println("\nTotal des points : " + pointTotal);
        }
        System.out.println("\nSCORE FINAL : " + pointTotal);
    }

}
