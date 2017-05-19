package com.qianwang.shoptest.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.qianwang.shoptest.R;
import com.qianwang.shoptest.view.DropDownMenu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private DropDownMenu dropDownMenu;
    private String[] headers={"单价","库存","更新时间"};
    private List<View> popupViews=new ArrayList<View>();

    private void initView(){
        dropDownMenu= (DropDownMenu) findViewById(R.id.dropDownMenu);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        ListView listView1=new ListView(this);
        ListView listView2=new ListView(this);
        ListView listView3=new ListView(this);
        popupViews.add(listView1);
        popupViews.add(listView2);
        popupViews.add(listView3);


        //这里添加 内容显示区域,可以是任何布局
        TextView contentView = new TextView(this);
        contentView.setText("这里是内容区域");
        contentView.setTextSize(20);
        contentView.setGravity(Gravity.CENTER);
        dropDownMenu.setDropDownMenu(Arrays.asList(headers),popupViews,contentView);
    }
}
