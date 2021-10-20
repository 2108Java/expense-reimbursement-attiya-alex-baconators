package com.revature.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.revature.models.Request;
import com.revature.repo.ReimbursementDAOImplimentation;

public class ReimbursementDAOTest {
	
	@Mock
	private ReimbursementDAOImplimentation rd;
	
	@Before
	public void setup() {
		
		rd = mock(ReimbursementDAOImplimentation.class);
		
	}
	
	@Test
	public void testGetRequestByType() {
		
		List<Request> testList = new ArrayList<>();
		
		testList.add(new Request(1234, "approved", "lodging", "Business Trip", 100));
		testList.add(new Request(4567, "pending", "lodging", "Business Trip", 100));
		testList.add(new Request(2222, "rejected", "food", "Business Trip", 100));
		
		when(rd.getRequestByType("lodging", 1234)).thenReturn(testList.get(0));
		
	}

}
