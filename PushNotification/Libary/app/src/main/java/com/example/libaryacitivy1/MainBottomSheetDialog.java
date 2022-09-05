package com.example.libaryacitivy1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class MainBottomSheetDialog extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bottom_sheet_dialog);
        Button button = findViewById(R.id.btn_Bottom_Sheet_Dialog);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickButtomSheetDialog();
            }


        });

    }
    private void clickButtomSheetDialog() {
        View viewDialog= getLayoutInflater().inflate(R.layout.bottom_sheet_dialog,null);
       final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(viewDialog);
        bottomSheetDialog.show();
        bottomSheetDialog.setCancelable(false);
        Button buttonCancel=viewDialog.findViewById(R.id.cancel_button);
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetDialog.dismiss();
            }
        });

        Button buttonPayment=viewDialog.findViewById(R.id.payment);
        buttonPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainBottomSheetDialog.this,"Click Payment",Toast.LENGTH_SHORT).show();
            }
        });
        //Xau het content man hinh
//        BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.from((View)viewDialog.getParent());
//        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
    }
}