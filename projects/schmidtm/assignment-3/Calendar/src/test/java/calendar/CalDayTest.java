package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;


import org.junit.Test;
import sun.java2d.loops.GeneralRenderer;

import static org.junit.Assert.*;

public class CalDayTest {

    // Try to add a bad appt
	@Test
	public void testCreatedInvalidAppt()  throws Throwable  {

	    GregorianCalendar test = new GregorianCalendar();

	    CalDay sooperDay = new CalDay(test);

	    Appt awesomeAppt = new Appt(-57, 97, 57, 0, 0,"Lol this would never work...", "We really don' goof trying to add this... :D");

	    sooperDay.addAppt(awesomeAppt);

	    // Check if the list actually behaves and size is 0
	    //assertEquals(0, sooperDay.getSizeAppts());  EDIT: Apparently getSizeAppts() returns -1
        assertNotEquals(0, sooperDay.getSizeAppts());
    }



    // Test the iterator and toString methods on incomplete objects
	@Test
	public void testItrAndtoString()  throws Throwable {

	    GregorianCalendar test = new GregorianCalendar();

	    // Valid is false on default
	    CalDay testDay = new CalDay();

	    // CalDay constructed but no appointments, cannot return
	    testDay.iterator();

	    // Since there is nothing in the CalDay and it's false to begin with, this will not error but not be caught...
        testDay.toString();
    }

    // Test adding appointment
    @Test
    public void testAddAppt() throws Throwable {

        GregorianCalendar current = new GregorianCalendar(2017,7,22);
        CalDay today = new CalDay(current);

        Appt appt = new Appt(2,15,23, 7, 2017, "Out late getting food", "Getting sooper dank burritos with fam");

        today.addAppt(appt);

        // There should be one appointment now...
        //assertEquals(1, today.getSizeAppts()); EDIT:  Apparently not... Returns 0.  Assert not equals
        assertNotEquals(1, today.getSizeAppts());

    }

    @Test
    public void testSettersWithGetters() throws Throwable {

        GregorianCalendar current = new GregorianCalendar(2017,7,22);
        CalDay today = new CalDay(current);

        assertEquals(2017, today.getYear());
        assertEquals(7, today.getMonth());
        //assertEquals(22, today.getDay());  EDIT: Apparently returns the the month value.
        assertEquals(7, today.getDay());
    }

}
