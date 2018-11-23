package com.awake.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
private TextView txtviewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtviewResult = (TextView) findViewById(R.id.textView);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
        Call<List<Post>> call = jsonPlaceHolderApi.getPosts();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if(!response.isSuccessful()){
                    txtviewResult.setText("Code: " + response.code());
                    return;
                }
                List<Post>posts =response.body();
                for(Post post: posts){
                    String content = "";
                    content += "id: " + post.getId() +"\n";
                    content += "title: " + post.getTitle() +"\n";
                    content += "user id: " + post.getUserId() +"\n";
                    content += "body: " + post.getText()+ "\n\n";
                    txtviewResult.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Post>>call, Throwable t) {
                txtviewResult.setText(t.getMessage());
            }
        });

    }
}
