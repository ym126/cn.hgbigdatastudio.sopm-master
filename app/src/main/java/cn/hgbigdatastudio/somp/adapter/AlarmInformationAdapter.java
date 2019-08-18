package cn.hgbigdatastudio.somp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cn.hgbigdatastudio.somp.R;
import cn.hgbigdatastudio.somp.bean.AlarmItemBean;

public class AlarmInformationAdapter extends RecyclerView.Adapter<AlarmInformationAdapter.ViewHolder> {
    private List<AlarmItemBean> alarmItemBeanList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        View AisleView;
        TextView date_text;
        TextView time_text;
        TextView AlarmValue_text;
        TextView AlarmContent_text;
        public ViewHolder(View view){
            super(view);
            AisleView = view;
            date_text = view.findViewById(R.id.date_text);
            time_text = view.findViewById(R.id.time_text);
            AlarmValue_text = view.findViewById(R.id.AlarmValue_text);
            AlarmContent_text = view.findViewById(R.id.AlarmContent_text);
        }
    }

    public AlarmInformationAdapter(List<AlarmItemBean> alarmItemBeanList) {
        this.alarmItemBeanList = alarmItemBeanList;
    }

    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.alarminformation_item,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AlarmItemBean alarmItemBean = alarmItemBeanList.get(position);
        holder.date_text.setText(alarmItemBean.getDate());
        holder.time_text.setText(alarmItemBean.getTime());
        holder.AlarmValue_text.setText(alarmItemBean.getAlarmValue());
        holder.AlarmContent_text.setText(alarmItemBean.getAlarmContent());
    }


    @Override
    public int getItemCount() {
        return alarmItemBeanList.size();
    }
}
