public class ScoreEntry {

    private final Category category;
    private final int NBRE_DE_MAX = 5;
    private final int POINT_OBTENU = 0;
    private final int[] JET_FINAL = new int[NBRE_DE_MAX];

    ScoreEntry (Category category, int pointObtenu, int[] jetFinal) {
        this.category = category;
        this.POINT_OBTENU = pointObtenu;
        this.JET_FINAL = jetFinal;
    }

}
