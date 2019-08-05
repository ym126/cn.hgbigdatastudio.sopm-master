package cn.hgbigdatastudio.somp.utils;

import java.util.List;

/**
 * @Author: Pulis
 * @CreateDate: 2019/7/12 17:04
 * @Description: 权限请求回调
 */
public interface PermissionRequestCallBack {
    /**
     *@Desc:全部权限请求成功
    */
    void onSuccessed();
    /**
     *@Desc:权限请求失败
     * b:用户勾选不再提示则为 true 反则 false
    */
    void onFailed(boolean b, List list);
}
