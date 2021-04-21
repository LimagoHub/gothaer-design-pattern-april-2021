package de.collections;

import java.util.ArrayList;
import java.util.List;

public class Stapel {
	
	private final List<Object> data;
	
	
	public Stapel() {
		data = new ArrayList<>();
		
	}
	
	public void push(final Object value) throws StapelException{
		if(isFull()) throw new StapelException("Overflow");
		data.add(value);
	}
	
	public Object pop()throws StapelException{
		if (isEmpty()) throw new StapelException("Underflow");
		return data.remove(data.size() -1);
	}
	
	public boolean isEmpty() {
		return data.isEmpty();
	}
	
	
	public boolean isFull() {
		return false;
	}
	
	

}
