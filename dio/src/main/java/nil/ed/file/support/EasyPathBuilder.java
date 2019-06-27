package nil.ed.file.support;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class EasyPathBuilder {
    public static Path buildPath(String first, String... more) {
        try {
            return Paths.get(first, more);
        } catch (Exception pe) {
            throw new RuntimeException(pe);
        }
    }

    public static Path buildTempPath(String base,String prefix,String suffix){
        try {
            return Files.createTempFile(buildPath(base),prefix,suffix);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
