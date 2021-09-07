package com.zqh.fileoperation.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangqh
 * @date 2021/9/7 0007 9:14
 */
public class FileUtil {

    /**
     * @Author：
     * @Description：获取某个目录下所有直接下级文件，不包括目录下的子目录的下的文件，所以不用递归获取
     * @Date：
     */
    public static List<String> getFiles(String path) {
        List<String> files = new ArrayList<String>();
        File file = new File(path);
        File[] tempList = file.listFiles();

        for (int i = 0; i < tempList.length; i++) {
            if (tempList[i].isFile()) {
                //System.out.println(tempList[i].toString());
                files.add(tempList[i].toString());
                //文件名，不包含路径
                //String fileName = tempList[i].getName();
            }
            if (tempList[i].isDirectory()) {
                //这里就不递归了，
            }
        }
        return files;
    }

    public static String getFileName(String file) {
        int i = file.lastIndexOf("\\");
        return file.substring(i+1,file.length());
    }

    public static String getFileSuffix(String file) {
        int i = file.lastIndexOf(".");
        return file.substring(i+1,file.length());
    }

    public static String getFile2Base64(File file) {
        return null;
    }
}
