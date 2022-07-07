package com.example.touristguideofthecityrakhiv;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import com.example.touristguideofthecityrakhiv.databinding.ActivityScrollingBinding;
import com.example.touristguideofthecityrakhiv.databinding.ContentScrollingBinding;

public class ScrollingActivity extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener {

    private ActivityScrollingBinding binding;
    private ImageButton Btn_scrollTop;
    private ImageButton Btn_scrollBottom;
    private ContentScrollingBinding ContentScroll;

    Animation animClick;
    private int positionScroll = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityScrollingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Btn_scrollTop = binding.BtnScrollTop;
        Btn_scrollBottom = binding.BtnScrollBottom;

        FloatingActionButton fab = binding.fab;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(animClick);
                Intent intent = new Intent(ScrollingActivity.this, ContactsActivity.class);
                startActivity(intent);
            }
        });
        ContentScroll =  binding.scroll;

        animClick = AnimationUtils.loadAnimation(this, R.anim.btn_click1);
        Btn_scrollTop.setOnClickListener(this);
        Btn_scrollBottom.setOnClickListener(this);

        ContentScroll.getRoot().setOnTouchListener(this);
    }

    public void GoToCity(View view) {

    }

    @Override
    public void onClick(View view) {
        view.startAnimation(animClick);
        switch(view.getId()){
            case R.id.Btn_scrollBottom:
                switch (positionScroll){
                    case 0: positionScroll = 620; break;
                    case 620: positionScroll = 2200; break;
                    case 2200: positionScroll = 2980; break;
                    case 2980: positionScroll = 4270; break;
                    case 4270: positionScroll = 5635; break;
                    case 5635: positionScroll = 6550; break;
                    case 6550: positionScroll = 7030; break;
                    case 7030: positionScroll = 7870; break;
                    case 7870: positionScroll = 9320; break;
                    case 9320: positionScroll = 10670; break;
                    case 10670: positionScroll = 11680; break;
                    case 11680: positionScroll = 12770; break;
                    case 12770: positionScroll = 13780; break;
                    case 13780: positionScroll = 14700; break;
                }
                ContentScroll.getRoot().scrollTo(0, positionScroll);
                break;
            case R.id.Btn_scrollTop:
                switch (positionScroll){
                    case 620: positionScroll = 0; break;
                    case 2200: positionScroll = 620; break;
                    case 2980: positionScroll = 2200; break;
                    case 4270: positionScroll = 2980; break;
                    case 5635: positionScroll = 4270; break;
                    case 6550: positionScroll = 5635; break;
                    case 7030: positionScroll = 6550; break;
                    case 7870: positionScroll = 7030; break;
                    case 9320: positionScroll = 7870; break;
                    case 10670: positionScroll = 9320; break;
                    case 11680: positionScroll = 10670; break;
                    case 12770: positionScroll = 11680; break;
                    case 13780: positionScroll = 12770; break;
                    case 14700: positionScroll = 13780; break;
                }
                ContentScroll.getRoot().scrollTo(0, positionScroll);
                break;
        }
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if(motionEvent.getAction() == MotionEvent.ACTION_UP){
            int position = ContentScroll.getRoot().getScrollY();
            if(position >=0 && position <= 620){
                positionScroll = 0;
            }else if(position >=620 && position < 2200){
                positionScroll = 620;
            }else if(position >=2200 && position < 2980){
                positionScroll = 2200;
            }else if(position >=2980 && position < 4270){
                positionScroll = 2980;
            }else if(position >=4270 && position < 5635){
                positionScroll = 4270;
            }else if(position >=5635 && position < 6550){
                positionScroll = 5635;
            }else if(position >=6550 && position < 7030){
                positionScroll = 6550;
            }else if(position >=7030 && position < 7870){
                positionScroll = 7030;
            }else if(position >=7870 && position < 9320){
                positionScroll = 7870;
            }else if(position >=9320 && position < 10670){
                positionScroll = 9320;
            }else if(position >=10670 && position < 11680){
                positionScroll = 10670;
            }else if(position >=11680 && position < 12770){
                positionScroll = 11680;
            }else if(position >=12770 && position < 13780){
                positionScroll = 12770;
            }else if(position >=13780 && position < 14700){
                positionScroll = 13780;
            }
        }
        return false;
    }
}