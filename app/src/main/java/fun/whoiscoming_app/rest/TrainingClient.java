package fun.whoiscoming_app.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 * Ein Rest-Client zum abfragen von Trainingsinformationen
 */

public class TrainingClient
{
    private final String apiHost;
    private final RestTemplate restTemplate;

    public TrainingClient(String apiHost)
    {
        this.apiHost = apiHost;
        this.restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
    }

    /**
     * Fragt ein Training anhand der Id ab.
     * @return DTO des Training oder null, falls nicht gefunden wurde
     */
    public TrainingDto getTraining(String trainingId)
    {
        return restTemplate.getForObject(apiHost + "/training/" + trainingId, TrainingDto.class);
    }

    /**
     * Liefert die Trainings die einer betsimmten Trainingsgruppe zugeordnet sind.
     */
    public ResponseEntity<TrainingDto[]> getTrainings(String trainingGroup)
    {
        return restTemplate.getForEntity(apiHost + "/trainings", TrainingDto[].class);
    }
}
