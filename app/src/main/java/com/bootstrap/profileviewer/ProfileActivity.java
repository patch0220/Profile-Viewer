package com.bootstrap.profileviewer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ProfileActivity extends AppCompatActivity {

    TextView mName, mEmail, mGender, mBirthday;
    ImageView mProfilePhoto;
    String name, email, gender, birthday, id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        initViews();
        getDetails();
        setDetails();
    }

    private void setDetails() {
        mName.setText(name);
        mEmail.setText(email);
        mGender.setText(gender);
        mBirthday.setText(birthday);
        String imgUrl = "https://graph.facebook.com/" + id + "/picture?type=large";
        Picasso.with(this).load(imgUrl).into(mProfilePhoto);
    }

    private void getDetails() {
        name = getIntent().getStringExtra("NAME");
        email = getIntent().getStringExtra("EMAIL");
        gender = getIntent().getStringExtra("GENDER");
        birthday = getIntent().getStringExtra("BIRTHDAY");
        id = getIntent().getStringExtra("ID");
    }

    private void initViews() {
        mName = (TextView) findViewById(R.id.name);
        mEmail = (TextView) findViewById(R.id.email);
        mGender = (TextView) findViewById(R.id.gender);
        mBirthday = (TextView) findViewById(R.id.birthday);
        mProfilePhoto = (ImageView) findViewById(R.id.image);
    }
}
