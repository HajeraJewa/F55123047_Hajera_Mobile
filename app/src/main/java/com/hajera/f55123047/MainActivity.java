package com.hajera.f55123047;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtWidth, edtHeight, edtLenght;

    private Button btnCalculate;

    private TextView tvResult;

    private static final String STATE_RESULT = "state_result";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtWidth = findViewById(R.id.edt_width);
        edtHeight = findViewById(R.id.edt_height);
        edtLenght = findViewById(R.id.edt_lenght);
        btnCalculate = findViewById(R.id.btn_calculate);
        tvResult = findViewById(R.id.tv_result);
        btnCalculate.setOnClickListener(this);
        if (savedInstanceState != null) {
            String result = savedInstanceState.getString(STATE_RESULT);
            tvResult.setText(result);
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_RESULT, tvResult.getText().toString());
    }


    @Override
    public void onClick(View view) {
       if (view.getId() == R.id.btn_calculate) {
           String inputLenght = edtLenght.getText().toString().trim();
           String inputWidth = edtWidth.getText().toString().trim();
           String inputHeight = edtHeight.getText().toString().trim();
           boolean isEmptyFields = false;
           if (TextUtils.isEmpty(inputLenght)) {
              isEmptyFields = true;
              edtLenght.setError("Field ini tidak boleh kosong");
           }
           if (TextUtils.isEmpty(inputWidth)){
               isEmptyFields = true;
               edtWidth.setError("Field ini tidak boleh kosong");
           }
           if (TextUtils.isEmpty(inputHeight)){
               isEmptyFields = true;
               edtHeight.setError("Field ini tidak boleh kosong");
           }
           if (!isEmptyFields) {
               double volume = Double.parseDouble(inputLenght) *
                       Double.parseDouble(inputWidth) * Double.parseDouble(inputHeight);
               tvResult.setText(String.valueOf(volume));
           }
       }
    }
}