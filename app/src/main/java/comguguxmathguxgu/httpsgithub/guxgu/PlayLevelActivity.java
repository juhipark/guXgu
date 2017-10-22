package comguguxmathguxgu.httpsgithub.guxgu;

import android.content.Intent;
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
import static android.R.attr.x;
import static android.R.id.button1;
import static android.support.v7.widget.AppCompatDrawableManager.get;
import static comguguxmathguxgu.httpsgithub.guxgu.R.id.button4;
import static comguguxmathguxgu.httpsgithub.guxgu.R.id.streakScore;
import static comguguxmathguxgu.httpsgithub.guxgu.R.string.random;

public class PlayLevelActivity extends AppCompatActivity {


    private Button button1, button2, button3, button4;
    private ProgressBar progressBar;
    private TextView equation;
    private TextView scoreStreak;
    private PlayLevelSelect game;
    private int multiple;
    private int[] choices;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_level);

        equation = (TextView) findViewById(R.id.findEquation);
        scoreStreak = (TextView) findViewById(R.id.streakScore);
        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);
        button4 = (Button)findViewById(R.id.button4);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        choices = new int[4];
        Intent intent = getIntent();
        int num = intent.getIntExtra("num", 0);


        game = new PlayLevelSelect(num);
        start();
    }

    public void start()
    {
        multiple = game.getMultiple();
        equation.setText(game.getEquation());
        makeChoices();
        streak(game.getStreak());
    }

    public void right()
    {
        game.addStreak();
        start();
    }

    public void wrong()
    {
        game.zeroStreak();
        start();
    }


    public void makeChoices()
    {
        Random rand = new Random();
        int n;

        for(int i=0; i<4; i++)
        {
            do {
                n = game.getChoices();
            }while(Arrays.asList(choices).contains(n) || n == multiple);

            choices[i] = game.getChoices();
        }


        choices[rand.nextInt(4)] = multiple;

        button1.setText(Integer.toString(choices[0]));
        button2.setText(Integer.toString(choices[1]));
        button3.setText(Integer.toString(choices[2]));
        button4.setText(Integer.toString(choices[3]));
    }

    public void streak(String st)
    {
        scoreStreak.setText("Streak: " + st);
        progressBar.setProgress(10 * Integer.parseInt(game.getStreak()));
        if()
    }


    public void onButton1Clicked(View v)
    {
        if(choices[0] == multiple)
            right();
        else
            wrong();
    }

    public void onButton2Clicked(View v)
    {
        if(choices[1] == multiple)
            right();
        else
            wrong();
    }

    public void onButton3Clicked(View v)
    {
        if(choices[2] == multiple)
            right();
        else
            wrong();
    }

    public void onButton4Clicked(View v)
    {
        if(choices[3] == multiple)
            right();
        else
            wrong();
    }

}
