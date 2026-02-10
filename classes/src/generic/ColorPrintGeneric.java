package generic;

// need to have same generic type for subclass if it is generic as well
public class ColorPrintGeneric<T> extends PrintGeneric<T>{
    ColorPrintGeneric(T value) {
        super(value);
    }
}
