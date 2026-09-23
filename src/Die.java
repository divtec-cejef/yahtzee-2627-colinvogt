public class Die {

    private final int sideCount = 6;
    private int visibleSide;

    Die() {
    }

public int roll() {
        this.visibleSide = (int) (Math.random() * sideCount + 1);
        return this.visibleSide;
    }

    public int getVisibleSide() {
        return this.visibleSide;
    }
}
