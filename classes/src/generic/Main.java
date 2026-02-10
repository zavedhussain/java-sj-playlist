package generic;

public class Main {
    public static void main(String[] args) {
        PrintGeneric<Integer> print = new PrintGeneric<>(1);
        Integer value = print.getValue();
        // no typecasting required
        PrintGeneric<String> print2 = new PrintGeneric<>("hello");
        String value2 = print2.getValue();

        //internally passes Object as parametrized type if used without type.
        PrintGeneric rawPrintObj = new PrintGeneric();
        //can later pass any type
        rawPrintObj.setValue("hello");
        rawPrintObj.setValue(1);

        System.out.println(value +" "+ value2);
    }
}
