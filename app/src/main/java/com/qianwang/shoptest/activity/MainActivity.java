package com.qianwang.shoptest.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioGroup;
import android.widget.TabHost;
import android.widget.TextView;

import com.qianwang.shoptest.R;
import com.qianwang.shoptest.fragment.InvoicingCountFragment;
import com.qianwang.shoptest.fragment.SearchShopFragment;
import com.qianwang.shoptest.fragment.SellerInfoFragment;
import com.qianwang.shoptest.fragment.SellerSeacherFragment;
import com.qianwang.shoptest.view.ToolbarX;


public class MainActivity extends BaseActivity {
    private RadioGroup rg_tab;
    private FragmentTabHost mTabHost;
    private FrameLayout mFrameLayout;
    private Class[] mClasses = {SearchShopFragment.class, SellerSeacherFragment.class,
            InvoicingCountFragment.class, SellerInfoFragment.class
    };
    private ToolbarX mToolbarX;


    private void initView() {

        mTabHost = (FragmentTabHost) findViewById(R.id.tabhost);
        mFrameLayout = (FrameLayout) findViewById(R.id.fl_container);
        rg_tab = (RadioGroup) findViewById(R.id.rg_tab);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        mTabHost.setup(getApplicationContext(), getSupportFragmentManager(), R.id.fl_container);
        for (int i = 0; i < mClasses.length; i++) {
            TabHost.TabSpec spec = mTabHost.newTabSpec(String.valueOf(i)).setIndicator(String.valueOf(i));  //tab设置
            mTabHost.addTab(spec, mClasses[i], null);  //将tab设置到tabhost
        }
        mTabHost.setCurrentTab(0);
        setShopSeachMenu();
        rg_tab.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                switch (id) {
                    case R.id.tab_shopseacher:
                        mTabHost.setCurrentTab(0);
                        setShopSeachMenu();
                        break;
                    case R.id.tab_sellersearch:
                        mTabHost.setCurrentTab(1);
                        break;
                    case R.id.tab_invoicingcount:
                        mTabHost.setCurrentTab(2);
                        break;
                    case R.id.tab_sellerInfo:
                        mTabHost.setCurrentTab(3);
                        break;
                }
                supportInvalidateOptionsMenu();
            }
        });


    }

    /**
     * 设置商品搜索的菜单
     */

    public void setShopSeachMenu() {

        mToolbarX = getToolbar();
        View view1 = LayoutInflater.from(getApplicationContext()).inflate(R.layout.menu_searchshop, null, false);
        TextView menuSelect = (TextView) view1.findViewById(R.id.tv_menuselect);
        menuSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ShopSelectAcitivity.class);
                startActivity(intent);
                finish();
            }
        });
        mToolbarX.setCustomView(view1);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }
}
