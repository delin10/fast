package nil.ed.file.data.impl;

import nil.ed.iox.ByteBufferInputStream;

import java.io.DataInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;

public class MappedDataInputStreamFactory extends AbstractDataInputstreamFactory {
    @Override
    public DataInputStream create(Path file) {
        try {
            FileChannel channel = FileChannel.open(file);
            int length = (int) channel.size();
            MappedByteBuffer byteBuffer = channel.map(FileChannel.MapMode.READ_ONLY, 0, length);
            return new DataInputStream(new ByteBufferInputStream(byteBuffer, length));
        } catch (IOException ie) {
            throw new RuntimeException(ie);
        }
    }


}
