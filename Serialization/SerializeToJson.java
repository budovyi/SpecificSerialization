import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SerializeToJson {
    private static StringBuilder sb = new StringBuilder();
    private static int count = 0;
    private static String tabRepeat = String.join("", Collections.nCopies(count, "\t"));
    private static List<Group> childGroups = new ArrayList();
    private static List<Figure> list = new ArrayList();

    public static void serialize(Group group) {
        childGroups = group.getChildGroups();
        list = group.getList();
        toJson();
    }

    private static void toJson() {
        for (Figure figure : list) {
            Class clazz = figure.getClass();
            String tab = "\t";
            String nuw = "\n";
            String tabRepeat = String.join("", Collections.nCopies(count, tab));

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
        }
        if (false == childGroups.isEmpty()) {
            count++;
            tabRepeat = String.join("", Collections.nCopies((count - 1), "\t"));
            for (Group group : childGroups) {
                serialize(group);
            }
            tabRepeat = String.join("", Collections.nCopies((count - 1), "\t"));
            count--;
        }
    }

    public static void print() {
        System.out.println(sb.toString());
    }
}
