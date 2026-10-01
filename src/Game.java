import java.util.ArrayList;

public class Game {
    private final ConsoleIO io;
    private final Player PLAYER;

    /**
     * Contruit la partie
     * @param io L'entré et la sortie de la console
     */
    public Game(ConsoleIO io) {
        this.io = io;
        io.afficher("Quel est votre nom ?");
        String nomJoueur = io.lireLigne();
        Scorecard feuilleScore = new Scorecard();
        this.PLAYER = new Player(nomJoueur, feuilleScore);
    }

    /**
     * Joue la partie
     */
    public void jouerPartie() {
        for (int i = 0; i < 5; i++) {
            io.afficher("\nMANCHE " + (i + 1) + "\n");
            Round round = new Round(io);
            DiceHand resultatDes = round.jouerManche();

            ArrayList<Category> categoriesDisponibles = new ArrayList<>();

            for (Category categorie : Category.values()) {
                if (PLAYER.getFeuilleScore().estUtilisee(categorie)) {
                    categoriesDisponibles.add(categorie);
                    String ligne = String.format("%d.%-15s [%d pts]", categoriesDisponibles.size(), categorie.getNom(), categorie.getScore(resultatDes));
                    io.afficher(ligne);
                }
            }
            String choix = io.lireLigne();
            int numeroChoisi = Integer.parseInt(choix);
            Category categorieChoisie = categoriesDisponibles.get(numeroChoisi - 1);
            int points = categorieChoisie.getScore(resultatDes);
            ScoreEntry entry = new ScoreEntry(categorieChoisie, points, resultatDes.getValue());
            PLAYER.getFeuilleScore().ajouterScore(entry);
        }

        io.afficher("\nJoueur : " + PLAYER.getNom());
        for (ScoreEntry entry : PLAYER.getFeuilleScore().getHistorique()) {
            String prompt = String.format("%-15s [%d pts]", entry.getCategory().getNom(), entry.getPointObtenu());
            io.afficher(prompt);
        }
        String prompt = String.format("Point Totaux : %d", PLAYER.getFeuilleScore().calculPointTotal());
        io.afficher(prompt);
    }
}
