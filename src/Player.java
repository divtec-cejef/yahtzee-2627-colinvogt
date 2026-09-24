public class Player {

    private final String NOM;
    private final Scorecard FEUILLE_SCORE;

    /**
     * Constuit le joueur
     * @param nom nom du joueur
     * @param feuilleScore feuille de score du joueur
     */
    Player(String nom, Scorecard feuilleScore) {
        this.NOM = nom;
        this.FEUILLE_SCORE = feuilleScore;
    }

    /**
     * Obtient le nom du joueur
     * @return le nom du joueur
     */
    public String getNom() {
        return NOM;
    }

    /**
     * Obtient la feuille de score du joueur
     * @return la feuille de score du joueur
     */
    public Scorecard getFeuilleScore() {
        return FEUILLE_SCORE;
    }
}