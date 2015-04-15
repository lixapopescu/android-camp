package course.labs.activitylab;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ActivityOne extends Activity {

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


    // TODO: Create variables for each of the TextViews
    // named mTvCreate, mTvRestart, mTvStart, mTvResume.
    // for displaying the current count of each counter variable
    private TextView mTvCreate;
    private TextView mTvRestart;
    private TextView mTvResume;
    private TextView mTvStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);

        mTvCreate = (TextView) findViewById(R.id.create);
        mTvRestart = (TextView) findViewById(R.id.restart);
        mTvResume = (TextView) findViewById(R.id.resume);
        mTvStart = (TextView) findViewById(R.id.start);

        Button launchActivityTwoButton = (Button) findViewById(R.id.bLaunchActivityTwo);
        launchActivityTwoButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityOne.this, ActivityTwo.class);
                startActivity(intent);
            }
        });

        // Has previous state been saved?
        if (savedInstanceState != null) {
            mCreate = savedInstanceState.getInt("mCreate");
            mRestart = savedInstanceState.getInt("mRestart");
            mResume = savedInstanceState.getInt("mResume");
            mStart = savedInstanceState.getInt("mStart");
            Log.i(TAG, "Restored instance (mCreate, mRestart, mResume, mStart): (" + mCreate + ", " + mRestart + ", " + mResume + ", " + mStart + ")");
        }

        // Emit LogCat message
        Log.i(TAG, "Entered the onCreate() method");

        // TODO:
        // Update the appropriate count variable
        mCreate++;
        // Update the user interface via the displayCounts() method
        displayCounts();
    }

    // Lifecycle callback overrides

    @Override
    public void onStart() {
        super.onStart();

        // Emit LogCat message
        Log.i(TAG, "Entered the onStart() method");

        // TODO:
        mStart++;
        // Update the user interface
        displayCounts();
    }

    @Override
    public void onResume() {
        super.onResume();

        // Emit LogCat message
        Log.i(TAG, "Entered the onResume() method");

        // TODO:
        mResume++;
        // Update the user interface
        displayCounts();
    }

    @Override
    public void onPause() {
        super.onPause();

        // Emit LogCat message
        Log.i(TAG, "Entered the onPause() method");
    }

    @Override
    public void onStop() {
        super.onStop();

        // Emit LogCat message
        Log.i(TAG, "Entered the onStop() method");
    }

    @Override
    public void onRestart() {
        super.onRestart();

        // Emit LogCat message
        Log.i(TAG, "Entered the onRestart() method");

        // TODO:
        mRestart++;
        // Update the user interface
        displayCounts();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        // Emit LogCat message
        Log.i(TAG, "Entered the onDestroy() method");
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        // Save state information with a collection of key-value pairs
        // 4 lines of code, one for every count variable
        savedInstanceState.putInt("mCreate", mCreate);
        savedInstanceState.putInt("mRestart", mRestart);
        savedInstanceState.putInt("mStart", mStart);
        savedInstanceState.putInt("mResume", mResume);
        Log.i(TAG, "Saved instance (mCreate, mRestart, mResume, mStart): (" + mCreate + ", " + mRestart + ", " + mResume + ", " + mStart + ")");
    }

    // Updates the displayed counters
    // This method expects that the counters and TextView variables use the
    // names
    // specified above
    public void displayCounts() {
        mTvCreate.setText("onCreate() calls: " + mCreate);
        mTvStart.setText("onStart() calls: " + mStart);
        mTvResume.setText("onResume() calls: " + mResume);
        mTvRestart.setText("onRestart() calls: " + mRestart);
    }
}
