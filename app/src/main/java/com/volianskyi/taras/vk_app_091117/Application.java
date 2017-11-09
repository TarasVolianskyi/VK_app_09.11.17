package com.volianskyi.taras.vk_app_091117;

import com.vk.sdk.VKSdk;

/**
 * Created by tarasvolianskyi on 09.11.17.
 */

public class Application extends android.app.Application{

    @Override
    public void onCreate() {
        super.onCreate();

        VKSdk.initialize(this);
    }
}
