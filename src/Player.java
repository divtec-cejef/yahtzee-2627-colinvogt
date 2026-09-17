public class Player {

    private final String NOM;
    private final Scorecard FEUILLE_SCORE;

    Player(String nom, Scorecard feuilleScore) {
        this.NOM = nom;
        this.FEUILLE_SCORE = feuilleScore;
    }

    public String getNom() {
        return NOM;
    }

    public Scorecard getFeuilleScore() {
        return FEUILLE_SCORE;
    }
}