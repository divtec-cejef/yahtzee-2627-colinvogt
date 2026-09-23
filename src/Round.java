public class Round {
    private final ConsoleIO io;
    private final DiceHand diceHand;

    Round(ConsoleIO io) {
        this.io = io;
        this.diceHand = new DiceHand();
    }
}
