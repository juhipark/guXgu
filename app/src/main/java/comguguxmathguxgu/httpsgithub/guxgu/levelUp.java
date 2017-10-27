package comguguxmathguxgu.httpsgithub.guxgu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LevelUp extends AppCompatActivity {

    private int num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_up);

        Intent intent = getIntent();
        int num = intent.getIntExtra("num", 0);

    }

    public void onNextLevelClicked(View v) {
        Intent intent = new Intent(getApplicationContext(), PlayLevelActivity.class);
        intent.putExtra("num", num++);
        startActivity(intent);
    }

    public void playAgainClicked(View v) {
        Intent intent = new Intent(getApplicationContext(), PlayLevelActivity.class);
        intent.putExtra("num", num);
        startActivity(intent);
    }
}
