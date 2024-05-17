package demoParalelismo;

public class CustomLinkedList<T> 
{
	private Node<T> start;
	private Node<T> end;
	public static final char separator = '_';
	
	public synchronized void Add(T data)
	{
		Node<T> newNode = new Node<T>(data);
		
		if(start == null)
		{
			start = newNode;
		}
		else
		{
			end.setNext(newNode);
		}
		
		end = newNode;
	}

	@Override
	public String toString() 
	{
		var text = new StringBuilder();
		
		var current = start;
		
		while(current != null)
		{
			text.append(current.getData());
			text.append(separator);
			current = current.getNext();
		}
		
		return text.toString();
	}
}