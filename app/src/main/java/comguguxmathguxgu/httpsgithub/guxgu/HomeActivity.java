package comguguxmathguxgu.httpsgithub.guxgu;

import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    private static SoundPool mSoundPool;
    private static int buttonClinkSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mSoundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
        buttonClinkSound = mSoundPool.load(getApplicationContext(), R.raw.button_click, 1);
    }

    public void onPlayButtonClicked(View v){
        mSoundPool.play(buttonClinkSound, 1.0f, 1.0f, 0, 0, 1.0f);
        startActivity(new Intent(this, LevelSelectActivity.class));
    }

    public void onHelpButtonClicked(View v){
        startActivity(new Intent(this, InstructionsActivity.class));
    }
}
