package cn.hgbigdatastudio.somp.activity;

import android.graphics.Color;
import android.os.Build;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.appbar.MaterialToolbar;

import cn.hgbigdatastudio.somp.R;

/**
 * @Author: Pulis
 * @CreateDate: 2019/7/11 20:16
 * @Description: Activity 基类
 */
public class BaseActivity extends AppCompatActivity {

    public void setToolbar(MaterialToolbar toolbar){
        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        //隐藏默认title
        actionBar.setDisplayShowTitleEnabled(false);
        //显示导航按键
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        getWindow().setStatusBarColor(Color.TRANSPARENT);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar,menu);
        return super.onCreateOptionsMenu(menu);
    }


}
