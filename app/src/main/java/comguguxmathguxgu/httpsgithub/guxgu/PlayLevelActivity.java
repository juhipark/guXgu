package comguguxmathguxgu.httpsgithub.guxgu;

import android.app.Dialog;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Random;

import static android.R.attr.button;
import static android.R.attr.right;
import static android.R.attr.x;
import static android.R.id.button1;
import static android.support.v7.widget.AppCompatDrawableManager.get;
import static comguguxmathguxgu.httpsgithub.guxgu.R.id.button4;
import static comguguxmathguxgu.httpsgithub.guxgu.R.id.start;
import static comguguxmathguxgu.httpsgithub.guxgu.R.string.random;

public class PlayLevelActivity extends AppCompatActivity {

    private static SoundPool mSoundPool;
    private Random rand = new Random();
    private static int right_answer;
    private static int wrong_answer;
    private Button button1, button2, button3, button4;
    private CountDownTimer countDownTimer;
    private TextView countDownText;
    private long time;
    private boolean timerRunning;
    private TextView equation;
    private int[] numbers = new int[8];
    private int[] buttonChoices = new int[4];
    private int multiple;
    private int num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_level);

        mSoundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
        right_answer = mSoundPool.load(getApplicationContext(), R.raw.right_answer, 1);
        wrong_answer = mSoundPool.load(getApplicationContext(), R.raw.wrong_answer, 1);
        countDownText = (TextView) findViewById(R.id.timer);
        equation = (TextView) findViewById(R.id.findEquation);
        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);
        button4 = (Button)findViewById(R.id.button4);
        Arrays.fill(numbers, 0);
        Intent intent = getIntent();
        num = intent.getIntExtra("num", 0);

        startGame();
    }

    public void startGame()
    {
        checkMastery();
        getMultible();
        getEquation();
        getButtons();
        getTime();
        levelUp();
    }

    public void checkMastery()
    {
        boolean check=true;

        for(int i=0; i<8; i++) {
            if(numbers[i] < 3){
                check = false;
                break;
            }
        }

        if(check)
            levelUp();
    }

    public void getMultible()
    {
        int temp;
        do{
            temp = rand.nextInt(8);
        }while(numbers[temp] >= 3);

        multiple = temp + 2;
    }

    public void getEquation()
    {
        equation.setText(Integer.toString(num) + " * " + Integer.toString(multiple) + " = ?");
    }

    public void getButtons() {
        boolean repeat=false;

        for (int i = 0; i < 4; i++) {
            do {
                repeat = false;

                buttonChoices[i] = num * (rand.nextInt(8) + 2);

                for (int x = 0; x < 4; x++)
                    if (buttonChoices[i] == buttonChoices[x] && x != i || buttonChoices[i] == multiple * num) repeat = true;

            } while (repeat);
        }

        buttonChoices[rand.nextInt(4)] = multiple * num;

        button1.setText(Integer.toString(buttonChoices[0]));
        button2.setText(Integer.toString(buttonChoices[1]));
        button3.setText(Integer.toString(buttonChoices[2]));
        button4.setText(Integer.toString(buttonChoices[3]));
    }

    public void checkAnswer(int n)
    {
        if(buttonChoices[n] == num * multiple && n != 5)
        {
            numbers[multiple]++;
            mSoundPool.play(right_answer, 1.0f, 1.0f, 0, 0, 1.0f);
        }
        else {
            numbers[multiple] = 0;
            mSoundPool.play(wrong_answer, 1.0f, 1.0f, 0, 0, 1.0f);
        }

        startGame();
    }

    public void getTime(){

        time = 5000;

        countDownTimer = new CountDownTimer(time, 1000) {
            @Override
            public void onTick(long l) {
                time = l;
                countDownText.setText(Integer.toString((int) time/1000));
            }

            @Override
            public void onFinish() {
                numbers[multiple] = 0;
                mSoundPool.play(wrong_answer, 1.0f, 1.0f, 0, 0, 1.0f);
                startGame();
            }
        }.start();
    }

    public void onButton1Clicked(View v){
        checkAnswer(0);
    }

    public void onButton2Clicked(View v){
        checkAnswer(1);
    }

    public void onButton3Clicked(View v){
        checkAnswer(2);
    }

    public void onButton4Clicked(View v){
        checkAnswer(3);
    }

    public void levelUp()
    {
        Dialog dialog = new Dialog(PlayLevelActivity.this);
        //dialog.addContentView(R.layout.level_up, null);
    }
}