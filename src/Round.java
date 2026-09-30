public class Round {
    private final ConsoleIO io;
    private final DiceHand diceHand;
    static final String regex = "[,\\.\\s]";

    Round(ConsoleIO io) {
        this.io = io;
        this.diceHand = new DiceHand();
    }

    public int[] demandeRelance() {
        System.out.println("\nQuel dés voulez vous relancez ? (Saisir de 1-5 ou 0 si vous ne voulez pas relancer) Atenttion 3 lancé MAX!\n");
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


    public int[] jouerManche() {
       diceHand.rollDice();
        io.afficher(diceHand.toString());
        for (int j = 0; j < 2; j++) {
            int[] position = demandeRelance();
            if (position.length == 0) {
                break;
            } else {
               diceHand.rerollDie(position);
                if (j != 1) {
                    io.afficher(diceHand.toString());
                }
            }
        }
        io.afficher(diceHand.toString());
       return diceHand.getValue();
    }
}
