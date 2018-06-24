package comguguxmathguxgu.httpsgithub.guxgu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;


public class LevelPlayActivity extends AppCompatActivity implements View.OnClickListener {

    private int num;
    private Random rand = new Random();
    private int max = 9;
    private int min = 2;
    private HashMap<Integer, Integer> hMap;
    private int answerPair;
    private Button button1, button2, button3, button4;
    private TextView equation;
    private ArrayList<Integer> valuesList;
    private List<Integer> keysList;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_play);

        Intent intent = getIntent();
        num = intent.getIntExtra("num", 0);
        startGame();

        equation = (TextView) findViewById(R.id.findEquation);
        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);
        button4 = (Button)findViewById(R.id.button4);

        showView();

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
    }

    public int selectRand(){
        return rand.nextInt(4);
    }

    public void startGame(){
        //create hashmap
        hMap = new HashMap<Integer,Integer>();

        while(hMap.size() < 4) {
            int key = rand.nextInt((max - min) + 1) + min;
            if(hMap.get(key) == null){
                hMap.put(key, key*num);
            }
        }

        answerPair = selectRand();

    }
    public void showView(){
        valuesList = new ArrayList<Integer>(hMap.values());
        keysList = new ArrayList<>(hMap.keySet());

        equation.setText(Integer.toString(num) + " * " + Integer.toString(keysList.get(answerPair)) + " = ?");
        button1.setText(Integer.toString(valuesList.get(0)));
        button2.setText(Integer.toString(valuesList.get(1)));
        button3.setText(Integer.toString(valuesList.get(2)));
        button4.setText(Integer.toString(valuesList.get(3)));

    }

    @Override
    public void onClick(View view) {
        Button b = (Button)view;
        String buttonText = b.getText().toString();

        if(buttonText == valuesList.get(answerPair).toString())
            score += 1;
        else
            score -= 1;
        if(score > 10){
            Intent intent = new Intent(getApplicationContext(), LevelCompleteActivity.class);
            intent.putExtra("msg", "You Won!");
            startActivity(intent);
            finish();
        }else{
            startGame();
            showView();
        }
    }




}
