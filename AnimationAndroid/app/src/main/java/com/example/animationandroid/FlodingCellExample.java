package com.example.animationandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.ramotion.foldingcell.FoldingCell;

public class FlodingCellExample extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floding_cell_example);
        FoldingCell flodingCell = findViewById(R.id.folding_cell);

        flodingCell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flodingCell.toggle(false);
            }
        });
    }
}