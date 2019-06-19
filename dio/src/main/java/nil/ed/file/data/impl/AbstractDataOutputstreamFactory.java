package nil.ed.file.data.impl;

import nil.ed.file.data.DataOutputStreamFactory;
import nil.ed.file.support.EasyPathBuilder;

import java.io.DataOutputStream;

public abstract class AbstractDataOutputstreamFactory implements DataOutputStreamFactory {
    @Override
    public DataOutputStream create(String file) {
        return create(EasyPathBuilder.buildPath(file));
    }

    @Override
    public DataOutputStream create(String base, String file) {
        return create(EasyPathBuilder.buildPath(base, file));
    }
}
