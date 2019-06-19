package nil.ed.file.data.impl;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BufferedDataOutputStreamFactory extends AbstractDataOutputstreamFactory {

    @Override
    public DataOutputStream create(Path file) {
        try {
            return new DataOutputStream(new BufferedOutputStream(Files.newOutputStream(file)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
