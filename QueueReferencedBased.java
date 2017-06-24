package Queue;
import Stack.StackReferenceBased;

public class QueueReferencedBased implements QueueInterface{
	
	private Node lastNode;
	
	public QueueReferencedBased(){
		lastNode = null;
	}
	
	public boolean isEmpty(){
		return lastNode == null;
	}
	
	public void dequeueAll(){
		lastNode = null;
	}
	
	public void enqueue(Object newItem){
		Node newNode = new Node(newItem);
		if (isEmpty()) {
			newNode.next = newNode;
		}
		else {
			newNode.next = lastNode.next;
			lastNode.next = newNode;
		}
		
		lastNode = newNode;
	}

	public Object dequeue() throws QueueException {
		
		if(!isEmpty()) {
			Node firstNode = lastNode.next;
			
			if(firstNode == lastNode)
			{
				lastNode = null;
			}
			else 
			{
				lastNode.next = firstNode.next;
			}
			return firstNode.item;
		}
		else 
		{
			throw new QueueException("QueueException on dequeue: queue empty");
		}
	}
	
	public Object peek() throws QueueException {
		if(!isEmpty()) {
			Node firstNode = lastNode.next;
			return firstNode.item;
		}
		else 
		{
			throw new QueueException("QueueException on peek: queue empty");
		}		
	}
	
	public boolean isPal(String str){
		boolean is = true;
		
		StackReferenceBased stack = new StackReferenceBased();
		QueueReferencedBased queue = new QueueReferencedBased();
		
		for(int i = 0; i < str.length();i++){
			stack.push((Character) str.charAt(i));
			
			queue.enqueue((Character) str.charAt(i));
		}
		
		while(!stack.isEmpty() && !queue.isEmpty() && is != false){
			if((Character)stack.pop() != (Character)queue.dequeue()){
			 is = false;
			}
		}
		return is;
		}
}
