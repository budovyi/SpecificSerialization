import java.util.*;

public class Immutable {
    public static void main(String[] args) {
        List<String> list = new ArrayList();
        list.add("line 1");
        list.add("line 2");

        ImmutableClass ic = new ImmutableClass("Vaska", 5, list);

        for (String s : ic.getList()) {
            System.out.println(s);
        }
    }
}

final class ImmutableClass {
    private final String name;
    private final int age;
    private final List<String> list;

    public ImmutableClass(String name, int age, List<String> list) {
        this.name = name;
        this.age = age;
        this.list = list;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public List<String> getList() {
        return new ArrayList(list);
    }
}
