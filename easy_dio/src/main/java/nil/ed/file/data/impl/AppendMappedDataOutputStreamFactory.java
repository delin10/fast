package nil.ed.file.data.impl;

import nil.ed.iox.ByteBufferOutputStream;

import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class AppendMappedDataOutputStreamFactory extends AbstractDataOutputstreamFactory {
    private int size = 0;
    private WriteDataType type;

    public AppendMappedDataOutputStreamFactory(int size, WriteDataType type) {
        this.size = size;
        this.type = type;
    }

    @Override
    public DataOutputStream create(Path file) {
        try {
            FileChannel channel = FileChannel.open(file, StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.READ);
            int length = (int) channel.size();
            MappedByteBuffer byteBuffer = channel.map(FileChannel.MapMode.READ_WRITE, length, size * type.getSize());
            return new DataOutputStream(new ByteBufferOutputStream(byteBuffer, length));
        } catch (IOException ie) {
            throw new RuntimeException(ie);
        }
    }


}
