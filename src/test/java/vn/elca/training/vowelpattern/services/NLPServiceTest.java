package vn.elca.training.vowelpattern.services;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import vn.elca.training.vowelpattern.services.exceptions.InvalidInputException;
import vn.elca.training.vowelpattern.utils.Testcase;

@ContextConfiguration(locations = {"classpath:spring_context/test_context.xml"})
public class NLPServiceTest extends AbstractTestNGSpringContextTests {
	
	@Autowired
	private NLPService nlpService;
	
	@Resource(name="basicTests")
	private List<Testcase> basicTestcases;

	@Test
	public void testProvidedTestcases() throws InvalidInputException {
		for (Testcase testcase : basicTestcases) {
			boolean expectValue = testcase.getExpectedValue();
			boolean result = nlpService.sameVowelPatternOfLongWord(
					testcase.getFirst(), testcase.getSecond());
			Assert.assertTrue(!(expectValue ^ result), testcase.toString());
		}
	}
}
