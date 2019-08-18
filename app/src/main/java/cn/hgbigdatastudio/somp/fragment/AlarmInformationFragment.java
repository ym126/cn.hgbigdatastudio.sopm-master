package cn.hgbigdatastudio.somp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import cn.hgbigdatastudio.somp.R;
import cn.hgbigdatastudio.somp.adapter.AlarmInformationAdapter;
import cn.hgbigdatastudio.somp.bean.AlarmItemBean;

public class AlarmInformationFragment extends Fragment {
    private RecyclerView recyclerView;
    private List<AlarmItemBean> alarmItemBeanList = new ArrayList<>();

    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View view =  inflater.inflate( R.layout.fragment_alarminformation,container,false);
        initList();
        recyclerView = view.findViewById(R.id.Alarm_List);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.HORIZONTAL));
        AlarmInformationAdapter adapter = new AlarmInformationAdapter(alarmItemBeanList);
        recyclerView.setAdapter(adapter);
        return view;
    }
    public void initList(){
        for (int i = 0; i< 2 ; i++){
            AlarmItemBean one = new AlarmItemBean("2019/8/18","17:20","5000","我觉得不好");
            alarmItemBeanList.add(one);
            AlarmItemBean two = new AlarmItemBean("2019/9/18","14:20","8500","你看怎么好呢");
            alarmItemBeanList.add(two);
        }
    }

}
