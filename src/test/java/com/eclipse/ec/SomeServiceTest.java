package com.eclipse.ec;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class SomeServiceTest {

	private FizzBuzzService fb = new FizzBuzzService();

	@Test
	public void shoulReturn1For1() {
		// given
		int one = 1;

		// when
		List<String> result = fb.map(Arrays.asList(one));

		// then
		assertEquals("1", result.get(0));
	}

	@Test
	public void shoulReturnFizzFor3() {
		// given
		int three = 3;

		// when
		List<String> result = fb.map(Arrays.asList(three));

		// then
		assertEquals("Fizz", result.get(0));
	}

	@Test
	public void shoulReturnBuzzFor5() {
		// given
		int five = 5;

		// when
		List<String> result = fb.map(Arrays.asList(five));

		// then
		assertEquals("Buzz", result.get(0));
	}

	@Test
	public void shoulReturnFizzBuzzFor15() {
		// given
		int fifteen = 15;

		// when
		List<String> result = fb.map(Arrays.asList(fifteen));

		// then
		assertEquals("FizzBuzz", result.get(0));
	}

	@ParameterizedTest(name = "FizzBuzz for {0}")
	@ValueSource(ints = { 15, 30, 60 })
	public void shoulReturnListWithFizzBuzzForSomeNumbers(int number) {
		// given

		// when
		List<String> result = fb.map(Arrays.asList(number));

		// then
		assertEquals("FizzBuzz", result.get(0));
	}

	@Test
	public void regexTest1() {
		Pattern pattern = Pattern.compile("Sii", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher("Kurs Sii z Javy");
		boolean matchFound = matcher.find();
		if (matchFound) {
			System.out.println("Match found");
		} else {
			System.out.println("Match not found");
		}
	}

	@Test
	public void regexTest2() {
		String paternToFind = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
		Pattern pattern = Pattern.compile(paternToFind, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher("JakisAdres@mail.complpl");
		boolean matchFound = matcher.find();
		if (matchFound) {
			System.out.println("Email found");
		} else {
			System.out.println("Email not found");
		}
	}

}
