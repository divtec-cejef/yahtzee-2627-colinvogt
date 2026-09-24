import java.util.ArrayList;

public class Scorecard {
    private ArrayList<ScoreEntry> historique = new ArrayList<>();

    /**
     * Ajoute le Score a un liste de score
     * @param entry le score a ajouter
     */
    public void ajouterScore(ScoreEntry entry) {
        if (!estUtilisee(entry.getCategory())) {
            historique.add(entry);
        }
    }

    /**
     * Verifie si la categorie mise en parametre est utiliser
     * @param categorie la categorie a verifier
     * @return True si la category est utiliser, sinon false
     */
    public boolean estUtilisee(Category categorie) {
        for (ScoreEntry entry : historique) {
            if (entry.getCategory() == categorie) {
                return true;
            }
        }
        return false;
    }

    /**
     * Calcule le nombre de point total
     * @return le nombre de point total
     */
    public int calculPointTotal() {
        int pointTotal = 0;
        for (ScoreEntry entry : historique) {
            pointTotal += entry.getPointObtenu();
        }
        return pointTotal;
    }
}
