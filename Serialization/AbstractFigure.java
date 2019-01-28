public abstract class AbstractFigure implements Figure {

    private String color;
    private int size;
    private StringBuilder sb;

    public abstract void draw();
    public abstract void fill(String color);

    public String getColor() {
        return color;
    }

    public int getSize() {
        return size;
    }
}
