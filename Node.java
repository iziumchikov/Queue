package Queue;

public class Node {
	
	public Object item;
	public Node next;
	
	public Node(Object newItem) {
		 
		item = newItem;
		next = null;
	}
	
	public Node(Object newItem, 
				Node nextNode) {

		item = newItem;
		next = nextNode;
	}
}

