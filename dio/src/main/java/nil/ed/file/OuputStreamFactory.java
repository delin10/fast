package nil.ed.file;

import java.io.OutputStream;

public interface OuputStreamFactory {
    OutputStream create(String file);
}
