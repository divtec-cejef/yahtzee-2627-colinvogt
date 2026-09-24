public class Round {
    private final ConsoleIO io;
    private final DiceHand diceHand;
    static final String regex = "[,\\.\\s]";

    Round(ConsoleIO io) {
        this.io = io;
        this.diceHand = new DiceHand();
    }

    public int[] jouerManche() {
        boolean estRepete = true;
        int compteurRepete = 0;
        diceHand.rollDice();
        do {
            io.afficher("\nQuel dés voulez vous relancez ? (Saisir de 1-5 ou 0 si vous ne voulez pas relancer) Atenttion 3 lancé MAX!\n");
            String desChoisi;
            desChoisi = io.lireLigne();
            String[] parts = desChoisi.split(regex);
            int[] indice = new int[parts.length];
            if (desChoisi.equals("0") || desChoisi.isEmpty()) {
                estRepete = false;
            } else {
                for (int i = 0; i < parts.length; i++) {
                    indice[i] = Integer.parseInt(parts[i]) - 1;
                }
            }
            diceHand.rerollDie(indice);
            compteurRepete++;
        } while (estRepete || compteurRepete != 2);
    }
}
