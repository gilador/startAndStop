package com.app.startNstop.view.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.app.startNstop.R;

import java.util.ArrayList;


public class ProjectClockInOutActivity extends Activity {

    private ListView mProjectTilesList;
    private ArrayList<String> projectNamesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUi();
    }

    private void initUi() {

        mProjectTilesList = (ListView) findViewById(R.id.projectTilesList);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

//    /**
//     * Do our sample database stuff.
//     */
//    private void doSampleDatabaseStuff(String action, TextView tv) {
//        // get our dao
//        RuntimeExceptionDao<SimpleData, Integer> simpleDao = getHelper().getSimpleDataDao();
//        // query for all of the data objects in the database
//        List<SimpleData> list = simpleDao.queryForAll();
//        // our string builder for building the content-view
//        StringBuilder sb = new StringBuilder();
//        sb.append("Found ").append(list.size()).append(" entries in DB in ").append(action).append("()\n");
//
//        // if we already have items in the database
//        int simpleC = 1;
//        for (SimpleData simple : list) {
//            sb.append('#').append(simpleC).append(": ").append(simple).append('\n');
//            simpleC++;
//        }
//        sb.append("------------------------------------------\n");
//        sb.append("Deleted ids:");
//        for (SimpleData simple : list) {
//            simpleDao.delete(simple);
//            sb.append(' ').append(simple.id);
//            Log.i(LOG_TAG, "deleting simple(" + simple.id + ")");
//            simpleC++;
//        }
//        sb.append('\n');
//        sb.append("------------------------------------------\n");
//
//        int createNum;
//        do {
//            createNum = new Random().nextInt(MAX_NUM_TO_CREATE) + 1;
//        } while (createNum == list.size());
//        sb.append("Creating ").append(createNum).append(" new entries:\n");
//        for (int i = 0; i < createNum; i++) {
//            // create a new simple object
//            long millis = System.currentTimeMillis();
//            SimpleData simple = new SimpleData(millis);
//            // store it in the database
//            simpleDao.create(simple);
//            Log.i(LOG_TAG, "created simple(" + millis + ")");
//            // output it
//            sb.append('#').append(i + 1).append(": ");
//            sb.append(simple).append('\n');
//            try {
//                Thread.sleep(5);
//            } catch (InterruptedException e) {
//                // ignore
//            }
//        }
//
//        tv.setText(sb.toString());
//        Log.i(LOG_TAG, "Done with page at " + System.currentTimeMillis());
//    }
}
