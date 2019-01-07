package com.qrcode;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText tv_qrCode_content;//用来生成二维码图片内包含的内容
    private Button tv_click;//按钮
    private ImageView iv_qr_code;//显示二维码的ImageView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
        inIt();
    }

    private void findView() {
        tv_qrCode_content = (EditText) findViewById(R.id.tv_qrCode_content);
        tv_click = (Button) findViewById(R.id.tv_click);
        iv_qr_code = (ImageView) findViewById(R.id.iv_qr_code);
    }

    private void inIt() {
        tv_click.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_click:
                String content = tv_qrCode_content.getText().toString().trim();
                if (TextUtils.isEmpty(content)) {
                    Toast.makeText(MainActivity.this, "请先输入需要生成二维码的内容", Toast.LENGTH_SHORT).show();
                    return;
                }
                Bitmap bitmap = ZXingUtils.createQRImage(content, iv_qr_code.getWidth(), iv_qr_code.getHeight());
                iv_qr_code.setImageBitmap(bitmap);
                break;
        }
    }
}