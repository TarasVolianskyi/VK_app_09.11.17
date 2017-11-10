package com.volianskyi.taras.vk_app_091117;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.vk.sdk.api.VKApi;
import com.vk.sdk.api.VKApiConst;
import com.vk.sdk.api.VKError;
import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.VKResponse;
import com.vk.sdk.api.model.VKApiPost;
import com.vk.sdk.api.model.VKApiVideo;
import com.vk.sdk.api.model.VKList;

import java.util.ArrayList;

public class ListOfVideoActivity extends AppCompatActivity {
    ListView lvList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_video);


        initView();
    }

    private void initView() {
        RecyclerView rvList = (RecyclerView) findViewById(R.id.rvListActivityListOfVideo);
        rvList.setLayoutManager(new LinearLayoutManager(this));
        rvList.setAdapter(new ListOfVideoAdapter());
        getPosts();
        lvList = (ListView) findViewById(R.id.lvListActivityListOfVideo);
/*
        // VKRequest request = VKApi.friends().get(VKParameters.from(VKApiConst.FIELDS, "first_name,last_name"));
        VKRequest request = VKApi.wall().get(VKParameters.from(VKApiConst.OWNER_ID, VKApiConst.MESSAGE));

        // VKRequest request = VKApi.wall().get(VKParameters.from(VKApiConst.FIELDS, "text"));
        request.executeWithListener(new VKRequest.VKRequestListener() {
            @Override
            public void onComplete(VKResponse response) {
                super.onComplete(response);
                Toast.makeText(ListOfVideoActivity.this, "Complited", Toast.LENGTH_SHORT).show();
                VKList list = (VKList) response.parsedModel;

                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(ListOfVideoActivity.this,
                        android.R.layout.simple_expandable_list_item_1, list);

                lvList.setAdapter(arrayAdapter);

            }

            @Override
            public void onError(VKError error) {
                super.onError(error);
                Toast.makeText(ListOfVideoActivity.this, "Error 2", Toast.LENGTH_SHORT).show();
            }
        });
        */
    }

    private void getPosts() {



        VKRequest request = VKApi.wall().get(VKParameters.from(VKApiConst.OWNER_ID, "-86529522", VKApiConst.FILTERS, "video" ,VKApiConst.EXTENDED, 1, VKApiConst.COUNT, 10, VKApiConst.FIELDS, "text"));
        request.executeWithListener(new VKRequest.VKRequestListener() {
            @Override
            public void onComplete(VKResponse response) {
                VKList<VKApiPost> posts = (VKList<VKApiPost>) response.parsedModel;
                ArrayList<String> postsList = new ArrayList<String>();
                for (int i = 0; i < 10; i++) {
                    VKApiPost post = posts.get(i);
                   // VKApiVideo video = posts.get(i);
                    String textpost = post.text;
                    postsList.add(textpost);
                    // System.out.println(textpost);
                }

                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(ListOfVideoActivity.this,
                        android.R.layout.simple_expandable_list_item_1, postsList);

                lvList.setAdapter(arrayAdapter);
            }

            @Override
            public void onError(VKError error) {
                super.onError(error);
                Toast.makeText(ListOfVideoActivity.this, "error - " + error.errorMessage, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
