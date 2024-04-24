package sit707_tasks;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

public class DateUtilTest {
	
	@Test
	public void testStudentIdentity() {
		String studentId = "222590652";
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Wenzong Xuan";
		Assert.assertNotNull("Student name is null", studentName);
	}

	@Test
	public void testMaxJanuary31ShouldIncrementToFebruary1() {
		// January max boundary area: max+1
		DateUtil date = new DateUtil(31, 1, 2024);
        System.out.println("january31ShouldIncrementToFebruary1 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(1, date.getDay());
	}
	
	@Test
	public void testMaxJanuary31ShouldDecrementToJanuary30() {
		// January max boundary area: max-1
		DateUtil date = new DateUtil(31, 1, 2024);
        System.out.println("january31ShouldDecrementToJanuary30 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(30, date.getDay());
        Assert.assertEquals(1, date.getMonth());
	}
	
	@Test
	public void testNominalJanuary() {
		int rand_day_1_to_31 = 1 + new Random().nextInt(31);
        DateUtil date = new DateUtil(rand_day_1_to_31, 1, 2024);
        System.out.println("testJanuaryNominal > " + date);
        date.increment();
        System.out.println(date);
	}
	
	/*
	 * Complete below test cases.
	 */
	
	@Test
	public void testMinJanuary1ShouldIncrementToJanuary2() {
		DateUtil date = new DateUtil(1, 1, 2024);
	    System.out.println("January1ShouldIncrementToJanuary2 >" + date);
	    date.increment();
	    System.out.println(date);
	    Assert.assertEquals(1, date.getMonth());
	    Assert.assertEquals(2, date.getDay());
	}
	
	@Test
	public void testMinJanuary1ShouldDecrementToDecember31() {
		DateUtil date = new DateUtil(1, 1, 2024);
	    System.out.println("January1ShouldDecrementToDecember31 >" + date);
	    date.decrement();
	    System.out.println(date);
	    Assert.assertEquals(12, date.getMonth());
	    Assert.assertEquals(31, date.getDay());
	    Assert.assertEquals(2023, date.getYear());
	}
	
	// Equivalence Class Testing
	@Test
    public void testCommonDaysIncrementAndDecrement() { 
        //D1 class testing (Days 1-28 (common to all months))
        for (int day = 1; day <= 28; day++) {
            DateUtil date = new DateUtil(day, 3, 2024);
            date.increment();
            Assert.assertEquals(day + 1, date.getDay());
            date.decrement();
            Assert.assertEquals(day, date.getDay());
        }
    }
	
	@Test
    public void testDay29IncrementAndDecrement() {
        //D2 class testing (Day 29 (applicable only in February and months with 30 days))
        DateUtil leapFeb = new DateUtil(29, 2, 2024);
        leapFeb.increment();
        Assert.assertEquals(1, leapFeb.getDay());
        Assert.assertEquals(3, leapFeb.getMonth());
        leapFeb.decrement();
        Assert.assertEquals(29, leapFeb.getDay());
        Assert.assertEquals(2, leapFeb.getMonth());
	}
	
	@Test
    public void testDay30IncrementAndDecrement() {
        //D3 class testing (Day 30 (not applicable to February))
        DateUtil april30 = new DateUtil(30, 4, 2024);
        april30.increment();
        Assert.assertEquals(1, april30.getDay());
        Assert.assertEquals(5, april30.getMonth());
        april30.decrement();
        Assert.assertEquals(30, april30.getDay());
        Assert.assertEquals(4, april30.getMonth());
    }

	@Test
    public void testDay31IncrementAndDecrement() {
        //D4 class testing (Day 31 (applicable only to months with 31 days))
        DateUtil jan31 = new DateUtil(31, 1, 2024);
        jan31.increment();
        Assert.assertEquals(1, jan31.getDay());
        Assert.assertEquals(2, jan31.getMonth());
        jan31.decrement();
        Assert.assertEquals(31, jan31.getDay());
        Assert.assertEquals(1, jan31.getMonth());
    }

	@Test
	public void testFebruaryNonLeapYear() {
		// invalid date (leap year)
	    new DateUtil(29, 2, 2023); 
	}
	
	@Test
	public void testInvalidDateApril31() {
        // invalid date (month without 31 days)
        new DateUtil(31, 4, 2024);
    }
    
	@Test
    public void testNonLeapYear() {
        //Y1 class testing (non-leap year)
        DateUtil commonYearFeb = new DateUtil(28, 2, 2023);
        commonYearFeb.increment();
        Assert.assertEquals(1, commonYearFeb.getDay());
        Assert.assertEquals(3, commonYearFeb.getMonth());
    }
	
	public void testLeapYear() {
		//Y2 class testing (leap year)
		DateUtil leapYearFeb = new DateUtil(28, 2, 2024);
		leapYearFeb.increment();
		Assert.assertEquals(29, leapYearFeb.getDay());
		Assert.assertEquals(2, leapYearFeb.getMonth());
	}
}
