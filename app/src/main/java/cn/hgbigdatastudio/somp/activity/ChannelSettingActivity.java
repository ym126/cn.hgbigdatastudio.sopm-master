package cn.hgbigdatastudio.somp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import cn.hgbigdatastudio.somp.R;
import cn.hgbigdatastudio.somp.adapter.AisleAdapter;
import cn.hgbigdatastudio.somp.bean.AisleItemBean;

public class ChannelSettingActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView recyclerView;
    private List<AisleItemBean> AisleList = new ArrayList<>();
    private Button CreateChannel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_channel_setting);

        initAisles();
        initView();//初始化控件
    }
    public  void initView(){
        recyclerView = findViewById(R.id.Aisle);
        CreateChannel = findViewById(R.id.CreateChannel);
        CreateChannel.setOnClickListener(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.HORIZONTAL));
        AisleAdapter adapter = new AisleAdapter(AisleList);
        recyclerView.setAdapter(adapter);
    }

    private void initAisles() {
        for(int i = 0;i<2;i++){
            AisleItemBean one = new AisleItemBean("Al0","喷淋罐液位","米（M)",null,null,20,250);
            AisleList.add(one);
            AisleItemBean two = new AisleItemBean("Al1","二燃室温度","摄氏度（℃)",null,null,50,250);
            AisleList.add(two);
        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.CreateChannel:
                Intent intent = new Intent(this,CreateChannelActivity.class);
                startActivity(intent);
                break;
        }
    }
}
