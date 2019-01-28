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

final class ImmutableClass {
    private final String name;
    private final int age;
    private final List<String> listIn;

    public ImmutableClass(String name, int age, List<String> list) {
        this.name = name;
        this.age = age;
        this.listIn = list;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public List<String> getList() {
        return new ArrayList(listIn);
    }
}
