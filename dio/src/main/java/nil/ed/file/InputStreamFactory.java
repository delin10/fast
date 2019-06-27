package nil.ed.file;

import java.io.InputStream;

public interface InputStreamFactory {
    InputStream create(String file);
}
