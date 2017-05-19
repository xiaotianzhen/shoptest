package com.qianwang.shoptest.activity;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.qianwang.shoptest.R;
import com.qianwang.shoptest.view.Code;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView im_showcode;
    private String realCode;
    private EditText et_name,et_password,et_code;
    private TextView tv_about1,tv_about2;
    private Button btn_login;


    private void initView() {
        im_showcode = (ImageView) findViewById(R.id.im_showcode);
        et_name= (EditText) findViewById(R.id.et_name);
        et_password= (EditText) findViewById(R.id.et_password);
        et_code= (EditText) findViewById(R.id.et_code);
        btn_login= (Button) findViewById(R.id.btn_login);
        tv_about1= (TextView) findViewById(R.id.about1);
        tv_about2= (TextView) findViewById(R.id.about2);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        setTextType();
        im_showcode.setImageBitmap(Code.getInstance().createBitmap());
        realCode = Code.getInstance().getCode().toLowerCase();
        im_showcode.setOnClickListener(this);


    }

    /**
     * 设置字体为微软雅黑
     */
    private void setTextType() {
        Typeface type=Typeface.createFromAsset(getAssets(),"fonts/msyh.ttf");
        et_name.setTypeface(type);
        et_password.setTypeface(type);
        et_code.setTypeface(type);
        btn_login.setTypeface(type);
        tv_about1.setTypeface(type);
        tv_about2.setTypeface(type);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.im_showcode:
                im_showcode.setImageBitmap(Code.getInstance().createBitmap());
                break;

        }
    }
}
