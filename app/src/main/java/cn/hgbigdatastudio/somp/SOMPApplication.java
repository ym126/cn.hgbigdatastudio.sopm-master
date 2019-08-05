package cn.hgbigdatastudio.somp;

import android.app.Application;

import cn.hgbigdatastudio.somp.utils.FilePathUtils;

/**
 * @Author: Pulis
 * @CreateDate: 2019/7/11 20:17
 * @Description: Application
 */
public class SOMPApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        FilePathUtils.with(this);
    }
}
