package com.kwave.android.serverconnection;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;


//@EActivity(R.layout.activity_write)
public class WriteActivity extends AppCompatActivity {

//    @BindView(R.id.editTitle)
    EditText editTitle;
//    @BindView(R.id.editContent)
    EditText editContent;
//    @BindView(R.id.editAuthor)
    EditText editAuthor;
//    @BindView(R.id.btnPost)
//    Button btnPost;
//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);
//        //버터 나이프 annotation 활성화
//        ButterKnife.bind(this);
    }
//
//    @OnClick(R.id.btnPost)
    public void onClick(){
        Toast.makeText(this, "불렀나요?", Toast.LENGTH_SHORT).show();
    }
}
