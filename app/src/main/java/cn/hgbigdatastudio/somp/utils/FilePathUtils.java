package cn.hgbigdatastudio.somp.utils;

import android.content.Context;
import android.util.Log;

import java.io.File;

public class FilePathUtils {
    /**
     * Desc:默认路径 ：data/data/包名/files/
     */
    private static String APPPATH;
    private static Context mContext;

    /**
     * Desc:初始化
     */
    public static void with(Context context){
        mContext=context;
  
        APPPATH = context.getFilesDir().getAbsolutePath();
        Log.e("FilePathUtils",APPPATH);
    }

    /**
     * Desc:初始化文件路径
     */
    public static String getConfigFilePath(){
        return APPPATH+File.separator+"config"+File.separator+"config";
    }
}
