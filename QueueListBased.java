package Queue;

public class QueueListBased implements QueueInterface {
	
	private ListInterface aList;
	
	public QueueListBased() {
		aList = new ListReferenceBased();
	}
	
	public boolean isEmpty() {
		return aList.isEmpty();
	}
	
	public void enqueue(Object newItem) {
		aList.add(aList.size(), newItem);
	}
	
	public Object dequeue() throws QueueException {
		if(!isEmpty()) {
			Object queueFront = aList.get(0);
			aList.remove(0);
			return queueFront;
		}
		
		else {
			throw new QueueException(" Queue exception on dequeue: queue empty");
		}
	}
	
	public void dequeueAll() {
		aList.removeAll();
	}
	
	public Object peek() throws QueueException {
		if(!isEmpty()) {
			return aList.get(0);
		}
		else {
			throw new QueueException(" Queue exception on peek: queue empty");
		}
	}
}
