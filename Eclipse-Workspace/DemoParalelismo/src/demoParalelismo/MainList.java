package demoParalelismo;

import java.util.stream.IntStream;

public class MainList 
{
	public static void main(String[] args) 
	{		
		int n = 50;
		
		for (int j = 0; j < 20; j++) 
		{
			CustomLinkedList<Integer> myList = new CustomLinkedList<Integer>();
			
			IntStream.range(1, n + 1).parallel().forEach((i) -> 
			{
				myList.Add(i);
			});
			
			IntStream.range(1, n / 3 + 1).parallel().forEach((i) -> 
			{
				System.out.println(myList);
			});
		}
	}
}