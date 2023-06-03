/**
 * Title:       Clock
 * Semester:    COP3337-Summer2022
 * @author:     Dianelys Rocha
 * PantherID:   6272943

 *I affirm that this program is entirely my own work. Nothing, but the classes/methods
 * given by the professor, is the work of any other person.

 * This program simulates a local clock, including an alarm.
 */
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * Part I: Implement a class Clock whose getHours, getMinutes and
 * getTime methods return the current time at your location.
 * Return the time as a string.
 *
 * There are two ways to retrieve the current time as a String:
 *
 * 1) Before Java 8 use new Date().toString()
 * 2) With Java 8, you can use 3 classes in the java.time package:
 *    Instant, LocalDateTime and ZoneId. Here's how you do it:
 *    String timeString = LocalDateTime.ofInstant(Instant.now(),
 *                            ZoneId.systemDefault()).toString()
 *
 * With either method, you'll need to extract the hours and
 *   minutes as a substring.
 *
 *
 * Add an alarm feature to the Clock class.
 * When setAlarm(hours, minutes) is called, the clock
 * stores the alarm. When you call getTime, and the alarm
 * time has been reached or exceeded, return the time followed
 * by the string "Alarm" and clear the alarm.
*/
public class Clock
{
   private int alarmHour=Integer.MAX_VALUE;
   private int alarmMinutes=Integer.MAX_VALUE;
   private String time;
   private String hours;
   private String minutes;


   /**
    * Sets the alarm.
    * @param hours hours for alarm
    * @param minutes minutes for alarm
    */
   public void setAlarm(int hours, int minutes)
   {
      // Complete this method
       alarmHour=hours;
       alarmMinutes=minutes;
   }

   /**
    * gets current time composed of hours and minutes
    * @return time in string;
    */
   public String getTime()
   {
      // Complete this method
        hours= getHours();
        minutes=getMinutes();
       String stringTime = hours+":"+minutes;

       if(Integer.parseInt(hours) >= alarmHour && Integer.parseInt(minutes) >=alarmMinutes)
       {
          setAlarm(Integer.MAX_VALUE, Integer.MAX_VALUE);
           return stringTime+ " Alarm";
       }

       return stringTime;
   }

   /**
    * gets hours
    * @return hours of current time in string
   */
   public String getHours()
   {
      // Complete this method
       hours = Integer.toString(LocalDateTime.now().getHour());

       if(String.valueOf(hours).length()<2)
          hours="0"+hours; //just to change format if number of digits is 1

       return hours;
   }

   /**
    * gets minutes
    * @return hours of current time in string
   */
   public String getMinutes()
   {
      // Complete this method
        minutes=Integer.toString(LocalDateTime.now().getMinute());

        if(String.valueOf(minutes).length()<2)
         minutes="0"+minutes; //just to change format if number of digits is 1

        return minutes;
   }

   /**
      Returns the current Date and Time as a String.
   */
   private String currentTime()
   {
      return LocalDateTime.ofInstant(Instant.now(),
         ZoneId.systemDefault()).toString();
   }
}
