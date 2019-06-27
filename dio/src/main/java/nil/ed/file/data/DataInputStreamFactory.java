package nil.ed.file.data;

import nil.ed.file.InputStreamFactory;

import java.io.DataInputStream;
import java.nio.file.Path;

public interface DataInputStreamFactory extends InputStreamFactory {
    DataInputStream create(Path file);

    DataInputStream create(String file);

    DataInputStream create(String base, String file);
}
