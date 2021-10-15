package util;


import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;

public class FileUtil {
    public static void copyFile(File srcFile,File destFile)throws Exception{
        copyFile(srcFile,destFile,true);
    }

    public static void copyFile(File srcFile,File destFile,boolean preserveFileDate) throws Exception{
        checkFileRequirements(srcFile,destFile);
        docopyFile(srcFile,destFile);
    }

    public static void docopyFile(File srcFile,File destFile) throws Exception{
        if (destFile.exists() && destFile.isDirectory()){
            throw new IOException("Destination '"+ destFile + "' exists but is a directory");
        }
        Files.copy(srcFile.toPath(),destFile.toPath());
//        FileUtils

    }

    public static void checkFileRequirements(File src,File dest) throws  Exception{
        if (src == null){
            throw new NullPointerException("Source file is null , please check object initialization");
        }
        if (src == null) {
            throw new NullPointerException("Source file is null , please check object initialization");
        }
        if(!src.exists()){
            throw new FileNotFoundException("Source file '"+src+"' does not exist, please check");
        }
        if(src.isDirectory()){
            throw new IOException("Source file '"+src+"' exist but is a directory");
        }
        if (src.getCanonicalPath().equals(dest.getCanonicalPath())) {
            throw new IOException("Source '" + src + "' and destination '" + dest + "' are the same");
        }
        if (dest.exists() && dest.canWrite() == false){
            throw new IOException("Destination '" + dest + "' exists but is read-only");
        }

        //1067
    }
}
