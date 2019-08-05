package cn.hgbigdatastudio.somp.utils;

import android.content.Context;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: Pulis
 * @CreateDate: 2019/7/12 17:03
 * @Description: 类作用描述
 */
public class PermissionGainHelper {
    private static PermissionGainHelper mHelper;
    private List<String> mPermissionList;
    private Context mContext;
    /**
     *@Desc:回调接口
    */
    private PermissionRequestCallBack mCallBack;
    public static PermissionGainHelper newInstance(Context context){
        if (mHelper==null){
            synchronized (PermissionGainHelper.class){
                if (mHelper==null){
                    mHelper=new PermissionGainHelper(context);
                }
            }
        }
        return mHelper;
    }
    private PermissionGainHelper(Context context){
        mContext=context;

    }
    public PermissionGainHelper setPermission(String[] permissions){
        mPermissionList=Arrays.asList(permissions);
        return mHelper;
    }
    public PermissionGainHelper setCallBack(PermissionRequestCallBack callBack){
        this.mCallBack = callBack;
        return mHelper;
    }
    public void request(){

        PermissionGainActivity.PermissionManager.init(mContext,mPermissionList,mCallBack);
        PermissionGainActivity.PermissionManager.request();
    }


}
