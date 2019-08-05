package cn.hgbigdatastudio.somp.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class SOMPService extends Service {
    private SOMPServiceBinder binder;
    private OnDataUpDataCallBack mCallBack;
    @Override
    public IBinder onBind(Intent intent) {
        binder=new SOMPServiceBinder();
        return binder;
    }
    /**
     * Desc:直接获取数据
     */
    private void getSOMPData(){

    }

    public class SOMPServiceBinder extends Binder {
        public void setCallBack(OnDataUpDataCallBack callBack){
            mCallBack=callBack;
        }
    }
    
    /**
     * Desc:回调接口
     */
    interface OnDataUpDataCallBack{
        void updata();
    }
}
