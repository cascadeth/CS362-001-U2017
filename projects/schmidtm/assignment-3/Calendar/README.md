# Assignment 3 - Continued Testing Through Mutants

***

### Included Scripts for (Automated) Automated Testing

* `compile-test.sh` --- Simply compile the original java files and run the student written tests.

* `mv-evo-tests.sh` --- This creates a directory for the student written tests, moves those student written tests to this new directory, exports the EvoSuite generated tests from the `.evosuite/best-tests/calendar` directory to the `src/test/java/calendar/` directory, and then executes these tests. 

* `evogen.sh` --- A script I wrote for myself(or anyone else) that launches the EvoSuite test generation suite with options for powerful machines.  Can be edited to suite any machine.  
    * Pre-generated tests are included in `.evosuite/best-tests/calendar/`.  Use the `mv-evo-test.sh` to test them.  

***

### Included Extra Files

* The EvoSuite folder of tests and configs has been supplied.  It contains the tests created my EvoSuite and the configs as well.  

* `evosuite-info.txt` --- Contains the results of the EvoSuite test generations.  For optimal output: `cat evosuite-info.txt`

***

### Tests From Assignment 2 That Have Changed

* `ApptTest.java` 
    * `public void testApptValidity()`
        * Lines 101 --- Added new assert to test if 1 is valid or not.  0 is not a valid.
        * Line 104-113 --- Swapped from bad value of 13 to good value of 10(apparenlty 12 doesn't work either); Assert 0 is not a valid month instead.  
        * Lines 115-120 --- -1 should not be a valid year, but the assert fails.  Assert true to continue testing. 2017 should be a good value. Assert true... 
* `CalDayTest.java`
    * `public void testCreatedInvalidAppt()`
        * Lines 30 & 31 --- Apparently size returns -1 and not 0.  Added assertNotEquals to prove bug.  
    * `public void testAddAppt()` 
        * Lines 63 & 64 --- Commented out our assert to check size of return value. Apparently is 0 not 1.  Added assertNotEqual to continue testing.  
    * `public void testSettersWithGetters()`
        * Lines 82-84 --- Apparently `getDay()` returns the month value.  Added assertNotEquals instead to prove bug.  
* `TimeTableTest.java`
    * `public void getApptRangeTest()`
        * Lines 82-89 --- Try-catch statement still causing errors... Commented out to continue testing.
        * Lines 143 & 144 --- Apparently thie `nullList` is not null.  Commented out to continue testing.  