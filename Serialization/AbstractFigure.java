public abstract class AbstractFigure implements Figure {

    private String Color;
    private int size;
    private StringBuilder sb;

    public abstract void draw();
    public abstract void fill(String color);

    public String getColor() {
        return Color;
    }

    public int getSize() {
        return size;
    }
}
