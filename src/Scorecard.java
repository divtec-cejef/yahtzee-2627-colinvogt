import java.util.ArrayList;

public class Scorecard {
    private ArrayList<ScoreEntry> historique = new ArrayList<>();

    public void ajouterScore(ScoreEntry entry) {
        historique.add(entry);
    }

    public boolean estUtilisee(Category categorie) {
        for (ScoreEntry entry : historique) {
            if (entry.getCategory() == categorie) {
                return true;
            }
        }
        return false;
    }

    public int calculPointTotal() {
        int pointTotal = 0;
        for (ScoreEntry entry : historique) {
            pointTotal += entry.getPointObtenu();
        }
        return pointTotal;
    }
}
