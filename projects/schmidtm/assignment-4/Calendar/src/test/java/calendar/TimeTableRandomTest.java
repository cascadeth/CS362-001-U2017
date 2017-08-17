package calendar;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.Random;

import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for TimeTable class.
 */

public class TimeTableRandomTest {

    private static final long TestTimeout = 30 * 1000; /* Timeout at 30 seconds */
    private static final int NUM_APPTS = 200;

    @Test
    public void randomTest() throws Throwable {

        long startTime = Calendar.getInstance().getTimeInMillis();
        long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

        System.out.println("Start recurrence testing...");

        for (int iteration = 0; elapsed < TestTimeout; iteration++) {

            long randomseed = System.currentTimeMillis(); //10
            //System.out.println(" Seed:"+randomseed );
            Random random = new Random(randomseed);

            TimeTable timeTable = new TimeTable();
            LinkedList<Appt> listAppts = new LinkedList<Appt>();

            int latestYear = 2117;
            int earliestYear = 2017;
            int month = 8;
            int day = 21;


            elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);

            for (int i = 0; i < ValuesGenerator.getRandomIntBetween(random, 0, NUM_APPTS); i++) {

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

                if(startYear > latestYear && appt.getValid())
                    latestYear = startYear;
                if(startYear < earliestYear && appt.getValid())
                    earliestYear = startYear;

                int[] anArray = new int[0];
                appt.setRecurrence(anArray, appt.RECUR_BY_WEEKLY, 1, appt.RECUR_NUMBER_FOREVER);

                listAppts.add(appt);
            }

            try {

                GregorianCalendar lessRandDay1 = new GregorianCalendar(earliestYear, month, (day + ValuesGenerator.getRandomIntBetween(random, 0, 31)));
                GregorianCalendar lessRandDay2 = new GregorianCalendar(earliestYear, month, (day + ValuesGenerator.getRandomIntBetween(random, 0, 31)));

                timeTable.getApptRange(listAppts,lessRandDay1,lessRandDay2);

                GregorianCalendar day1 = new GregorianCalendar(earliestYear, (month + ValuesGenerator.getRandomIntBetween(random, 0, 10)), (day + ValuesGenerator.getRandomIntBetween(random, 0, 10)));
                GregorianCalendar day2 = new GregorianCalendar(latestYear, (month + ValuesGenerator.getRandomIntBetween(random, 0, 10)), (day + ValuesGenerator.getRandomIntBetween(random, 0, 10)));

                timeTable.getApptRange(listAppts, day1, day2);
            }
            catch (NullPointerException e) {

            }
            if ((iteration % 10000) == 0 && iteration != 0)
                System.out.println("elapsed time: " + elapsed + " of " + TestTimeout);

        }

        System.out.println("Done recurrence testing...");
    }



    @Test
    public void randomTest1() throws Throwable {

        long startTime = Calendar.getInstance().getTimeInMillis();
        long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

        System.out.println("Start recurrence testing...");

        for (int iteration = 0; elapsed < TestTimeout; iteration++) {

            long randomseed = System.currentTimeMillis(); //10
            //System.out.println(" Seed:"+randomseed );
            Random random = new Random(randomseed);

            TimeTable timeTable = new TimeTable();
            LinkedList<Appt> listAppts = new LinkedList<Appt>();

            int latestYear = 2117;
            int earliestYear = 2017;
            int month = 8;
            int day = 21;


            elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);

            for (int i = 0; i < ValuesGenerator.getRandomIntBetween(random, 0, NUM_APPTS); i++) {

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

                if(startYear > latestYear && appt.getValid())
                    latestYear = startYear;
                if(startYear < earliestYear && appt.getValid())
                    earliestYear = startYear;

                int[] anArray = new int[0];
                appt.setRecurrence(anArray, appt.RECUR_BY_WEEKLY, 1, appt.RECUR_NUMBER_FOREVER);

                listAppts.add(appt);
            }

            try {

                GregorianCalendar lessRandDay1 = new GregorianCalendar(earliestYear, month, (day + ValuesGenerator.getRandomIntBetween(random, 0, 31)));
                GregorianCalendar lessRandDay2 = new GregorianCalendar(earliestYear, month, (day + ValuesGenerator.getRandomIntBetween(random, 0, 31)));

                timeTable.getApptRange(listAppts,lessRandDay1,lessRandDay2);

            }
            catch (DateOutOfRangeException e) {

            }
            if ((iteration % 10000) == 0 && iteration != 0)
                System.out.println("elapsed time: " + elapsed + " of " + TestTimeout);

        }

        System.out.println("Done recurrence testing...");
    }



    @Test
    public void randomTest2() throws Throwable {

        long startTime = Calendar.getInstance().getTimeInMillis();
        long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

        System.out.println("Start deletion testing...");

        for (int iteration = 0; elapsed < TestTimeout; iteration++) {

            try {

                long randomseed = System.currentTimeMillis(); //10
                //System.out.println(" Seed:"+randomseed );
                Random random = new Random(randomseed);

                int loopTimes = ValuesGenerator.getRandomIntBetween(random, 0, NUM_APPTS);

                LinkedList<Appt> listAppts = new LinkedList<Appt>();
                TimeTable testTT = new TimeTable();

                for (int i = 0; i < loopTimes; i++) {

                    // Reduce the range of randomness to be able to
                    // find something to potentially delete later
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

                    listAppts.add(appt);

                    int mod = ValuesGenerator.RandInt(random);
                    // Give a 20% chance
                    if ((10 % (mod + 1)) < 3)
                        appt = null;

                    int mod2 = ValuesGenerator.RandInt(random);
                    // Give a 20% chance
                    if ((10 % (mod2 + 1)) < 3)
                        listAppts = null;

                    int mod3 = ValuesGenerator.RandInt(random);
                    // Give a 10% chance
                    if ((10 % (mod3 + 1)) < 2) {

                        startHour = ValuesGenerator.getRandomIntBetween(random, -1, 25);
                        startMinute = ValuesGenerator.getRandomIntBetween(random, -1, 61);
                        startDay = ValuesGenerator.getRandomIntBetween(random, 0, 32);
                        startMonth = ValuesGenerator.getRandomIntBetween(random, 0, 14);
                        startYear = ValuesGenerator.RandInt(random);

                        title = "Birthday Party";
                        description = "This is my birthday party.";

                        Appt delAppt = new Appt(startHour,
                                startMinute,
                                startDay,
                                startMonth,
                                startYear,
                                title,
                                description);

                        testTT.deleteAppt(listAppts, delAppt);

                    }
                    else
                        testTT.deleteAppt(listAppts, appt);
                }

                elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);

                if ((iteration % 10000) == 0 && iteration != 0)
                    System.out.println("elapsed time: " + elapsed + " of " + TestTimeout);

            } catch (NullPointerException e) {

            }

        }

        System.out.println("Done deletion testing...");
    }


}