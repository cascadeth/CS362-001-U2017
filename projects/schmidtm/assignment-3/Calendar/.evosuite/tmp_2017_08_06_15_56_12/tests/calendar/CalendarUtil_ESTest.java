/*
 * This file was automatically generated by EvoSuite
 * Sun Aug 06 22:57:44 GMT 2017
 */

package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import calendar.CalendarUtil;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true) 
public class CalendarUtil_ESTest extends CalendarUtil_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      boolean boolean0 = CalendarUtil.IsLeapYear((-1129));
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      int int0 = CalendarUtil.NumDaysInMonth((-1336), 2);
      assertEquals(31, int0);
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      int[] intArray0 = new int[1];
      CalendarUtil.DaysInMonth = intArray0;
      int int0 = CalendarUtil.NumDaysInMonth(0, 0);
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      int[] intArray0 = new int[4];
      intArray0[1] = Integer.MIN_VALUE;
      CalendarUtil.DaysInMonth = intArray0;
      int int0 = CalendarUtil.NumDaysInMonth(1510, 1);
      assertEquals(Integer.MIN_VALUE, int0);
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      CalendarUtil.DaysInMonth = null;
      // Undeclared exception!
      try { 
        CalendarUtil.NumDaysInMonth(3, 0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         assertThrownBy("calendar.CalendarUtil", e);
      }
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      // Undeclared exception!
      try { 
        CalendarUtil.NumDaysInMonth(100, 31);
        fail("Expecting exception: ArrayIndexOutOfBoundsException");
      
      } catch(ArrayIndexOutOfBoundsException e) {
         //
         // 31
         //
         assertThrownBy("calendar.CalendarUtil", e);
      }
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      boolean boolean0 = CalendarUtil.IsLeapYear((-1900));
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      boolean boolean0 = CalendarUtil.IsLeapYear(0);
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      boolean boolean0 = CalendarUtil.IsLeapYear(28);
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      int int0 = CalendarUtil.NumDaysInMonth(0, 1);
      assertEquals(29, int0);
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      int int0 = CalendarUtil.NumDaysInMonth(100, 0);
      assertEquals(31, int0);
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      CalendarUtil calendarUtil0 = new CalendarUtil();
      assertEquals(1, CalendarUtil.FEBRUARY);
  }
}
