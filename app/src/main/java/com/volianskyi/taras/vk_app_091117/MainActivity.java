package com.volianskyi.taras.vk_app_091117;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.vk.sdk.util.VKUtil;

import java.sql.Array;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] fingerprints = VKUtil.getCertificateFingerprint(this, this.getPackageName());
        System.out.println(Arrays.asList(fingerprints));
    }
}