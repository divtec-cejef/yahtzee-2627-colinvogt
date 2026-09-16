public class Die {

    private final int sideCount = 6;
    private int visibleSide;

    Die() {

    }

public int roll() {
        return (int) (Math.random() * sideCount + 1);
    }

    public int getVisibleSide() {
        return this.visibleSide;
    }
}
