package com.example.branislavnovak.chatapplication;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;


public class ContactsActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bLogout;
    private ImageView dSendTo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        bLogout = findViewById(R.id.logoutButton);
        bLogout.setOnClickListener(this);

        //dSendTo = findViewById(R.id.nextButton);
        //dSendTo.setOnClickListener(this);

        ContactsAdapter adapter = new ContactsAdapter(this);

        // making object of Model Class with (String, String, Drawable) parameters
        //adapter.AddContact(new Model(("S"), ("Stevan Popov"), getResources().getDrawable(R.drawable.next_button1)));
        adapter.AddContact(new Model(("" + getResources().getString(R.string.sContact1).toString().charAt(0)),getResources().getString(R.string.sContact1).toString(),getResources().getDrawable(R.drawable.next_button3)));
        adapter.AddContact(new Model(("" + getResources().getString(R.string.sContact2).toString().charAt(0)),getResources().getString(R.string.sContact2).toString(),getResources().getDrawable(R.drawable.next_button3)));
        adapter.AddContact(new Model(("" + getResources().getString(R.string.sContact3).toString().charAt(0)),getResources().getString(R.string.sContact3).toString(),getResources().getDrawable(R.drawable.next_button3)));
        adapter.AddContact(new Model(("" + getResources().getString(R.string.sContact4).toString().charAt(0)),getResources().getString(R.string.sContact4).toString(),getResources().getDrawable(R.drawable.next_button3)));
        adapter.AddContact(new Model(("" + getResources().getString(R.string.sContact5).toString().charAt(0)),getResources().getString(R.string.sContact5).toString(),getResources().getDrawable(R.drawable.next_button3)));

        ListView list = findViewById(R.id.listOfContacts);
        list.setAdapter(adapter);
    }


    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.logoutButton:
                Intent i1 = new Intent(this, MainActivity.class);
                startActivity(i1);
                break;
            case R.id.nextButton:
                Intent i2 = new Intent(this, MessageActivity.class);
                startActivity(i2);
                break;
        }
    }

}
