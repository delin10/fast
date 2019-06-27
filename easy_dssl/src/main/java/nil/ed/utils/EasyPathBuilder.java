package nil.ed.utils;

public class EasyPathBuilder {
    public static String getRootClassPathResource(Class<?> clazz, String file) {
        return clazz.getClassLoader().getResource(file).getFile();
    }
}
