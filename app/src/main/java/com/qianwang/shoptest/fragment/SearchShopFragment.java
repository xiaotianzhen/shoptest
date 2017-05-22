package com.qianwang.shoptest.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListView;


import com.qianwang.shoptest.R;
import com.qianwang.shoptest.adapter.GoodsAdapter;
import com.qianwang.shoptest.entity.Goods;
import com.qianwang.shoptest.view.DropDownMenu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchShopFragment extends BaseFragment {

    private DropDownMenu dropDownMenu;
    private String[] headers = {"单价", "库存", "更新时间"};
    private List<View> popupViews = new ArrayList<View>();
    private List<Goods> mList = new ArrayList<Goods>();
    private Goods mGoods;
    private RecyclerView recyclerView;


    private void initView(View view) {
        dropDownMenu = (DropDownMenu) view.findViewById(R.id.dropDownMenu);
        recyclerView= (RecyclerView) view.findViewById(R.id.recyclerview);
    }

    private void initData() {

        for (int i = 0; i < 20; i++) {

            mGoods.setGoods_name("波箱油底壳波箱油底壳");
            mGoods.setGoods_code("1086120809");
            mGoods.setGoods_type("A82/HT1/A6L");
            mGoods.setBrand("原厂TEXTAR");
            mGoods.setGoods_unit("SET");
            mGoods.setGoods_price(980);
            mGoods.setGoods_updateTime("2017-04-26 20:08");
            mGoods.setGoods_stock(900);//存货
            mGoods.setClick_rate(300);
            mList.add(mGoods);
        }
    }

    public SearchShopFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view=inflater.inflate(R.layout.fragment_search_shop, container, false);

        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        mGoods = new Goods();
        initData();
        ListView listView1 = new ListView(getActivity());
        ListView listView2 = new ListView(getActivity());
        ListView listView3 = new ListView(getActivity());
        popupViews.clear();
        popupViews.add(listView1);
        popupViews.add(listView2);
        popupViews.add(listView3);
        //这里添加 内容显示区域,可以是任何布局
        ((FrameLayout)recyclerView.getParent()).removeView(recyclerView);
        dropDownMenu.setDropDownMenu(Arrays.asList(headers), popupViews, recyclerView);
        recyclerView.setAdapter(new GoodsAdapter(getActivity(), mList));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

}
