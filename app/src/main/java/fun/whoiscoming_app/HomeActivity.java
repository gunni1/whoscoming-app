package fun.whoiscoming_app;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import fun.whoiscoming_app.rest.LoadTrainingsTask;
import fun.whoiscoming_app.rest.TrainingClient;
import fun.whoiscoming_app.rest.TrainingDto;

public class HomeActivity extends AppCompatActivity implements LoadTrainingsTask.Listener
{
    private static final String API_HOST = "http://192.168.0.4:7000";
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("EEE d MMM yyyy");

    private static final String KEY_TRAINING_TIME = "time";
    private static final String KEY_TRAINING_TITLE = "title";
    private static final String KEY_TRAINING_LOCATION = "location";

    private List<HashMap<String, String>> trainingMapList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        new LoadTrainingsTask(this, API_HOST).execute("");
    }


    @Override
    public void onLoaded(List<TrainingDto> trainings)
    {
        for(TrainingDto trainingDto: trainings)
        {
            HashMap<String, String> trainingData = new HashMap<String, String>();

            trainingData.put(KEY_TRAINING_TIME, DATE_FORMAT.format(trainingDto.getTrainingTime()));
            trainingData.put(KEY_TRAINING_TITLE, trainingDto.getTitle());
            trainingData.put(KEY_TRAINING_LOCATION, trainingDto.getLocation());
            trainingMapList.add(trainingData);
        }

        ListAdapter adapter = new SimpleAdapter(HomeActivity.this, trainingMapList, R.layout.training_item,
                new String[] { KEY_TRAINING_TIME, KEY_TRAINING_TITLE, KEY_TRAINING_LOCATION },
                new int[] { R.id.time,R.id.title, R.id.location });

        ListView listView = (ListView) findViewById(R.id.trainingList);
        listView.setAdapter(adapter);
    }

    @Override
    public void onError(String error)
    {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }
}
