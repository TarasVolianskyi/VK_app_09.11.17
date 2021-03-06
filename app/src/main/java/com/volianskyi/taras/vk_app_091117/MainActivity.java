package com.volianskyi.taras.vk_app_091117;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKCallback;
import com.vk.sdk.VKScope;
import com.vk.sdk.VKSdk;
import com.vk.sdk.api.VKError;
import com.vk.sdk.util.VKUtil;

import java.sql.Array;
import java.util.Arrays;

public class MainActivity extends Activity implements View.OnClickListener {

    private String[] scope = new String[]{VKScope.MESSAGES, VKScope.FRIENDS, VKScope.WALL};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //String[] fingerprints = VKUtil.getCertificateFingerprint(this, this.getPackageName());
        //System.out.println(Arrays.asList(fingerprints));
        initView();
    }

    private void initView() {
        Button authorization = (Button) findViewById(R.id.btnAuthorisationMainActivity);
        Button logOut = (Button) findViewById(R.id.btnLogOutMainActivity);
        Button list = (Button) findViewById(R.id.btnListMainActivity);
        authorization.setOnClickListener(this);
        logOut.setOnClickListener(this);
        list.setOnClickListener(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (!VKSdk.onActivityResult(requestCode, resultCode, data, new VKCallback<VKAccessToken>() {
            @Override
            public void onResult(VKAccessToken res) {
                Toast.makeText(getApplicationContext(), "Good", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onError(VKError error) {
                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
            }
        })) {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnAuthorisationMainActivity:
                VKSdk.login(this);
                break;
            case R.id.btnLogOutMainActivity:
                if(VKSdk.isLoggedIn())
                VKSdk.logout();
                break;
            case R.id.btnListMainActivity:
                startActivity(new Intent(MainActivity.this, ListOfVideoActivity.class));
                break;
        }

    }
}
