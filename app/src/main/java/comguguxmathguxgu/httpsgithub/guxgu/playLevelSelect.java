package comguguxmathguxgu.httpsgithub.guxgu;

import android.widget.TextView;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by danielmorales on 10/22/17.
 */

public class PlayLevelSelect {
    private Random rand;
    private TextView equation;
    private TextView streakScore;
    private int multiple;
    private int num;
    private int streak;

    PlayLevelSelect(int num) {
        rand = new Random();
        setNum(num);
        streak = 0;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getNum() {return num;}

    public int getMultiple() {
        multiple = rand.nextInt(10);
        return multiple;
    }

    public String getEquation()
    {
        int ans;
        ans = num * multiple;
        return Integer.toString(num) + " X ? = " + Integer.toString(ans);
    }

    public int getChoices()
    {
        while(true)
        {
            int n = rand.nextInt(10);
            if(n != multiple)
            {
                return n;
            }
        }

    }

    public String getStreak()
    {
        return Integer.toString(streak);
    }

    public void addStreak()
    {
        streak++;
    }

    public void zeroStreak()
    {
        streak = 0;
    }

}
