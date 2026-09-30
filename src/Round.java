import java.util.Arrays;

public class Round {
    private final ConsoleIO io;
    private final DiceHand diceHand;
    static final String regex = "[,\\.\\s]";

    /**
     * Construit le round
     * @param io
     */
    Round(ConsoleIO io) {
        this.io = io;
        this.diceHand = new DiceHand();
    }

    /**
     * Demande a l'utilisateur si il veut relancer rien ou plusieur dé
     * @return les dé que l'utilisateur a saisie mais converti en int
     */
    public int[] demandeRelance() {
        io.afficher("\nQuel dés voulez vous relancez ? (Saisir de 1-5 ou 0 si vous ne voulez pas relancer) Atenttion 3 lancé MAX!\n");
        String desChoisi;
        desChoisi = io.lireLigne();
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
     * Joue la manche
     * @return le jet final
     */
    public DiceHand jouerManche() {
       diceHand.rollDice();
        io.afficher(Arrays.toString(diceHand.getValue()));
        for (int j = 0; j < 2; j++) {
            int[] position = demandeRelance();
            if (position.length == 0) {
                break;
            } else {
               diceHand.rerollDie(position);
                if (j != 1) {
                    io.afficher(Arrays.toString(diceHand.getValue()));
                }
            }
        }
        io.afficher(Arrays.toString(diceHand.getValue()));
       return diceHand;
    }
}
