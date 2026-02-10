package generic;

// need to define type for print if subclass is non generic
public class ColorPrintString extends PrintGeneric<String>{
    ColorPrintString(String value) {
        super(value);
    }
}
