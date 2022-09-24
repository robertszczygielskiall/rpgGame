package com.eclipse.ec;

import java.util.List;

public class FizzBuzzService {
	
	private NumbersRepository numbersRepository;
	
	public FizzBuzzService() {}

	public FizzBuzzService(NumbersRepository numbersRepository) {
		this.numbersRepository = numbersRepository;
	}
	
	public List<String> mapFromRepository() {
		List<Integer> numbers = numbersRepository.getNumbersToMap();
		return map(numbers);
	}

	public List<String> map(List<Integer> numbers) {
		List<String> result = numbers.stream().map(number -> {

			StringBuilder builder = new StringBuilder();
			if (number % 3 == 0)
				builder.append("Fizz");
			if (number % 5 == 0)
				builder.append("Buzz");

			return builder.isEmpty() ? number + "" : builder.toString();
		}).toList();

		return result;

	}

}
