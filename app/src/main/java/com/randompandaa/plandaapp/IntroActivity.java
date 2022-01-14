package com.randompandaa.plandaapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;

public class IntroActivity extends AppCompatActivity {

    LottieAnimationView lottieLeft, lottieRight;
    ImageView splashImg, logo, logo_animate;

    private static final int NUM_PAGES = 3;
    private ViewPager viewPager;
    private ScreenSlidePagerAdapter pagerAdapter;

    Animation anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        splashImg = findViewById(R.id.splash_bg);
        logo = findViewById(R.id.app_name);
        logo_animate = findViewById(R.id.logo_animate);

        lottieRight = findViewById(R.id.rightlayer);
        lottieLeft = findViewById(R.id.leftlayer);

//        anim = AnimationUtils.loadAnimation(this, R.anim.one_anim);
//        viewPager.startAnimation(anim);

        //Animation settings
        splashImg.animate().translationY(-3000).setDuration(3000).setStartDelay(4000);
        logo.animate().translationY(2000).setDuration(3000).setStartDelay(4000);
        logo_animate.animate().translationY(2000).setDuration(3000).setStartDelay(4000);

        lottieRight.animate().translationY(50).translationX(10).setDuration(1).setStartDelay(1).translationY(1600).translationX(1600).setDuration(3000).setStartDelay(4000);
        lottieLeft.animate().translationY(-10).translationX(-10).setDuration(1).setStartDelay(1).translationY(-1600).translationX(-1600).setDuration(3000).setStartDelay(4000);

        //Testing timing.
        //lottieRight.animate().translationY(1600).translationX(1600).setDuration(3000).setStartDelay(4000);
        //lottieLeft.animate().translationY(-1600).translationX(-1600).setDuration(3000).setStartDelay(4000);

        //for Onboard frags
        viewPager = findViewById(R.id.viewpager);
        pagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);

    }

    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter{

        public ScreenSlidePagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return new OnboardFrag1();
                case 1:
                    OnboardFrag2 tab2 = new OnboardFrag2();
                    return tab2;
                case 2:
                    OnboardFrag3 tab3 = new OnboardFrag3();
                    return tab3;
            }
            return null;
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
}