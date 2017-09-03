package fun.whoiscoming_app.rest;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
import java.util.List;

/**
 * Transportobjekt für ein Training
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TrainingDto
{
    private String id;
    private String title;
    private String location;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
    private Date trainingTime;

    List<String> participants;


    public TrainingDto()
    {
    }

    public TrainingDto(String id, String title, String location, Date trainingTime, List<String> participants)
    {
        this.id = id;
        this.title = title;
        this.location = location;
        this.trainingTime = trainingTime;
        this.participants = participants;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getLocation()
    {
        return location;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }

    public Date getTrainingTime()
    {
        return trainingTime;
    }

    public void setTrainingTime(Date trainingTime)
    {
        this.trainingTime = trainingTime;
    }

    public List<String> getParticipants()
    {
        return participants;
    }

    public void setParticipants(List<String> participants)
    {
        this.participants = participants;
    }
}
