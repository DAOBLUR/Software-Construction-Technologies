package demoParalelismo;

import java.util.stream.IntStream;

public class MainStreams {
	public static void main(String [] args) 
	{
		int n = 5;
		IntStream.range(1, n + 1).parallel().forEach((number)-> 
		{
			System.out.println(number);
		});
	}
}