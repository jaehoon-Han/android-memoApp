package com.han.apptest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.han.apptest.data.DatabaseHandler;
import com.han.apptest.model.Memo;


public class AddActivity extends AppCompatActivity {

    EditText editTitle;
    EditText editContent;
    Button btnSave;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_memo);

        editTitle = findViewById(R.id.editTItle);
        editContent = findViewById(R.id.editContent);
        btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 1. 유저가 입력한 제목과 내용 가져오기
                String title = editTitle.getText().toString().trim();
                String content = editContent.getText().toString().trim();

                if(title.isEmpty() ){
                    Toast.makeText(AddActivity.this, " 제목과 내용은 필수입니다", Toast.LENGTH_LONG).show();
                    return;
                }


                DatabaseHandler db = new DatabaseHandler(AddActivity.this);
                Memo memo = new Memo(title, content);
                db. addMemo(memo);

                finish();


            }
        });


    }
}