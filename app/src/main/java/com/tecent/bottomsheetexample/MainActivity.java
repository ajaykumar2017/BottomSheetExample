package com.tecent.bottomsheetexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements ExampleBottomSheetDialog.BottomSheetListener {
    private TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView=findViewById(R.id.text_view_button_clicked);
        Button butttonOpenBottomSheet = findViewById(R.id.button_open_bottom_sheet);
        butttonOpenBottomSheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ExampleBottomSheetDialog bottomSheetDialog = new ExampleBottomSheetDialog();
                bottomSheetDialog.show(getSupportFragmentManager(), "exampleBottomSheet");

            }
        });
    }

    @Override
    public void onButtonClicked(String text) {
        mTextView.setText(text);
    }
}
