package labs.course.activitylab;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

//import android.app.Activity;
import android.content.Intent;
//import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


public class ActivityOne extends ActionBarActivity {

    // Use these as keys when you're saving state between reconfigurations
    private static final String RESTART_KEY = "restart";
    private static final String RESUME_KEY = "resume";
    private static final String START_KEY = "start";
    private static final String CREATE_KEY = "create";

    // String for LogCat documentation
    private final static String TAG = "Lab-ActivityOne";

    // Lifecycle counters
    private int mCreate = 0;
    private int mRestart = 0;
    private int mStart = 0;
    private int mResume = 0;

    // You will need to increment these variables' values when their
    // corresponding lifecycle methods get called.

    // TODO: Create variables for each of the TextViews
    // named mTvCreate, mTvRestart, mTvStart, mTvResume.
    // for displaying the current count of each counter variable
    TextView mTvCreate = new TextView(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);

        // TODO: Assign the appropriate TextViews to the TextView variables
        // Hint: Access the TextView by calling Activity's findViewById()
        mTvCreate = (TextView) findViewById(R.id.create);

        Button launchActivityTwoButton = (Button) findViewById(R.id.bLaunchActivityTwo);
        launchActivityTwoButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(ActivityOne.this, ActivityOne.class);
                startActivity(intent);
            }
        });

        // previously saved state
        if (savedInstanceState != null) {

            mRestart = savedInstanceState.getInt(RESTART_KEY);
            mResume = savedInstanceState.getInt(RESUME_KEY);
            mStart = savedInstanceState.getInt(START_KEY);
            mCreate = savedInstanceState.getInt(CREATE_KEY);

        }

        // TODO: Emit LogCat message
        //Log.i("ActivityOne", "Entered the onCreate method");

        mCreate++;
        //displayCounts();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_one, menu);
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
