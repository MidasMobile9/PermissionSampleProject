package com.tistory.deque.permissionsampleproject;

import android.Manifest;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private String[] permissions = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA
    }; // 권한 요청을 받을 권한 배열

    @BindView(R.id.permissionBtn)
    Button permissionBtn;
    @BindView(R.id.mainLayout)
    LinearLayout mainLayout;

    Permission mPermission;
    //사용법은 Permission.java를 확인하거나 Ctrl+Q를 눌리시오

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        mPermission = new Permission(this, permissions);
        //생성자의 인자로 권한 배열을 넣어줌

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        mPermission.requestPermissionsResult(requestCode, permissions, grantResults);
    }

    @OnClick(R.id.permissionBtn)
    public void onClickPermssionBtn() {
        mPermission.setSnackbar(mainLayout);
        //인자는 스낵바가 보여질 View
        mPermission.checkPermissions();
    }
}
