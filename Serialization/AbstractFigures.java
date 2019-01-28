import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collections;

public abstract class AbstractFigures implements IFigures {

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

    public String toXml(IFigures figure) {
        sb = new StringBuilder();
        Class clazz = figure.getClass();
        String tab = "\t";
        String nuw = "\n";
        String tabRepeat = String.join("", Collections.nCopies(Group.getCount(), tab));

        sb.append(nuw).append(tabRepeat).append("<").append(clazz.getName()).append(">");
        for (Field f : clazz.getDeclaredFields()) {
            String fieldType = f.getAnnotatedType().getType().getTypeName().replaceFirst("java.lang.", "");
            f.setAccessible(true);
            String value = null;
            try {
                value = String.valueOf(f.get(figure));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

            //xml build logic
            sb.append(nuw + tab).append(tabRepeat).append("<").append(fieldType).append(">");
            sb.append(nuw + tab + tab).append(tabRepeat).append("<name>").append(f.getName()).append("</name>");
            sb.append(nuw + tab + tab).append(tabRepeat).append("<value>").append(value).append("</value>");
            sb.append(nuw + tab).append(tabRepeat).append("</").append(fieldType).append(">");
        }
        for (Method met : clazz.getDeclaredMethods()) {
            sb.append(nuw + tab).append(tabRepeat).append("<method>").append(met.getName()).append("</method>");
        }
        sb.append(nuw).append(tabRepeat).append("</").append(clazz.getName()).append(">");

        return sb.toString();
    }

    public String toJson(IFigures figure) {
        sb = new StringBuilder();

        Class clazz = figure.getClass();
        String tab = "\t";
        String nuw = "\n";
        String tabRepeat = String.join("", Collections.nCopies(Group.getCount(), tab));

        sb.append(tabRepeat).append("{\n");
        sb.append(tabRepeat).append("\"").append(clazz.getName()).append("\" : ").append("{");
        for (Field f : clazz.getDeclaredFields()) {
            f.setAccessible(true);
            String value = null;
            try {
                value = String.valueOf(f.get(figure));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

            //json build logic
            sb.append(nuw + tab).append(tabRepeat).append("\"").append(f.getName()).append("\": ");
            sb.append("\"").append(value).append("\",");
        }

        for (Method met : clazz.getDeclaredMethods()) {
            sb.append(nuw + tab).append(tabRepeat).append("\"").append(met.getName()).append("\" : {");
            sb.append(nuw + tab).append(tabRepeat).append("}\n");
        }
        sb.append(tabRepeat).append("}\n");
        return sb.toString();
    }
}
