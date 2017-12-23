package comguguxmathguxgu.httpsgithub.guxgu;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

public class HomeActivity extends AppCompatActivity {
    private PopupWindow hPopupWindow;
    private Context hContext;
    private RelativeLayout hRelativeLayout;
    private Button showHelpBtn;
    private ImageButton closePopupBtn;
    private static SoundPool mSoundPool;
    private static int buttonClinkSound;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mSoundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
        buttonClinkSound = mSoundPool.load(getApplicationContext(), R.raw.button_click, 1);

        showHelpBtn = (Button)findViewById(R.id.helpButton);
        showHelpBtn.setOnClickListener(new helpButtonClick());
    }

    public void onPlayButtonClicked(View v){
        mSoundPool.play(buttonClinkSound, 1.0f, 1.0f, 0, 0, 1.0f);
        startActivity(new Intent(HomeActivity.this, LevelSelectActivity.class));
    }

    class helpButtonClick implements View.OnClickListener{
            @Override
            public void onClick(View v) {
                whenHelpButtonClicked();
            }
    }

    private void whenHelpButtonClicked(){
        LayoutInflater inflater = (LayoutInflater) HomeActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View customView = inflater.inflate(R.layout.activity_instructions,null);

        hRelativeLayout = (RelativeLayout) findViewById(R.id.r1);

        closePopupBtn = (ImageButton) customView.findViewById(R.id.pop_close_btn);

        hPopupWindow = new PopupWindow(
                customView,
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        closePopupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hPopupWindow.dismiss();
            }
        });

        hPopupWindow.showAtLocation(hRelativeLayout, Gravity.CENTER, 0,0);
    }

}
