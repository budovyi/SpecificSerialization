import java.util.*;

public class Group {
    private static StringBuilder sb = new StringBuilder();
    private static int count = 0;
    private String tabRepeat = String.join("", Collections.nCopies(count, "\t"));
    private List<IFigures> list = new ArrayList();
    private List<Group> childGroups = new ArrayList();

    public void addGroups(Group... groups) {
        for (Group g : groups) {
            childGroups.add(g);
        }
    }

    public void addFigures(IFigures... figures) {
        for (IFigures f : figures) {
            list.add(f);
        }
    }

    public void remove(IFigures figure) {
        list.remove(figure);
    }

    public void toXml() {
        for (IFigures figure : list) {
            sb.append(figure.toXml(figure));
        }
        if (false == childGroups.isEmpty()) {
            count++;
            tabRepeat = String.join("", Collections.nCopies((count - 1), "\t"));
            sb.append("\n" + tabRepeat).append("<").append("InnerGroupLevel " + (count)).append(">");
            for (Group group : childGroups) {
                group.toXml();
            }
            tabRepeat = String.join("", Collections.nCopies((count - 1), "\t"));
            sb.append("\n" + tabRepeat).append("</").append("InnerGroupLevel " + (count)).append(">");
            count--;
        }
    }

    public void toJson() {
        for (IFigures figure : list) {
            sb.append(figure.toJson(figure));
        }
        if (false == childGroups.isEmpty()) {
            count++;
            tabRepeat = String.join("", Collections.nCopies((count - 1), "\t"));
            for (Group group : childGroups) {
                group.toJson();
            }
            tabRepeat = String.join("", Collections.nCopies((count - 1), "\t"));

            count--;
        }
    }

    public static String getSb() {
        return sb.toString();
    }

    public static int getCount() {
        return count;
    }
}
