package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {

    // #####################################################################################################################################
    // ### permute() Function Tests ########################################################################################################
    // #####################################################################################################################################

    // Goal:  Test the permute function on only one present appointment
    // Should fail with Out of Bounds exception (1 created, 1 element to permute, reaching past 1 element to a second)
    @Test
    public void permuteTestOnlyOnePresentAppt()  throws Throwable  {

        /** Collection of all of the appointments for the calendar day */
        LinkedList<Appt> listAppts = new LinkedList<Appt>();

        /** the month the user is currently viewing **/
        int thisMonth;

        /** the year the user is currently viewing **/
        int thisYear;

        /** todays date **/
        int thisDay;

        // Get today's date
        Calendar rightnow = Calendar.getInstance();
        // Current month/year/date is today
        thisMonth = rightnow.get(Calendar.MONTH)+1;
        thisYear = rightnow.get(Calendar.YEAR);
        thisDay = rightnow.get(Calendar.DAY_OF_MONTH);

        int startHour=15;
        int startMinute=30;
        int startDay=thisDay;  	    //11
        int startMonth=thisMonth; 	//4
        int startYear=thisYear; 	//2017/2017
        String title="Birthday Party";
        String description="This is my birthday party.";

        // Construct a new Appointment object with the initial data
        Appt appt = new Appt(startHour,
                startMinute ,
                startDay ,
                startMonth ,
                startYear ,
                title,
                description);

        int[] anArray={2,3,4};

        appt.setRecurrence( anArray, Appt.RECUR_BY_WEEKLY, 2, Appt.RECUR_NUMBER_FOREVER);

        listAppts.add(appt);


        // Get a list of appointments for one day, which is today
        GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
        GregorianCalendar tomorrow = (GregorianCalendar)today.clone();
        tomorrow.add(Calendar.DAY_OF_MONTH,1);

        TimeTable timeTable=new TimeTable();

        // Create a linked list of calendar days to return
        LinkedList<CalDay> calDays = new LinkedList<CalDay>();

        int[] pv={1};

        try {

            LinkedList<Appt> listUpdatedAppts=timeTable.permute(listAppts, pv);
        }
        catch(NullPointerException e) {}
    }


    // #####################################################################################################################################
    // ### getApptRange() and delete() Function Tests ######################################################################################
    // #####################################################################################################################################


    // Goal:  Test the delete method along side the getApptRange method
    // Uses assertions
    @Test
    public void getApptRangeTest()  throws Throwable  {

        TimeTable tTable=new TimeTable();

        // Collection of all of the appointments for the calendar day
        LinkedList<Appt> listAppts = new LinkedList<Appt>();

        // Create a valid appointment!
        Appt appt = new Appt(15,30,11,7,2017,"Birthday party", "This is my birthday party.");

        // Add appointment to list of appointments
        listAppts.add(appt);


        // Create a valid appointment!
        appt = new Appt(15,30,12,7,2017,"Continuing Birthday party", "This is my birthday party.");

        // Add appointment to list of appointments
        listAppts.add(appt);

        // Create a valid appointment!
        appt = new Appt(15,30,13,7,2017,"Still Birthday party", "This is my birthday party.");

        // Add appointment to list of appointments
        listAppts.add(appt);


        // Create range of dates
        GregorianCalendar firstDay = new GregorianCalendar(2017,7,1);
        GregorianCalendar lastDay = new GregorianCalendar(2017,7,31);

        LinkedList<CalDay> calendarDays = new LinkedList<CalDay>();

        int[] pv = {0,1,2};

        // Create a permutated list to compare later
        LinkedList<Appt> listUpdatedAppts=tTable.permute(listAppts, pv);
        // Also a deleted list, to test delete method
        LinkedList<Appt> listDeletedAppts=tTable.deleteAppt(listAppts, listAppts.get(1));
        // Also a null list, to test with
        LinkedList<Appt> nullList = null;


        // Add assertions
        assertFalse("Error: Permutated matches original!", listAppts == listUpdatedAppts);
        assertNull("Error: getApptRange did NOT return null", tTable.getApptRange(nullList,firstDay,lastDay));



    }



}
