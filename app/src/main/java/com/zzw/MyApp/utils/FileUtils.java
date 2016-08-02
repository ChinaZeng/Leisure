package com.zzw.MyApp.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by zzw on 2016/8/2.
 * 描述:
 */
public class FileUtils {

    /**
     * @param fromFile 被复制的文件
     * @param toFile   复制的目录文件
     * @param rewrite  是否重新创建文件
     *                 <p>文件的复制操作方法
     */
    public static boolean copyfile(File fromFile, File toFile, Boolean rewrite) {

        if (!fromFile.exists()) {
            return false;
        }

        if (!fromFile.isFile()) {
            return false;
        }

        if (!fromFile.canRead()) {
            return false;
        }
        if (!toFile.getParentFile().exists()) {
            toFile.getParentFile().mkdirs();
        }

        if (toFile.exists() && rewrite) {
            toFile.delete();
        }

        try {
            FileInputStream fosfrom = new FileInputStream(fromFile);
            FileOutputStream fosto = new FileOutputStream(toFile);

            byte[] bt = new byte[1024];
            int c;
            while ((c = fosfrom.read(bt)) > 0) {
                fosto.write(bt, 0, c);
            }
            //关闭输入、输出流
            fosfrom.close();
            fosto.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;

        }
        return true;
    }

}
