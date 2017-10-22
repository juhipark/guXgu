package comguguxmathguxgu.httpsgithub.guxgu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

import static android.R.attr.button;
import static android.R.id.button1;
import static android.support.v7.widget.AppCompatDrawableManager.get;

public class PlayLevelActivity extends AppCompatActivity {

    static Random rand = new Random(); //declaring a random object

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_level);

        TextView equation = (TextView) findViewById(R.id.findEquation); //Declaring the text view
        Button button1 = (Button)findViewById(R.id.button1); //  declaring the buttons
        Button button2 = (Button)findViewById(R.id.button2);
        Button button3 = (Button)findViewById(R.id.button3);
        Button button4 = (Button)findViewById(R.id.button4);
        Intent intent = getIntent(); //declaring the intent to get the number of the level
        int choices[]=new int[]{-1, -1, -1, -1}; // declaring and array to store the choices
        int multiple, num, ans; // declaring the multiple, number of the level, and the answer

        num = intent.getIntExtra("num", 0); // getting the number of the level that the player is on

        multiple = rand.nextInt(9) + 1; //making a random number to be the multiple of the level

        ans = num * multiple; // getting the answer

        equation.setText(Integer.toString(num) + " X ? = " + Integer.toString(ans)); // displaying the equation

        choices[rand.nextInt(4)] = multiple; // storing the answer in a random choice

        for(int i=0; i<4; i++) // making and filling the left over choices with random number from 0-9
            if(choices[i] == -1)
                choices[i] = rand.nextInt(10);

        button1.setText(Integer.toString(choices[0])); // changing the text in the buttons to the choices
        button2.setText(Integer.toString(choices[1]));
        button3.setText(Integer.toString(choices[2]));
        button4.setText(Integer.toString(choices[3]));
    }

}
