package nil.ed.exception;

public class RuntimeExceptionWrapper {
    public static RuntimeException wrap(Exception e) {
        return new RuntimeException(e);
    }
}
