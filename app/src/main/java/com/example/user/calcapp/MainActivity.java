package com.example.user.calcapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText mEditText1;
    EditText mEditText2;
    double value1 = 0.0;
    double value2 = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText1 = (EditText)findViewById(R.id.edit1);
        mEditText2 = (EditText)findViewById(R.id.edit2);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);
        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);
        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        try{
            value1 = Double.parseDouble(mEditText1.getText().toString());
            value2 = Double.parseDouble(mEditText2.getText().toString());

            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra("value1", value1);
            intent.putExtra("value2", value2);

            if (v.getId() == R.id.button1) {
                intent.putExtra("flag", 0);
                Log.d("UI-PARTS", value1 + "＋" + value2 + "の計算を開始");
            } else if (v.getId() == R.id.button2) {
                intent.putExtra("flag", 1);
                Log.d("UI-PARTS", value1 + "−" + value2 + "の計算を開始");
            } else if (v.getId() == R.id.button3) {
                intent.putExtra("flag", 2);
                Log.d("UI-PARTS", value1 + "×" + value2 + "の計算を開始");
            } else if (v.getId() == R.id.button4) {
                if(value2 != 0) {
                    intent.putExtra("flag", 3);
                    Log.d("UI-PARTS", value1 + "÷" + value2 + "の計算を開始");
                }
                else{
                    showAlertDialog("0で割ることはできません");
                    return;
                }
            }
            startActivity(intent);
        }
        catch (NumberFormatException e){
            showAlertDialog("正しい値を入力してください");
        }
    }

    private void showAlertDialog(String message) {
        // AlertDialog.Builderクラスを使ってAlertDialogの準備をする
        Log.d("UI-PARTS", "エラー：" + message);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("エラー");
        alertDialogBuilder.setMessage(message);

        // 肯定ボタンに表示される文字列、押したときのリスナーを設定する
        alertDialogBuilder.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d("UI-PARTS", "OK");
                    }
                });

        // AlertDialogを作成して表示する
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
