public class Die {

    private final int sideCount = 6;
    private int visibleSide;

    /**
     * Construit le dé
     */
    Die() {
    }

    /**
     * Lance les dés
     * @return un chiffre aleatoire entre 1 et 6
     */
    public int roll() {
        this.visibleSide = (int) (Math.random() * sideCount + 1);
        return this.visibleSide;
    }

    /**
     * Obtient la face tiré
     * @return la face tiré
     */
    public int getVisibleSide() {
        return this.visibleSide;
    }
}
