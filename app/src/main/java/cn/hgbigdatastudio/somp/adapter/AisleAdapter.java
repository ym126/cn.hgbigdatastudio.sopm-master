package cn.hgbigdatastudio.somp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cn.hgbigdatastudio.somp.R;
import cn.hgbigdatastudio.somp.bean.AisleItemBean;

public class AisleAdapter extends RecyclerView.Adapter<AisleAdapter.ViewHolder>{
    private List<AisleItemBean> AisleItems;


    static class ViewHolder extends RecyclerView.ViewHolder{
        View AisleView;
        TextView right_text;
        TextView warning_text1;
        TextView warning_text2;
        TextView unit_text;
        TextView item_name;
        public ViewHolder(View view){
            super(view);
            AisleView = view;
            right_text = view.findViewById(R.id.right_text);
            warning_text1 = view.findViewById(R.id.warning_text1);
            warning_text2 = view.findViewById(R.id.warning_text2);
            unit_text = view.findViewById(R.id.unit_text);
            item_name = view.findViewById(R.id.item_name);
        }
    }
    public AisleAdapter(List<AisleItemBean> AisleItems){
        this.AisleItems = AisleItems;
    }


    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.aisle_item,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        return holder;
    }


    public void onBindViewHolder(ViewHolder holder, int position) {
        AisleItemBean aisleItemBean = AisleItems.get(position);
        holder.item_name.setText(aisleItemBean.getName());
        holder.right_text.setText("【"+aisleItemBean.getChannelAddress()+"】");
        holder.unit_text.setText(aisleItemBean.getUnit());
        holder.warning_text1.setText(aisleItemBean.getAlarmValue1()+"");
        holder.warning_text2.setText(aisleItemBean.getAlarmValue2()+"");
    }


    @Override
    public int getItemCount() {
        return AisleItems.size();
    }


}


