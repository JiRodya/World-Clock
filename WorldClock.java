/**
 * Title:       WorldClock
 * Semester:    COP3337-Summer2022
 * @author:     Dianelys Rocha

 
 * This program simulates a world clock, inheriting from class clock
 */
import java.time.LocalDateTime;

/**
 * PART II.
 * Provide a subclass of Clock namded WorldClock whose constructor
 * accepts a time offset. For example, if you live in California,
 * a new WorldClock(3) should show the time in New York, three
 * time zones ahead. You should not override getTime.
 */
public class WorldClock extends Clock
{
    private int offset;
   // Your work goes here

   /**
   * constructor
   * @param timeOffset offset according to location
   */
  public WorldClock(int timeOffset)
  {
      offset=timeOffset;

  }

  /**
   * gets current hours according to the offset Value
   * @return hours of current time plus the offset in string
   */

    @Override
  public String getHours()
  {
       int intHours = Integer.parseInt(super.getHours())+offset;
       String stringHours="";

       if(intHours>24)
       {
           intHours-=24;
       }

       stringHours+=intHours;
       return stringHours;
  }


}
