package calendar;

import java.util.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for CalDay class.
 */

public class CalDayRandomTest {

    private static final long TestTimeout = 30 * 1000; /* Timeout at 30 seconds */
    private static final int NUM_APPTS = 50;
	
    /**
     * Generate Random Tests that test CalDay Class.
     */
    @Test
    public void randomTest()  throws Throwable {

        long startTime = Calendar.getInstance().getTimeInMillis();
        long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

        System.out.println("Start testing...");

        try {

            for (int iteration = 0; elapsed < TestTimeout; iteration++) {

                long randomseed = System.currentTimeMillis(); //10
                //System.out.println(" Seed:"+randomseed );
                Random random = new Random(randomseed);


                int year = 2017;
                int month = 8;
                int day = 21;

                CalDay testDay = new CalDay(new GregorianCalendar(year, month, day));

                for (int i = 0; i < NUM_APPTS; i++) {

                    int startHour = ValuesGenerator.getRandomIntBetween(random, -1, 25);
                    int startMinute = ValuesGenerator.getRandomIntBetween(random, -1, 61);
                    int startDay = ValuesGenerator.getRandomIntBetween(random, 0, 32);
                    int startMonth = ValuesGenerator.getRandomIntBetween(random, 0, 14);
                    int startYear = ValuesGenerator.RandInt(random);
                    String title = "Birthday Party";
                    String description = "This is my birthday party.";
                    //Construct a new Appointment object with the initial data
                    Appt appt = new Appt(startHour,
                            startMinute,
                            startDay,
                            startMonth,
                            startYear,
                            title,
                            description);

                    testDay.addAppt(appt);
                }

                elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);

                if ((iteration % 10000) == 0 && iteration != 0)
                    System.out.println("elapsed time: " + elapsed + " of " + TestTimeout);

            }
        } catch (NullPointerException e) {

        }

        System.out.println("Done testing...");

    }
}
