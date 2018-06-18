package main;

import java.io.Serializable;

public class Node implements Comparable<Object>, Serializable
{
		
	private static final long serialVersionUID = -6892115297305177548L;
	Node left, right;
	Person person;

	public Node(Person person, Node left, Node right)
	{
		this.person = person;
	    this.left = left;
	    this.right = right;
	}
	    
	@Override
	public String toString()
	{
	    return person.toString(); 
	}
	    
	public boolean isLeaf()
	{
	    return left == null && right == null;
	}

	@Override
	public int compareTo(Object node) 
	{
		return person.getDateOfBirth() - ((Node) node).person.getDateOfBirth();
	}
	
	
	
}