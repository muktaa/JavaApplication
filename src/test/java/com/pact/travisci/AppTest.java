package com.pact.travisci;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import com.pact.travisci.App;

/**
 * Unit test for simple App.
 */
public class AppTest {

	@Test
	public void testApp() {
		String[] args = {"http://blog.travis-ci.org"};
		Assert.assertThat(App.getPageSource(args[0]), CoreMatchers.containsString("<title>The Travis CI Blog</title>"));
	}
}
