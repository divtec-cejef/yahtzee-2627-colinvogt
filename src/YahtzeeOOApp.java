public class YahtzeeOOApp {

    /**
     * Point d'entré du progranmme
     *
     */
    public static void main(String[] args) {
        ConsoleIO io = new ConsoleIO();
        Game game = new Game(io);
        game.jouerPartie();
    }
}
