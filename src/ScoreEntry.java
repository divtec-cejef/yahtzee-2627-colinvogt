import java.util.ArrayList;
import java.util.Arrays;

public class ScoreEntry {

    private final Category CATEGORY;
    private final int POINT_OBTENU;
    private final int[] JET_FINAL;

    ScoreEntry (Category category, int pointObtenu, int[] jetFinal) {
        this.CATEGORY = category;
        this.POINT_OBTENU = pointObtenu;
        this.JET_FINAL = jetFinal;
    }

    public Category getCategory() {
        return CATEGORY;
    }

    public int getPointObtenu() {
        return POINT_OBTENU;
    }

    public int[] getJetFinal() {
        int[] copie = new int[JET_FINAL.length];
        for (int i : copie) {
            copie[i] = JET_FINAL[i];
        }
        return copie;
    }
}
