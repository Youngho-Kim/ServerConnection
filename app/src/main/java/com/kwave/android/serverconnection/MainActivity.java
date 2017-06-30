package com.kwave.android.serverconnection;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;
import com.kwave.android.serverconnection.domain.Data;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

//@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

//    @BindView(R.id.recycler)
    RecyclerView recycler;
//    @BindView(R.id.btnPost)
    Button btnPost;
        OkHttpClient client = new OkHttpClient();
    CustomAdapter adapter;

    // 리모트 관련 설정
    final String DOMAIN = "http://192.168.10.68:8080";
    final String SERVER_PATH = "/bbs";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        ButterKnife.bind(this);


        recycler = (RecyclerView) findViewById(R.id.recycler);
        adapter = new CustomAdapter();
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    protected void onResume() {
        super.onResume();
        load();
    }

    private void load() {
        run(DOMAIN+SERVER_PATH);
    }

    private void run(String url) {
        // 서브 쓰레드 에서 실행  // onDoingBa..리턴, onPostEx...파라미터
        new AsyncTask<String, Void, String>() {
            @Override
            protected String doInBackground(String... params) {
                String result = null;
                try {
                    result = getData(params[0]);
                } catch (IOException e) {
                    Log.e("MainActivity", e.getMessage());
                }
                return result;
            }

            @Override
            protected void onPostExecute(String result) {
                // 결과 값인 json 스트링을  객체로 변환
//                Log.e("Result", result);
                Gson gson = new Gson();
                Data data = gson.fromJson(result, Data.class);
                // ListView의 adapter에 세팅
                adapter.setData(data.bbsList);
                // ListView notify
                adapter.notifyDataSetChanged();
            }

        }.execute(url);
    }

    private String getData(String url) throws IOException{
        // 요청 정보를 담고 있는 객체
        Request request = new Request.Builder()
                .url(url)
                .build();
        // 응답 정보를 받을 객체
        Response response = null;
        // 서버로 요청
        response = client.newCall(request).execute();
        //응답 객체에서 실제 데이터만 추출
        ResponseBody resBody = response.body();
        //데이터를 String으로 변경
        return resBody.string();
    }




//    @OnClick(R.id.btnPost)
//    @Click
    // 화면 xml의 android:onClick="btnPost"
    public void Post(View view){
        Intent intent = new Intent(this, WriteActivity.class);
        startActivity(intent);
    }
}
