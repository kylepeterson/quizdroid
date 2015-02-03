package quizdroid.kylep9.washington.edu.quizdroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;


public class MathResults extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("Duba", "results entered");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_results);
        Intent intent = getIntent();

        final int count = intent.getExtras().getInt("count");
        final int correct = intent.getExtras().getInt("correct");
        final Object[] temp = (Object[]) intent.getExtras().get("questions");
        final Question[] questions = Arrays.copyOf(temp, temp.length, Question[].class);
        final int current = intent.getExtras().getInt("current");

        TextView correctBox = (TextView) findViewById(R.id.correctNum);
        correctBox.setText(correct + " Correct");
        TextView totalBox = (TextView) findViewById(R.id.totalNum);
        correctBox.setText(count + " Correct");

        if(current == questions.length) {
            Button next = (Button) findViewById(R.id.next);
            next.setText("Finish");
            Intent nextActivity = new Intent(MathResults.this, MainActivity.class);
            startActivity(nextActivity);
            finish();
        } else {
            Intent nextActivity = new Intent(MathResults.this, MathQuestion1.class);
            nextActivity.putExtra("count", count);
            nextActivity.putExtra("current", current);
            nextActivity.putExtra("questions", questions);
            nextActivity.putExtra("correct", correct);
            startActivity(nextActivity);
            finish();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_math_results, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
