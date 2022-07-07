package com.example.touristguideofthecityrakhiv;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class ContactsActivity extends AppCompatActivity implements View.OnClickListener {

    private CardView Btn_facebook;
    private CardView Btn_instagram;
    private CardView Btn_telegram;

    private Animation animClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.RAKHIV_NoActionBar);
        setContentView(R.layout.activity_contacts);

        Btn_facebook = (CardView) findViewById(R.id.Btn_facebook);
        Btn_instagram = (CardView) findViewById(R.id.Btn_instagram);
        Btn_telegram  = (CardView) findViewById(R.id.Btn_telegram);

        animClick = AnimationUtils.loadAnimation(this, R.anim.btn_click2);

        Btn_facebook.setOnClickListener(this);
        Btn_instagram.setOnClickListener(this);
        Btn_telegram.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        view.startAnimation(animClick);
        Uri uri = null;
        Intent likeIng = new Intent();
        switch(view.getId()){
            case R.id.Btn_facebook:
                uri = Uri.parse(getString(R.string.facebook_url));
                likeIng.setPackage("com.facebook.android");
                break;
            case R.id.Btn_instagram:
                uri = Uri.parse(getString(R.string.instagram_url));
                likeIng.setPackage("com.instagram.android");
                break;
            case R.id.Btn_telegram:
                uri = Uri.parse(getString(R.string.telegram_url));
                likeIng.setPackage("org.telegram.messenger");
                break;
        }
        try {
            likeIng.setAction(Intent.ACTION_VIEW);
            likeIng.setData(uri);
            startActivity(likeIng);
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,uri));
        }
    }
}