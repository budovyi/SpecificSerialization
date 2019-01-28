import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collections;

public abstract class AbstractFigure implements Figure {

    public abstract void draw();
    public abstract void fill(String color);
    private String Color;
    private int size;
    private StringBuilder sb;

    public String getColor() {
        return Color;
    }

    public int getSize() {
        return size;
    }
}
