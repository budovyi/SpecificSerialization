public class Circle extends AbstractFigures {

    private String Color;
    private int size;

    public Circle(String color, int size) {
        this.Color = color;
        this.size = size;
    }

    @Override
    public void draw() {
        System.out.println("imagine like we drawed a Circle!");
        System.out.println("Width is: " /*+  getSize()*/);
        System.out.println("height is: " /*+ (getSize() * Math.sqrt(3)) / 2 */);
    }

    @Override
    public void fill(String color) {
        System.out.printf("and we fill it with %s color", color);
        System.out.println("\n");
    }
}
