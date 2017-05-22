package com.qianwang.shoptest.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.qianwang.shoptest.R;
import com.qianwang.shoptest.entity.Goods;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luo on 2017/5/20.
 */

public class GoodsAdapter extends RecyclerView.Adapter<GoodsAdapter.ViewHolder> {


    private Context mContext;
    private List<Goods> mList = new ArrayList<Goods>();

    public GoodsAdapter(Context context, List<Goods> list) {
        this.mContext = context;
        this.mList = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.item_rv_searchshop,null,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tv_gName.setText(mList.get(position).getGoods_name());
        holder.tv_gCode.setText(mList.get(position).getGoods_code());
        holder.tv_gType.setText(mList.get(position).getGoods_type());
        holder.tv_gBrand.setText(mList.get(position).getBrand());
        holder.tv_gsUnit.setText(mList.get(position).getGoods_unit());
        holder.tv_gPrice.setText(String.valueOf(mList.get(position).getGoods_price()));
        holder.tv_gTotal.setText(mList.get(position).getGoods_stock() + "");
        holder.tv_gUpdateTime.setText(mList.get(position).getGoods_updateTime());
        holder.tv_gClick.setText(String.valueOf(mList.get(position).getClick_rate()));

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_gName, tv_gCode, tv_gBrand, tv_gType, tv_gsUnit,
                tv_gPrice, tv_gTotal, tv_gClick, tv_gUpdateTime;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_gName = (TextView) itemView.findViewById(R.id.tv_goodsName);
            tv_gCode = (TextView) itemView.findViewById(R.id.tv_goodscode);
            tv_gBrand = (TextView) itemView.findViewById(R.id.tv_goodsBrand);
            tv_gType = (TextView) itemView.findViewById(R.id.tv_goodsType);
            tv_gsUnit = (TextView) itemView.findViewById(R.id.tv_goodsUnit);
            tv_gPrice = (TextView) itemView.findViewById(R.id.tv_goodsPrice);
            tv_gTotal = (TextView) itemView.findViewById(R.id.tv_goodstotal);
            tv_gClick = (TextView) itemView.findViewById(R.id.tv_goodsClick);
            tv_gUpdateTime = (TextView) itemView.findViewById(R.id.tv_goodsUpdateTime);
        }
    }
}
