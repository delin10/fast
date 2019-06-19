package nil.ed.file.data;

import nil.ed.file.OuputStreamFactory;

import java.io.DataOutputStream;
import java.nio.file.Path;

public interface DataOutputStreamFactory extends OuputStreamFactory {
    DataOutputStream create(Path file);

    DataOutputStream create(String file);

    DataOutputStream create(String base, String file);
}
