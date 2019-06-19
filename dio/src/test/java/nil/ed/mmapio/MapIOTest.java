package nil.ed.mmapio;

import nil.ed.file.data.impl.AppendMappedDataOutputStreamFactory;
import nil.ed.file.data.impl.MappedDataInputStreamFactory;
import nil.ed.file.data.impl.UpdateMappedDataOutputStreamFactory;
import nil.ed.file.data.impl.WriteDataType;
import org.junit.Test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;

public class MapIOTest {
    private String file = "E:/myTemp/test111.txt";

    @Test
    public void test() throws Exception {
        MappedDataInputStreamFactory mappedDataInputStreamFactory = new MappedDataInputStreamFactory();
        try (DataInputStream inputStream = mappedDataInputStreamFactory.create(file)) {
            while (true) {
                System.out.println(inputStream.readInt());
            }
        } catch (EOFException eof) {

        } catch (RuntimeException e) {

        }
        int count = 1;
        UpdateMappedDataOutputStreamFactory updateMappedDataOutputStreamFactory=new UpdateMappedDataOutputStreamFactory();

        AppendMappedDataOutputStreamFactory ammap = new AppendMappedDataOutputStreamFactory(count, WriteDataType.INT);
        try (DataOutputStream outputStream = ammap.create("E:/myTemp/test111.txt")) {
            for (int i = 0; i < count; ++i) {
                outputStream.writeInt(i);
            }
        }
    }
}
