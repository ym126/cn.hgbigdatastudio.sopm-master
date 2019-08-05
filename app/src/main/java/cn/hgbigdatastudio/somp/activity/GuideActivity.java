package cn.hgbigdatastudio.somp.activity;

import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.LocalActivityManager;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

import cn.hgbigdatastudio.somp.R;
import cn.hgbigdatastudio.somp.adapter.GuideViewPagerAdapter;
import de.hdodenhof.circleimageview.CircleImageView;

public class GuideActivity extends BaseActivity {

    public static final int CHOOSE_PHOTO = 2;
    private static final String TAG = "GuideActivity";
    private boolean tag = false;

    private ViewPager mGuide_viewpager;
    private ArrayList<View> mViewArrayList;
    private GuideViewPagerAdapter mAdapter;
    private ImageView mImageView1;
    private ImageView mImageView2;
    private CircleImageView uploadLogo;
    private EditText companyName;
    private EditText projectName;
    private EditText locationName;
    private Button login;

    private String company;     //对应公司的名称
    private String project;     //对应项目的名称
    private String location;    //对应项目的地址


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        init();
    }

    private void init() {
        mGuide_viewpager = findViewById(R.id.guide_vp_parent);
        //为引导页ViewPager添加子页
        mImageView1 = new ImageView(this);
        mImageView1.setBackgroundResource(R.mipmap.guidepage1);
        mImageView2 = new ImageView(this);
        mImageView2.setBackgroundResource(R.mipmap.guidepage2);
        LayoutInflater li = getLayoutInflater();
        mViewArrayList = new ArrayList<>();
        mViewArrayList.add(mImageView1);
        mViewArrayList.add(mImageView2);

        mViewArrayList.add(li.inflate(R.layout.guide_entry, null, false));
        mAdapter = new GuideViewPagerAdapter(mViewArrayList);
        mGuide_viewpager.setAdapter(mAdapter);
    }

    //引导页第三页的按钮点击事件
    public void onGuideLoginOnClick(View v) {
        loadControlToEntry();  //加载控件
        if(isEdited()){
            storeData();
            //跳转至主界面
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }

    //引导页第三页的图标点击事件
    public void onGuideUploadOnClick(View view) {
        if (ContextCompat.checkSelfPermission(GuideActivity.this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.
                PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(GuideActivity.this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        } else {
            openAlbum();
        }
    }

    private void loadControlToEntry(){
        //由于初次加载无法将第三页的控件加载进来，暂时通过以下方式加载控件
        if(login==null){
            login = findViewById(R.id.guide_button_login);
            companyName = findViewById(R.id.guide_editText_companyName);
            projectName = findViewById(R.id.guide_editText_projectName);
            locationName = findViewById(R.id.guide_editText_locationName);
        }
    }

    /**
     * 判断是否编辑完毕
     * */
    private boolean isEdited() {

        if (!tag) {
            Toast.makeText(this, "尚未上传logo", Toast.LENGTH_SHORT).show();
            return false;
        }

        company = companyName.getText().toString().trim();
        if (TextUtils.isEmpty(company)) {
            Toast.makeText(this, "公司名称不能为空", Toast.LENGTH_SHORT).show();
            return false;
        }

        project = projectName.getText().toString().trim();
        if (TextUtils.isEmpty(project)) {
            Toast.makeText(this, "项目名称不能为空", Toast.LENGTH_SHORT).show();
            return false;
        }

        location = locationName.getText().toString().trim();
        if (TextUtils.isEmpty(location)) {
            Toast.makeText(this, "监测位置不能为空", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }



    /**
     * 将EditText读到的数据以SharedPreferences方式存储起来
     * 文件名为storeData
     * */

    private void  storeData(){
        //将用户的数据存入本地中


        SharedPreferences.Editor editor = getSharedPreferences("storeData", Context.MODE_PRIVATE).edit();
        editor.putBoolean("isRegister", true);
        editor.putString("company", company);
        editor.putString("project", project);
        editor.putString("location", location);
        editor.apply();

    }

    private void openAlbum() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, CHOOSE_PHOTO);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

            Uri uri = data.getData();
            ContentResolver cr = this.getContentResolver();
            try {
                Bitmap bitmap;
                if(uri !=null){
                       bitmap = BitmapFactory.decodeStream(cr.openInputStream(uri));
                }else {
                    //有的手机返回的uri是null，图片直接存放Bundle中
                    Bundle extras = data.getExtras();
                    bitmap = extras.getParcelable("data");
                }
                if(!tag)
                uploadLogo = findViewById(R.id.guide_circleImageView_uploadLogo);
                uploadLogo.setImageBitmap(bitmap);
                tag = true;  //标志图片设置成功
            }catch (FileNotFoundException e){
                Log.e(TAG, "onActivityResult: ",e );
            }catch (Exception e){
                Log.e(TAG, "onActivityResult: ",e );
            }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
