package com.qianwang.shoptest.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.qianwang.shoptest.R;
import com.qianwang.shoptest.view.MyFlowLayout;
import com.qianwang.shoptest.view.ToolbarX;

import java.util.ArrayList;
import java.util.List;

public class ShopSelectAcitivity extends BaseActivity implements MyFlowLayout.onItemSelectLinear {

    private ToolbarX mToolbarX;
    private MyFlowLayout flowlayout;
    private String[] carTypes = {"PS970", "F20/F30/F10/E84/E70/E71", "BST2", "A82/HT1/A6L", "A6L/A64",
            "F20/F30/F`0/E84"};
    private List<String> mList = new ArrayList<String>();
    private boolean isSelect = false;



    private void initView() {

        flowlayout = (MyFlowLayout) findViewById(R.id.flowlayout);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        mToolbarX = this.getToolbar();
        mToolbarX.setTitle("筛选");

        flowlayout.setItemSelectLinear(this);
        for (int i = 0; i < carTypes.length; i++) {
            View view = LayoutInflater.from(this).inflate(R.layout.flow_textview, null, false);
            TextView textView = (TextView) view.findViewById(R.id.tv_flow);
            textView.setText(carTypes[i]);
            ViewGroup.LayoutParams params1 = setViewMargin(textView);
            flowlayout.addView(textView, params1);
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_shop_select_acitivity;
    }

    public static ViewGroup.LayoutParams setViewMargin(View view) {
        if (view == null) {
            return null;
        }
        ViewGroup.LayoutParams params = view.getLayoutParams();
        ViewGroup.MarginLayoutParams marginParams = null;
        //获取view的margin设置参数
        if (params instanceof ViewGroup.MarginLayoutParams) {

            marginParams = (ViewGroup.MarginLayoutParams) params;
        } else {
            //不存在时创建一个新的参数
            marginParams = new ViewGroup.MarginLayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        }


        //设置margin
        marginParams.setMargins(20, 20, 20, 20);
        view.setLayoutParams(marginParams);
        return marginParams;
    }

    @Override
    public void onItemOnclick(View view, int position) {
        TextView textView = (TextView) view;

        if (mList.size() > 0) {
            for (int i=0;i<mList.size();i++) {
                if (textView.getText().toString().equals(mList.get(i))) {
                    isSelect = true;
                    textView.setTextColor(Color.BLACK);
                   textView.setBackgroundColor(Color.parseColor("#f6f6f6"));
                    mList.remove(i);
                } else {
                    isSelect = false;
                }
            }
            if (!isSelect) {
                mList.add(textView.getText().toString());
                textView.setTextColor(Color.parseColor("#81c5ea"));
                textView.setBackgroundResource(R.drawable.flow_textview);
            }
        } else if (mList.size() == 0) {
            mList.add(textView.getText().toString());
            textView.setTextColor(Color.parseColor("#81c5ea"));
            textView.setBackgroundResource(R.drawable.flow_textview);
        }
    }
}
