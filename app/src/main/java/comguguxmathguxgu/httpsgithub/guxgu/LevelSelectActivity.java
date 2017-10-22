package comguguxmathguxgu.httpsgithub.guxgu;

import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static android.R.attr.level;

public class LevelSelectActivity extends AppCompatActivity {

    private static SoundPool mSoundPool;
    private static int buttonClinkSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_select);

        mSoundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
        buttonClinkSound = mSoundPool.load(getApplicationContext(), R.raw.button_click, 1);

    }

    public void onLevel1Clicked(View v){
        clickSound();
        play(1);
    }

    public void onLevel2Clicked(View v){
        clickSound();
        play(2);
    }

    public void onLevel3Clicked(View v){
        clickSound();
        play(3);
    }

    public void onLevel4Clicked(View v){
        clickSound();
        play(4);
    }

    public void onLevel5Clicked(View v){
        clickSound();
        play(5);
    }

    public void onLevel6Clicked(View v){
        clickSound();
        play(6);
    }

    public void onLevel7Clicked(View v){
        clickSound();
        play(7);
    }

    public void onLevel8Clicked(View v){
        clickSound();
        play(8);
    }

    public void onLevel9Clicked(View v){
        clickSound();
        play(9);
    }

    public void clickSound()
    {
        mSoundPool.play(buttonClinkSound, 1.0f, 1.0f, 0, 0, 1.0f);
    }

    public void play(int levelNum)
    {
        Intent intent = new Intent(getApplicationContext(),PlayLevelActivity.class);
        intent.putExtra("num", levelNum);
        startActivity(intent);
    }



}
