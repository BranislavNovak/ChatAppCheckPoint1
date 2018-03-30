package com.example.branislavnovak.chatapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MessageActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bSend;
    private Button bLogout;
    private EditText enteredMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        bSend = findViewById(R.id.sendButton);
        bLogout = findViewById(R.id.logoutButton1);
        enteredMessage = findViewById(R.id.eMessage);

        bSend.setEnabled(false);
        bSend.setOnClickListener(this);
        bLogout.setOnClickListener(this);

        enteredMessage.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String s = enteredMessage.getText().toString();
                if (s.length() != 0){
                    bSend.setEnabled(true);
                }else{
                    bSend.setEnabled(false);
                }
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.sendButton:
                String messageSent = "Message is sent";
                Toast.makeText(this, messageSent,
                        Toast.LENGTH_LONG).show();

                enteredMessage.getText().clear();
                enteredMessage.setHint(R.string.sMessage);
                break;

            case R.id.logoutButton1:
                Intent i = new Intent(this, MainActivity.class);
                startActivity(i);
                break;


        }
    }
}
