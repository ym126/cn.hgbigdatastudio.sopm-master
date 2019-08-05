package cn.hgbigdatastudio.somp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Color;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.google.android.material.appbar.MaterialToolbar;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.hgbigdatastudio.somp.R;
import cn.hgbigdatastudio.somp.fragment.MainFragment;
import cn.hgbigdatastudio.somp.service.SOMPService;

public class MainActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    MaterialToolbar mToolbar;
    @BindView(R.id.main_drawerLayout)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.main_frameLayout)
    FrameLayout mFrameLayout;
    private SOMPService.SOMPServiceBinder sompServiceBinder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setToolbar(mToolbar);
        init();
    }
    /**
     * Desc:初始化
     */
    private void init() {
        bindSOMPService();
        Log.d("TAG",getSharedPreferences("data",MODE_PRIVATE).getString("company","0"));

        getSupportFragmentManager().beginTransaction()
                .add(R.id.main_frameLayout, new MainFragment())
                .commit();

    }
    private ServiceConnection mConnection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            sompServiceBinder= (SOMPService.SOMPServiceBinder) iBinder;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };
    /**
     * Desc:绑定服务
     */
    private void bindSOMPService() {
        Intent serviceIntent =new Intent(this,SOMPService.class);
        bindService(serviceIntent,mConnection, Service.BIND_AUTO_CREATE);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
        }
        return true;
    }



}
