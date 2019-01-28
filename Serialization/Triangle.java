public class Triangle extends AbstractFigure {

    private String color;
    private int size;

    public Triangle(String color, int size) {
        this.color = color;
        this.size = size;
    }

    @Override
    public void draw() {
        System.out.println("imagine like we drawed a Triangle! (equilateral triangle)");
        System.out.println("Width is: " /*+  getSize()*/);
        System.out.println("height is: " /*+ (getSize() * Math.sqrt(3)) / 2 */);
    }

    @Override
    public void fill(String color) {
        System.out.printf("and we fill it with %s color", color);
        System.out.println("\n");
    }
}
