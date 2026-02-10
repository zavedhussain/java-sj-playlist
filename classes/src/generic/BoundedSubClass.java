package generic;

//upper bound by extends
//cannot lower bound by super as that would be pointless as type can be even Object with no relation to Number at all

public class BoundedSubClass<T extends Number> {
}
