public class DiceHand {

    private int NBRE_DE = 5;
    private Die[] dice = new Die[NBRE_DE];

    /**
     * Initialise les dé
     */
    public void initialiseDie() {
        for (int index = 0; index < dice.length; index++) {
            dice[index].roll();
        }
    }

    /**
     * lance les dé
     */
    public void rollDice() {
        for (Die d: dice) {
            d.roll();
        }
    }

    /**
     * Relance les dé a une liste d'index donné
     * @param index
     */
    public void rerollDie(int[] index) {
      for (int i : index) {
          dice[i].roll();
      }
    }

    public int[] geValue() {
        int[] value = new int[dice.length];
        for (int i=0; i < value.length; i++) {
            value[i] = dice[i].getVisibleSide();
        }
        return value;
    }

    /**
     * Compte le nombre d'occurent d'une liste de dé
     * @param deTire
     * @return le nombre d'occurence des dé (occurence de 1 = index 0)
     */
    public static int[] compteNbreOccurences(int[] deTire) {
        int[] nbrOccuren = new int[6];
        for (int position = 0; position < deTire.length; position++) {
            nbrOccuren[deTire[position] - 1]++;
        }
        return nbrOccuren;
    }

    /**
     * Detecte un paire
     * @param nbreOccuren
     * @return Si la liste de dé contien une paire
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
     * @return Si la liste de dé contien deux paire
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
     * @return Si la liste de dé contien un brelan
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
     * @return Si la liste de dé contien un carré
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
     * @return 25 si il y a une full house dans la liste, sinon 0
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
     * @return 30 si il y a une petite suite dans la liste, sinon 0
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
     * @return 40 si il y a une grande suite dans la liste, sinon 0
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
     * @return 50 si il y a un Yatzee dans la liste, sinon 0
     */
    public static int yahtzee(int[] nbreOccuren) {
        for (int i = 0; i < nbreOccuren.length; i++) {
            if (nbreOccuren[i] == 5) {
                return 50;
            }
        }
        return 0;
    }
}
