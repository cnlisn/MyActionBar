package com.lisn.myactionbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CustomFrameLayoutActivity extends AppCompatActivity {
    private static final String TAG = "CustomFrameLayoutActivi";
    private ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_frame_layout);

    }

    public void scanCode(View view) {
        Toast.makeText(this, "scanCode", Toast.LENGTH_SHORT).show();
    }

    public void invitationCode(View view) {
        Toast.makeText(this, "invitationCode", Toast.LENGTH_SHORT).show();
    }
}
