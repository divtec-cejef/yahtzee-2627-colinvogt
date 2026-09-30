public class Game {
    private final ConsoleIO io;
    private final Player PLAYER;

    public Game(ConsoleIO io) {
        this.io = io;
        io.afficher("Quel est votre nom ?");
        String nomJoueur = io.lireLigne();
        Scorecard feuilleScore = new Scorecard();
        this.PLAYER = new Player(nomJoueur, feuilleScore);
    }
}
