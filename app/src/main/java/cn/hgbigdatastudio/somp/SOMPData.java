package cn.hgbigdatastudio.somp;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.logging.Handler;

import cn.hgbigdatastudio.somp.bean.BaseBean;

/**
 * Desc:作为全局的SOMP数据提供类
 */
public class SOMPData {
    private static Map<String,BaseBean> mSompMap=new LinkedHashMap<>();
    private static List<BaseBean> mSompList=new ArrayList<>();
    /**
     * Desc:请求线程
     */
    private static Thread mRequestThread=new Thread(){
        @Override
        public void run() {
            super.run();
            requestFromHttpData();
        }
    };
    /**
     * Desc:初始化数据
     */
    public static void initData(){
        mRequestThread.run();
    }
    /**
     * Desc:get当前的数据
     */
    private static List<BaseBean> getSOMPData(){
        return mSompList;
    }
    /**
     * Desc:http请求数据
     */
    private static void requestFromHttpData(){

    }
    /**
     * Desc:本地请求数据
     */
    private static void requestFromLocal(){

    }

}
