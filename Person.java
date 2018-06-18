package main;

import java.util.ArrayList;

public class Person
{
	private String fname;
	private String name;
	private char gender;
	private int dateOfBirth;
	private int dateOfDeath;
	private String mother;
	private String father;
	private Person pMother;
	private Person pFather;
	private ArrayList<Person> children;
	private ArrayList<Person> siblings;
	
	public Person(String name, String fname, char gender, int dateOfBirth, int dateOfDeath, String mother, String father)
	{
		this.fname = fname;
		this.name = name;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.dateOfDeath = dateOfDeath;
		this.mother = mother;
		this.father = father;
		children = new ArrayList<Person>();
		siblings = new ArrayList<Person>();
	}
	
	public Person(String name, String fname, char gender, int dateOfBirth,int dateOfDeath, Person pMother, Person pFather)
	{
		this.fname = fname;
		this.name = name;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.dateOfDeath = dateOfDeath;
		this.pMother = pMother;
		this.pFather = pFather;
		children = new ArrayList<Person>();
		siblings = new ArrayList<Person>();
	}

	public ArrayList<Person> getSiblings() 
	{
		return siblings;
	}

	public void setSiblings(ArrayList<Person> siblings) 
	{
		this.siblings = siblings;
	}

	public void addSibling(Person sibling)
	{
		siblings.add(sibling);
	}
	
	public void addChildren(Person child)
	{
		children.add(child);
	}
	
	public String getFname() {
		return fname;
	}
	public void setFname(String fname){
		this.fname = fname;
	}
	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public char getGender() 
	{
		return gender;
	}

	public void setGender(char gender) 
	{
		this.gender = gender;
	}

	public int getDateOfBirth() 
	{
		return dateOfBirth;
	}

	public void setDateOfBirth(int dateOfBirth) 
	{
		this.dateOfBirth = dateOfBirth;
	}
	
	public int getDateOfDeath() 
	{
		return dateOfDeath;
	}

	public void setdateOfDeath(int dateOfDeath) 
	{
		this.dateOfDeath = dateOfDeath;
	}

	public String getMother() 
	{
		return mother;
	}

	public void setMother(String mother) 
	{
		this.mother = mother;
	}

	public String getFather() 
	{
		return father;
	}

	public void setFather(String father) 
	{
		this.father = father;
	}

	public Person getpMother() 
	{
		return pMother;
	}

	public void setpMother(Person pMother) 
	{
		this.pMother = pMother;
	}

	public Person getpFather() 
	{
		return pFather;
	}

	public void setpFather(Person pFather) 
	{
		this.pFather = pFather;
	}

	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}

	public ArrayList<Person> getChildren()
	{
		return children;
	}
	
	public Person getChildAtIndex(int index)
	{
		return children.get(index);
	}
	
	public void setChildren(ArrayList<Person> children)
	{
		this.children = children;
	}
	
	public boolean hasMother()
	{
		if(this.getpMother() != null)
			return true;
		return false;
	}
	
	public boolean hasFather()
	{
		if(this.getpFather() != null)
			return true;
		return false;
	
	}

public void setSiblings2(ArrayList<Person> siblings) 
	{
		this.siblings = siblings;
	}

	}

    

