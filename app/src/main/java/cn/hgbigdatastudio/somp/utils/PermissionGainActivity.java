package cn.hgbigdatastudio.somp.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.util.ArrayList;
import java.util.List;

import cn.hgbigdatastudio.somp.R;

public class PermissionGainActivity extends AppCompatActivity {
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        request();
    }
     /**
      *@Desc:请求权限
     */
    private void request() {
        String[] permissions = PermissionManager.mPermissionList.toArray(new String[]{});
        ActivityCompat.requestPermissions(PermissionGainActivity.this,permissions, PermissionManager.REQUEST);
    }
    /**
     *@Desc:权限请求结果回调
    */
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode== PermissionManager.REQUEST&&grantResults.length>0){
            List<String> list=new ArrayList<>();
            for (int i = 0; i < grantResults.length; i++) {
                if (grantResults[i]!= PackageManager.PERMISSION_GRANTED){
                    //获取权限失败
                    list.add(permissions[i]);
                }
            }
            if (list.size()>0){
                //是否勾选不再提示
                finish();
                boolean b=getNotShowRequestPermission(list);
                PermissionManager.requestFailed(b,list);

            }else {
                finish();
                PermissionManager.requestSuccessed();

            }
        }

    }
    /**
     *@Desc:判断用户有没有勾选不在提示
    */
    @RequiresApi(api = Build.VERSION_CODES.M)
    private boolean getNotShowRequestPermission(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            if (!shouldShowRequestPermissionRationale(list.get(i))){
                return true;
            }
        }
        return false;
    }

    /**
     *@Desc:请求权限管理类
    */
    static class PermissionManager {
        protected static final int REQUEST=0x22;
        protected static List<String> mPermissionList;
        protected static PermissionRequestCallBack mCallBack;
        private static Context mContext;
        /**
         *@Desc:初始化
        */
        public static void init(Context context, List<String> permissionList, PermissionRequestCallBack callBack) {
            mPermissionList = permissionList;
            mCallBack = callBack;
            mContext=context;
        }

        public static void request(){
            Intent intent=new Intent(mContext,PermissionGainActivity.class);
            mContext.startActivity(intent);
        }

        /**
         *@Desc:权限请求成狗
        */
        protected static void requestSuccessed(){
            mCallBack.onSuccessed();
        }
        /**
         *@Desc:权限请求失败
         */
        protected static void requestFailed(boolean b,List list){
            mCallBack.onFailed(b,list);
        }
    }
}


