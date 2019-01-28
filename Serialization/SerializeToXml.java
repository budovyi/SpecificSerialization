import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SerializeToXml {
    private static StringBuilder sb = new StringBuilder();
    private static int count = 0;
    private static String tabRepeat = String.join("", Collections.nCopies(count, "\t"));
    private static List<Group> childGroups = new ArrayList();
    private static List<Figure> list = new ArrayList();

    public static void serialize(Group group) {
        childGroups = group.getChildGroups();
        list = group.getList();
        toXml();
    }

    private static void toXml() {
        for (Figure figure : list) {
            Class clazz = figure.getClass();
            String tab = "\t";
            String nuw = "\n";
            String tabRepeat = String.join("", Collections.nCopies(count, tab));

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
        }

        if (false == childGroups.isEmpty()) {
            count++;
            tabRepeat = String.join("", Collections.nCopies((count - 1), "\t"));
            sb.append("\n" + tabRepeat).append("<").append("InnerGroupLevel " + (count)).append(">");
            for (Group group : childGroups) {
               serialize(group);
            }
            tabRepeat = String.join("", Collections.nCopies((count - 1), "\t"));
            sb.append("\n" + tabRepeat).append("</").append("InnerGroupLevel " + (count)).append(">");
            count--;
        }
    }

    public static void print() {
        System.out.println(sb.toString());
    }
}
