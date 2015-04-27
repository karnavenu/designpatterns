package com.practice.dp.employee;

import junit.framework.JUnit4TestAdapter;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class EmployeeJUnitTest{
	
	public static junit.framework.Test suite() {
		return new JUnit4TestAdapter(EmployeeJUnitTest.class);
	}

    /**
     * @throws java.lang.Exception
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    	System.out.println("test");
    }

    /**
     * @throws java.lang.Exception
     */
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    	System.out.println("test");
    }

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
    	System.out.println("test");
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
    	System.out.println("test");
    }

    /**
     * Create Employee API test
     */
    @Test
    public void creatEmployeeAPITest() throws Exception {
    	System.out.println("test");
    }

    /**
     * Get employee API test
     */
    @Test
    public void api() throws Exception {
    	int i = 0;
    	System.out.println("test"+i);
    }
}
