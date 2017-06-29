package com.kwave.android.serverconnection;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {
//
//    @BindView(R.id.recycler)
//    RecyclerView recycler;
//    @BindView(R.id.btnPost)
//    Button btnPost;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        ButterKnife.bind(this);
//    }
//
////    @OnClick(R.id.btnPost)
    @Click
    public void btnPost(){
        Intent intent = new Intent(this, WriteActivity.class);
        startActivity(intent);
    }
}
