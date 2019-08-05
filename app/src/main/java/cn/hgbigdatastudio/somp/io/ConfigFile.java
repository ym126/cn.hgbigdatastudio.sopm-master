package cn.hgbigdatastudio.somp.io;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import java.io.File;

import cn.hgbigdatastudio.somp.utils.FilePathUtils;

public class ConfigFile {
    /**
     * Desc:获取路径 /data/data/包名/files/config/config
     */
    private static String mConfigFilePath= FilePathUtils.getConfigFilePath();
    private static String configFileName="config";
    private static Context mContex;
    /**
     * Desc:文件是否存在
     */
    public static void with(Context context){
        mContex=context;

    }
    /**
     * Desc:查看文件是否存在
     */
    public static boolean configFileExists(){
        File file=new File(mConfigFilePath);
        return file.exists();
    }
    /**
     * Desc:写数据
     */
    public static void writeConfig(String k,String v){
        if (mContex == null) {
            return;
        }
        SharedPreferences sp= mContex.getSharedPreferences(configFileName,Context.MODE_PRIVATE);
        sp.edit().putString(k,v).commit();
    }

}
