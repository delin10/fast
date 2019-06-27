package nil.ed.file.data.impl;

import nil.ed.file.data.DataInputStreamFactory;
import nil.ed.file.support.EasyPathBuilder;

import java.io.DataInputStream;

public abstract class AbstractDataInputstreamFactory implements DataInputStreamFactory {
    @Override
    public DataInputStream create(String file) {
        return create(EasyPathBuilder.buildPath(file));
    }

    @Override
    public DataInputStream create(String base, String file) {
        return create(EasyPathBuilder.buildPath(base, file));
    }
}
