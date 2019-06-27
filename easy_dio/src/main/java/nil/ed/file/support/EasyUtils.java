package nil.ed.file.support;

import java.io.File;

public class EasyUtils {
    /**
     * get absolute path based on project root path
     * @param fileRelativePath
     * @return
     */
    public static String getProjectAbsolutePath(String fileRelativePath) {
        return new File(fileRelativePath).getAbsolutePath();
    }
}
