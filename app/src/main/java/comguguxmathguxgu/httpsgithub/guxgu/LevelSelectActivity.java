package comguguxmathguxgu.httpsgithub.guxgu;

import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import static android.R.attr.level;

public class LevelSelectActivity extends AppCompatActivity {
LinearLayout parent;

    private static SoundPool mSoundPool;
    private static int buttonClinkSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_select);


        int iNumberOfButtons =  5; // what ever number was passed from user profile;
        Button[] dynamicButtons = new Button[iNumberOfButtons];

        parent = (LinearLayout) findViewById(R.id.ll_parent);


        for (int i = 0; i < iNumberOfButtons; i++) {

            dynamicButtons[i] = new Button(LevelSelectActivity.this);
            dynamicButtons[i].setText("Level " + (i+1));
            dynamicButtons[i].setId(i);

            parent.addView(dynamicButtons[i]);
            final int index = i;
            dynamicButtons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    play(index+1);
                }
            });

        }

        mSoundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
        buttonClinkSound = mSoundPool.load(getApplicationContext(), R.raw.button_click, 1);

    }

    public void clickSound()
    {
        mSoundPool.play(buttonClinkSound, 1.0f, 1.0f, 0, 0, 1.0f);
    }

    public void play(int levelNum)
    {
        clickSound();
        Intent intent = new Intent(getApplicationContext(),PlayLevelActivity.class);
        intent.putExtra("num", levelNum);
        startActivity(intent);
    }

}
