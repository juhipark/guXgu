package comguguxmathguxgu.httpsgithub.guxgu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static android.R.attr.level;

public class LevelSelectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_select);

        final Button level1 = (Button) findViewById(R.id.level1); //declaring the buttons
        final Button level2 = (Button) findViewById(R.id.level2);
        final Button level3 = (Button) findViewById(R.id.level3);
        final Button level4 = (Button) findViewById(R.id.level4);
        final Button level5 = (Button) findViewById(R.id.level5);
        final Button level6 = (Button) findViewById(R.id.level6);
        final Button level7 = (Button) findViewById(R.id.level7);
        final Button level8 = (Button) findViewById(R.id.level8);
        final Button level9 = (Button) findViewById(R.id.level9);


        level1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //when the button is click

                Intent intent = new Intent(getApplicationContext(),PlayLevelActivity.class);

                intent.putExtra("num", 1); //sending the level number

                startActivity(intent); // changing activities
            }
        });

        level2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //when the button is click

                Intent intent = new Intent(getApplicationContext(),PlayLevelActivity.class);

                intent.putExtra("num", 2); //sending the level number

                startActivity(intent); // changing activities
            }
        });

        level3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //when the button is click

                Intent intent = new Intent(getApplicationContext(),PlayLevelActivity.class);

                intent.putExtra("num", 3); //sending the level number

                startActivity(intent); // changing activities
            }
        });

        level4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //when the button is click

                Intent intent = new Intent(getApplicationContext(),PlayLevelActivity.class);

                intent.putExtra("num", 4); //sending the level number

                startActivity(intent); // changing activities
            }
        });

        level5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //when the button is click

                Intent intent = new Intent(getApplicationContext(),PlayLevelActivity.class);

                intent.putExtra("num", 6); //sending the level number

                startActivity(intent); // changing activities
            }
        });

        level6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //when the button is click

                Intent intent = new Intent(getApplicationContext(),PlayLevelActivity.class);

                intent.putExtra("num", 6); //sending the level number

                startActivity(intent); // changing activities
            }
        });

        level7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //when the button is click

                Intent intent = new Intent(getApplicationContext(),PlayLevelActivity.class);

                intent.putExtra("num", 7); //sending the level number

                startActivity(intent); // changing activities
            }
        });

        level8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //when the button is click

                Intent intent = new Intent(getApplicationContext(),PlayLevelActivity.class);

                intent.putExtra("num", 8); //sending the level number

                startActivity(intent); // changing activities
            }
        });

        level9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //when the button is click

                Intent intent = new Intent(getApplicationContext(),PlayLevelActivity.class);

                intent.putExtra("num", 9); //sending the level number

                startActivity(intent); // changing activities
            }
        });
    }
}
