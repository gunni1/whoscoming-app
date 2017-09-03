package fun.whoiscoming_app.rest;

/**
 * Created by gunni on 03.09.17.
 */

import android.os.AsyncTask;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

/**
 * Asynchrones laden von Trainingsdaten mit Spring REST
 */
public class LoadTrainingsTask extends AsyncTask<Object, Object, ResponseEntity<TrainingDto[]>>
{
    private Listener listener;
    private String apiHost;

    public LoadTrainingsTask(Listener listener, String apiHost){
        this.listener = listener;
        this.apiHost = apiHost;
    }

    public interface Listener {
        void onLoaded(List<TrainingDto> trainings);
        void onError(String error);
    }

    @Override
    protected ResponseEntity<TrainingDto[]> doInBackground(Object... strings)
    {
        TrainingClient client = new TrainingClient(apiHost);
        return client.getTrainings("");
    }

    @Override
    public void onPostExecute(ResponseEntity<TrainingDto[]> response)
    {
        if(response.getStatusCode().equals(HttpStatus.OK))
        {
            listener.onLoaded(Arrays.asList(response.getBody()));
        }
        else
        {
            listener.onError(response.toString());
        }
    }
}
