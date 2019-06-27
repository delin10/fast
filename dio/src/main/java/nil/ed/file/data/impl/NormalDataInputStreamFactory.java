package nil.ed.file.data.impl;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class NormalDataInputStreamFactory extends AbstractDataInputstreamFactory {
    @Override
    public DataInputStream create(Path file) {
        try {
            return new DataInputStream(Files.newInputStream(file));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
