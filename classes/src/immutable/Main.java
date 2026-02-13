package immutable;

import java.util.List;

public class Main {

    public static void main(String[] args){
        Immutable immutableClass = new Immutable("zaved", List.of("ZAVED","SIKDAR"));

        List<String> names = immutableClass.getList();
        names.set(0, "LUIS");

        immutableClass.getList()
                .forEach(System.out::println);
    }
}
