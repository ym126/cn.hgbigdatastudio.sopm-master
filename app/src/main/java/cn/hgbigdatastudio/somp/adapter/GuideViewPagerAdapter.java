package cn.hgbigdatastudio.somp.adapter;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;

import cn.hgbigdatastudio.somp.R;
import cn.hgbigdatastudio.somp.activity.GuideActivity;
import cn.hgbigdatastudio.somp.activity.MainActivity;
import cn.hgbigdatastudio.somp.io.ConfigFile;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * 引导页的切换适配器
 */

public class GuideViewPagerAdapter extends PagerAdapter {
    private ArrayList<View> mViewArrayList;

    public GuideViewPagerAdapter(ArrayList<View> viewArrayList) {
        mViewArrayList = viewArrayList;
    }

    @Override
    public int getCount() {
        return mViewArrayList.size();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        container.addView(mViewArrayList.get(position));
        return mViewArrayList.get(position);
    }


    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView(mViewArrayList.get(position));
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

}
