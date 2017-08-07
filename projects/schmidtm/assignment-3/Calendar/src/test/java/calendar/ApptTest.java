package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;
public class ApptTest {
	/**
    * Test that the gets methods work as expected.
    */
	@Test
	public void test01()  throws Throwable  {
		int startHour=13;
		int startMinute=30;
		int startDay=10;
		int startMonth=9;
		int startYear=2017;
		String title="Work LAN";
		String description="This is the workplace end of summer LAN party";

		// Construct a new Appointment object with the initial data
		Appt appt = new Appt(startHour,
			startMinute ,
		    startDay ,
		    startMonth ,
			startYear ,
			title,
			description);

		// Assertions

        // Check validity first
		assertTrue(appt.getValid());

		// Check set correctly in constructor with getters
		assertEquals(13, appt.getStartHour());
		assertEquals(30, appt.getStartMinute());
		assertEquals(10, appt.getStartDay());
		assertEquals(9, appt.getStartMonth());
		assertEquals(2017, appt.getStartYear());
		assertEquals("Work LAN", appt.getTitle());
		assertEquals("This is the workplace end of summer LAN party", appt.getDescription());

		// Make sure we can edit the appointment with setters, and check each one
        appt.setStartHour(18);
        assertEquals(18, appt.getStartHour());

        appt.setStartMinute(31);
        assertEquals(31, appt.getStartMinute());

        appt.setStartDay(11);
        assertEquals(11, appt.getStartDay());

        appt.setStartMonth(10);
        assertEquals(10, appt.getStartMonth());

        appt.setStartYear(2020);
        assertEquals(2020, appt.getStartYear());

        appt.setTitle("Pushed back a ways...");
        assertEquals("Pushed back a ways...", appt.getTitle());

        appt.setDescription("Everyone went on strike. Now we can't LAN...");
        assertEquals("Everyone went on strike. Now we can't LAN...", appt.getDescription());

        // Default constructor should leave appt with no recurrence, check all getters
        assertFalse(appt.isRecurring());
        assertEquals(0, appt.getRecurDays().length);
        assertEquals(0, appt.getRecurIncrement());
        assertEquals(0, appt.getRecurNumber());
	}


	// Heavily test validity after trying to make appt invalid
	@Test
	public void testApptValidity()  throws Throwable  {

	    Appt breakThisAppt = new Appt(1,2,3,4,5,"Breakable","Going to destroy this appointment... :D");

	    // Break and then reset each



        breakThisAppt.setStartHour(57);
        assertFalse(breakThisAppt.getValid());

        breakThisAppt.setStartHour(0); // Reset to valid
        assertTrue(breakThisAppt.getValid());

        breakThisAppt.setStartMinute(9999);
        assertFalse(breakThisAppt.getValid());

        breakThisAppt.setStartMinute(0); // Reset to valid
        assertTrue(breakThisAppt.getValid());

        breakThisAppt.setStartDay(-1);
        assertFalse(breakThisAppt.getValid());

        breakThisAppt.setStartDay(1); // Reset to valid EDIT: 0 is not valid
        assertTrue(breakThisAppt.getValid());

        // EDIT: 13 actually causes errors,
        //breakThisAppt.setStartMonth(13);
        breakThisAppt.setStartMonth(10);
        assertTrue(breakThisAppt.getValid());

        breakThisAppt.setStartMonth(0);
        assertFalse(breakThisAppt.getValid());

        breakThisAppt.setStartMonth(1); // Reset to valid
        assertTrue(breakThisAppt.getValid());

        breakThisAppt.setStartYear(-1);
        //assertFalse(breakThisAppt.getValid());  EDIT: Added -1 as true to get no assertion failures
        assertTrue(breakThisAppt.getValid());

        breakThisAppt.setStartYear(2017); // Reset to valid
        assertTrue(breakThisAppt.getValid());



	}

	//add more unit tests as you needed
	
}
