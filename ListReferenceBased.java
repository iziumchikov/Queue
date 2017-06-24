package Queue;

public class ListReferenceBased implements ListInterface {

		private Node head;
		private int numItems;
		
		public ListReferenceBased() {
			
			numItems = 0;
			head = null;
		}
		
		public boolean isEmpty() {
			
			return numItems == 0;
		}
		
		public int size() {
			
			return numItems;
		}

		public void add(int index, Object item)
						throws ListIndexOutOfBoundsException {
			
			if(index >= 0 && index < numItems+1) {
				
				if (index == 0) {
					Node newNode = new Node(item, head);
					head = newNode;
				}
			
				else {
					Node prev = find(index - 1);
					Node newNode = new Node(item, prev.next);
					prev.next = newNode;
				}
			numItems++;
			}
			
			else {
				throw new ListIndexOutOfBoundsException(
						"List index out of bounds on add");
			}
		}
		
		public void insertEnd(Object item){
			Node node = new Node(item);
			if (head == null) 
			{
				head = node;
			} 
			else {
				/*
				 * - Start from the first node - Traverse until the last node is
				 * reached - Make the last node point to the new node
				 */
				Node current = head;
				while (current.next != null) {
					current = current.next;
				}
				current.next = node;
			}
		}

		
		public void remove(int index)
						throws ListIndexOutOfBoundsException {
			if(index >= 1 && index < numItems) {
				
				if(index == 1) {
					head = head.next;
				}
				
				else {
					
					Node prev = find(index - 1);
					Node curr = prev.next;
					prev.next = curr.next;
				}
				numItems--;
			}
			
			else { 
				throw new ListIndexOutOfBoundsException(
						"List index out of bounds on remove");
			}
		}
		
		public void removeAll() {

			head = null;
			numItems = 0;
		}
		
		public Object get(int index) 
				throws ListIndexOutOfBoundsException {
			
			if(index >= 0 && index < numItems) {
				
				Node curr = find(index);
				Object dataItem = curr.item;
				return dataItem;
			}
	
			else {
				throw new ListIndexOutOfBoundsException(
						"List index out of bounds on get");
			}
		}		
		
		private Node find(int index) {
			
			Node curr = head;
			
			for (int skip = 0; skip < index; skip++) {
				curr = curr.next;
			}
			return curr;
		}
		
		//***************************************
		//Replaces each occurrence of oldValue in
		//the list with newValue.
		//returns number of items replaced.
		//***************************************
		public int replace(Object oldValue, Object newValue) {
			
			int result = 0;		//to count number of replaced items
			
			//For loop checks if object in the list is equal to the
			//value to be modified.
			//Loop invariant: curr references the next node of the
			//current list
			for(Node curr = head; curr != null; curr = curr.next) 
			{
				//****************************************
				//Precondition: if current item in a 
				//list equals to the value to be modified.
				//change it to a new value and increment
				//number of replaced items by 1.
				//****************************************
				if(curr.item.equals(oldValue))
				{
					curr.item = new Node(newValue,curr.next); //change old value to a new
					result++; //increase result by one
				}//end if
			}//end for
			
			return result;		//return number of replaced items
		}
		
		//****************************************
		//Returns true if list has the same values
		//in the same order as the current list 
		//object. In other cases return false.
		//****************************************
		public boolean equals(ListReferenceBased list) 
		{
			boolean result = true;
			
			//Node object references to the
			//head of the first list
			Node curr = head;
			
			//For loop compares object in two lists and
			//return result.
			//Loop invariant: currList references the head
			//node of the received list
			for(Node currList = list.head; currList != null; 
					currList = currList.next) 
			{	
				//***************************************
				//Precondition: if object of current list
				//equals to the object in the second list
				//assigns true to the result variable and
				//continues execution.
				//Postcondition: returns false if objects
				//are not equal.
				//***************************************
				if (curr.item.equals(currList.item)) 
				{
					result = true;
				}
				
				else 
				{
					return result = false;
				}//end if
				
				curr = curr.next; //assign next value of a current list
			}//end for
			
			return result; //return boolean value result
		}

		//****************************************
		//toString() method
		//****************************************
		public String toString() {
			
			//new StringBuilder object 
			StringBuilder result = new StringBuilder();
			
				//Loop invariant: curr references the next node of the
				//current list
	       		for (Node curr = head; curr != null; curr = curr.next) 
	       		{
	       			//appends current list node string representation
	       			//to StringBuilder object using Node class 
	       			//toString() method.
	       			result.append("|" + curr.toString() +"|" + "->");
	       		}//end for
	                
	        return result.toString();	//return result StringBuilder object
	        }

	}
		
