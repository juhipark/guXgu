package comguguxmathguxgu.httpsgithub.guxgu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void onPlayButtonClicked(View v){
        startActivity(new Intent(this, LevelSelectActivity.class));
    }

    public void onHelpButtonClicked(View v){
        startActivity(new Intent(this, InstructionsActivity.class));
    }
}
