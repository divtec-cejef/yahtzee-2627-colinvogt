public class ScoreEntry {

    private final Category CATEGORY;
    private final int POINT_OBTENU;
    private final int[] JET_FINAL;

    /**
     * Construit le score
     * @param category
     * @param pointObtenu
     * @param jetFinal
     */
    ScoreEntry (Category category, int pointObtenu, int[] jetFinal) {
        this.CATEGORY = category;
        this.POINT_OBTENU = pointObtenu;
        this.JET_FINAL = jetFinal;
    }

    /**
     * Obtient la categorie
     * @return la categorie
     */
    public Category getCategory() {
        return CATEGORY;
    }

    /**
     * Obtient le nombre de point obtenu
     * @return
     */
    public int getPointObtenu() {
        return POINT_OBTENU;
    }

    /**
     * Obtient le jet final
     * @return le jet final
     */
    public int[] getJetFinal() {
        int[] copie = new int[JET_FINAL.length];
        for (int i = 0; i < copie.length; i++) {
            copie[i] = JET_FINAL[i];
        }
        return copie;
    }
}
