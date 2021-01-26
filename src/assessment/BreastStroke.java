package assessment;

/**
 * This class describes the BreastStroke event.  The class creates
 * an event type, the distance of swim, the winning time at the event,
 * any new record set and the venue of the BreastStroke event.
 * @author 19016480 Lauren Smart
 */
public class BreastStroke extends Event 
{
    public String eventType;
    public int distance;
    public Double winningTime;
    public Boolean newRecord;
    public String venue;
    public int venue2;

    public BreastStroke(String eventType, int distance, Double winningTime, int eventNo, String venue, int venueID, String eventDateTime, Double record) {
        super(eventNo, venue, venueID, eventDateTime, record);
        this.eventType = eventType;
        this.distance = distance;
        this.winningTime = winningTime;
        this.venue = venue;
    }

    public BreastStroke() {
        super();
        eventType = "";
        distance = 0;
        winningTime = 00.00;
        newRecord = false;
        venue2 = 0;
    }

/**
 * This method returns the event type.
 * @return 
 */        
public String getEventType() {
    return eventType;
}

/**
 * This method sets the event type.
 * @param eventType 
 */
public void setEventType(String eventType) {
    this.eventType = eventType;
}

/**
 * This method returns the distance of the event.
 * @return 
 */
public int getDistance() {
    return distance;
}

/**
 * This method sets the distance for the event.
 * @param distance 
 */
public void setDistance(int distance) {
    this.distance = distance;
}

/**
 * This method returns the winning time for the competitor.
 * @return 
 */
public Double getWinningTime() {
    return winningTime;
}

/**
 * This method sets the winning time for the competitor.
 * @param winningTime 
 */
public void setWinningTime(Double winningTime) {
    this.winningTime = winningTime;
}

/**
 * This method returns whether the new record set is true or false.
 * It needs method winning time to compare against.
 * @return 
 */
public boolean isNewRecord() {

        if(this.getWinningTime() < this.getRecord())
        {
            this.setRecord(this.getWinningTime());
            newRecord = true;
        }      
    return false;
}

/**
 * This method returns the venue if it has a proper name
 * and is over-ridden from Event class.
 * @return 
 */
@Override
public String getVenue()
{
    return venue;
}

/**
 * This method sets the venue (name version) and is over-ridden from Event class.
 * @param venue 
 */
@Override
public void setVenue(String venue)
{
this.venue = venue;
}

/**
 * This method sets the venue if it is known by a number.
 * @param venue2
 * @return 
 */
public int getVenue2(int venue2)
{
    return venue2;
}

/**
 * This method sets the venue (numerical).
 * @param venue2
 */
public void setVenue2(int venue2)
{
this.venue2 = venue2;
}

/**
 * this method returns as a string, the event type, distance and winning time.
 * This method is over-ridden from Event class.
 * @return 
 */
@Override
public String toString()
{
String str = "";

str += "\n\nBreastStroke Class: "
    + "\nEvent Type: " + this.getEventType()
    + "\nDistance (metres): " + this.getDistance() +"m"
    + "\nWinning Time: " + this.getWinningTime()
        + super.toString();    

    return str;
}    

/**
 * This method sends to file the event type, distance and winning time.
 * Over-ridden from Event class.
 * @return 
 */
@Override
public String toFile()
{
    String string = "";
        
        string += this.getEventType()
            + "," + this.getDistance()
            + "," + this.getWinningTime()
            +    super.toFile();
                     
        return string;    
    }
}