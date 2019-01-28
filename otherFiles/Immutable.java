import java.util.*;

public class Immutable {
    private List<String> list;

    public static void main(String[] args) {
       new Immutable().start();
    }

    private void start() {
        list = new ArrayList();
        list.add("line 1");
        list.add("line 2");

        ImmutableClass ic = new ImmutableClass("Vaska", 5, list);

        for (String string : ic.getList()) {
            System.out.println(string);
        }
    }
}
