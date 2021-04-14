package com.smoothstack.weekone.weekend;

import static org.junit.Assert.*;

import org.junit.Test;

public class SampleSingletonTest {

	@Test
	public void testGetInstance() {
		SampleSingleton singleton = SampleSingleton.getInstance();
		SampleSingleton singleton2 = SampleSingleton.getInstance();

		assertSame(singleton, singleton2);
	}

}
