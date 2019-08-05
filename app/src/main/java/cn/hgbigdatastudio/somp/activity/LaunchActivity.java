package cn.hgbigdatastudio.somp.activity;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import java.util.List;

import cn.hgbigdatastudio.somp.R;
import cn.hgbigdatastudio.somp.io.ConfigFile;
import cn.hgbigdatastudio.somp.utils.PermissionGainHelper;



public class LaunchActivity extends BaseActivity {
    /**
     *@Desc:Handler What 标识
    */
    private static final int WHAT_OK=0x10;
    /**
     *@Desc:Handler 延迟消息毫秒数
    */
    private static final int DELAY_MILLIS=3000;
    /**
     *@Desc:需要请求权限的列表
    */
    private static final String[] PERMISSIONS={Manifest.permission.WRITE_EXTERNAL_STORAGE};
    /**
     *@Desc:权限请求帮助类
    */
    private PermissionGainHelper permissionGainHelper;
    /**
     *@Desc:权限请求回调
    */
    private PermissionRequestCallBack mCallBack;
    /**
     *@Desc:Handler
    */
    private LauncherLoadingHandler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        init();
        getPermission();

    }
    /**
     *@des:    初始化
    */
    private void init(){
        mCallBack=new PermissionRequestCallBack();
        handler=new LauncherLoadingHandler();
        handler.sendEmptyMessageDelayed(WHAT_OK,DELAY_MILLIS);
    }
    /**
     *@Desc:获取权限
    */
    private void getPermission(){
        permissionGainHelper=PermissionGainHelper.newInstance(this)
                .setPermission(PERMISSIONS)
                .setCallBack(mCallBack);
        permissionGainHelper.request();
    }
    /**
     *@Desc:重写Handler的消息方法
    */
    class LauncherLoadingHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what==WHAT_OK){
                finish();
                swicthActivity();
            }
        }
    }
    /**
     * Desc:选择去哪个Activity
     */
    private void swicthActivity() {
        boolean flag = getSharedPreferences("storeData",MODE_PRIVATE).getBoolean("isRegister",false);
        ConfigFile.with(this);
        //存在为真
        //if (ConfigFile.configFileExists( )){
        if(flag){
            //去主页
            startActivity(new Intent(this,MainActivity.class));
        }else {
            //去引导页
            startActivity(new Intent(this,GuideActivity.class));
        }
    }

    /**
     *@Desc:权限请求回调函数
    */
    class PermissionRequestCallBack implements cn.hgbigdatastudio.somp.utils.PermissionRequestCallBack{
        private List<String>list;
        private PermissionDialogNegativeButtonOnClickListener negativeButtonOnClickListener;
        private PermissionDialogPositiveButtonOnClickListener positiveButtonOnClickListener;
        /**
         *@Desc:权限请求成功
        */
        @Override
        public void onSuccessed() {
            
        }
        /**
         *@Desc:权限请求失败
        */
        @Override
        public void onFailed(boolean b, List list) {
            this.list=list;
            negativeButtonOnClickListener=new PermissionDialogNegativeButtonOnClickListener();
            positiveButtonOnClickListener=new PermissionDialogPositiveButtonOnClickListener();
            positiveButtonOnClickListener.setB(b);
            showDialog();
        }
        /**
         *@Desc:跳转APP设置页面
        */
        private void toSettingPage(){
            Intent localIntent = new Intent();
            localIntent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            localIntent.setData(Uri.fromParts("package", LaunchActivity.this.getPackageName(), null));
            LaunchActivity.this.startActivity(localIntent);
        }
        /**
         *@Desc:再次请求权限
        */
        private void reGetPermission() {
            if (list!=null) {
                String[] permissions =list.toArray(new String[]{});
                permissionGainHelper.setPermission(permissions).request();
            }

        }
        /**
         *@Desc:显示对话框
        */
        private void showDialog(){
           new AlertDialog.Builder(LaunchActivity.this)
                    .setMessage("该应用需要获取相关权限，才能正常运行")
                    .setPositiveButton("确定",positiveButtonOnClickListener)
                    .setNegativeButton("取消",negativeButtonOnClickListener)
                    .show();
        }
        /**
         *@Desc:对话框的按钮监听
        */
        class PermissionDialogPositiveButtonOnClickListener implements DialogInterface.OnClickListener {
            private boolean b;

            public void setB(boolean b) {
                this.b = b;
            }

            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (b) {
                    toSettingPage();
                } else {
                    reGetPermission();
                }
            }
        }
        class PermissionDialogNegativeButtonOnClickListener implements DialogInterface.OnClickListener {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        }
    }

}
