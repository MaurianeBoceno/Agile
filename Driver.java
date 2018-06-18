package main;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.UIManager;

public class Driver 
{
	//public Scanner scan;
	public static GuiModel model;
	Reader reader;
	
}
	public static void main(String[] args)
	{
		Driver app = new Driver();

	
	
	public Driver()
	{
		reader = new Reader();
		try 
		{
			reader.readTextFile("large-database.txt");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		setMotherAndFather(reader.getPeople());
		setChildren(reader.getPeople());
		setSiblings(reader.getPeople());
		
		setUpGUI();

		
	}
	
	public void setUpGUI()
	{
		model = new GuiModel();
		model.getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		model.getFrame().setVisible(true);
		model.getSearchButton().addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				String input = capitaliseWord(model.textfield.getText()); 
				try
				{
					if(input.equals(reader.getPeople().get(input).getName()))
					{
						model.output.setText(reader.getPeople().get(input).toString());
						model.nameOutput.setText(reader.getPeople().get(input).getName());
						model.fnameOutput.setText(reader.getPeople().get(input).getFname());
						model.genderOutput.setText(Character.toString(reader.getPeople().get(input).getGender()));
						model.dobOutput.setText(Integer.toString(reader.getPeople().get(input).getDateOfBirth()));
						model.dodOutput.setText(Integer.toString(reader.getPeople().get(input).getDateOfDeath()));
						model.motherOutput.setText(reader.getPeople().get(input).getMother());
						model.fatherOutput.setText(reader.getPeople().get(input).getFather());
					}
				}
				catch(Exception ex)
				{
					System.out.println("Invalide");
				}
			}
		});
		
		model.button.addActionListener(new ActionListener()
		{
			@Override
		    public void actionPerformed(ActionEvent e)
		    {
		        model.createFrame();
		        EventQueue.invokeLater(new Runnable() 
		        {

					@Override
					public void run() 
					{
			            model.addButton.addActionListener(new ActionListener()
			            {
			    			@Override
			    			public void actionPerformed(ActionEvent e) 
			    			{
			    				addPerson();
			    			}
			            });
					}
		        });
		    }
		});
	}
	
	/**
	 * Methode pour ajouter une personne au programme
	 */
	private void addPerson()
	{
		String name = null, mother = null, father = null;
		char gender = 0;
		int dob = -1;
		int dod = -1;
		
		//Recuperer le prénom 
		try
		{
			name = capitaliseWord(model.nameField.getText());
		}
		catch(Exception exc)
		{
			System.err.println("Invalide, s'il vous plaît entrez une Prenom");
		}
		
		// Recuperer le nom de famille
		try
		{
			name = capitaliseWord(model.fnameField.getText());
		}
		catch(Exception exc)
		{
			System.err.println("Invalide, s'il vous plaît entrez un nom de famille");
		}
		
		// Recuperer le sexe
		try
		{
			gender = capitaliseWord(model.genderField.getText()).charAt(0);
			if(gender == 'H' || gender == 'h' || gender== 'F' || gender == 'f')
			{
				gender = model.genderField.getText().charAt(0);
			}
			else
			{
				System.err.println("Invalide, sexe incorrecte");
			}
		}
		catch(Exception exc)
		{
			System.err.println("Entrez un sexe correcte (H/F)");
		}
	
		//Recuperer la date de naissance
		try
		{
			dob = Integer.parseInt(model.dobField.getText());
		}
		catch(Exception exc)
		{
			System.err.println("Invalide, entrez une année de naissance correcte");
		}
		
		// Recuperer la date de mort
				try
				{
					dod = Integer.parseInt(model.dodField.getText());
				}
				catch(Exception exc)
				{
					System.err.println("Invalide, entrez une année de mort correcte");
				}
				
		//Recuperer la mère
		try
		{
			mother = capitaliseWord(model.motherField.getText());
		}
		catch(Exception exc)
		{
			System.err.println("Nom de mère invalide");
		}
		
		//Recuperer le père
		try
		{
			father = capitaliseWord(model.fatherField.getText());
		}
		catch(Exception exc)
		{
			System.err.println("Nom de père invalide");
		}
		
		//Ajouter une personne à l'arbre
		if(name != null && gender != 0 && dob != -1 && dod != -1 && mother != null && father != null)
		{
			Person person = new Person(name, father, gender, dob, dod, mother, father);
			reader.getPeople().put(person.getName(), person);
			setMotherAndFather(reader.getPeople());
			setChildren(reader.getPeople());
			setSiblings(reader.getPeople());
			System.out.println("Personne ajouter à l'arbre");
		}
		else
		{
			System.err.println("Impossible de creer la personne");
		}
	}
	
	
	private String capitaliseWord(String word)
	{
		return new String (word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase());
	}
	
	
	public void setChildren(HashMap<String, Person> people)
	{
		Person[] persons = people.values().toArray(new Person[people.size()]); 
		for (int i = 0; i < persons.length; i++) 
		{
			if(persons[i].hasMother())
			{
				persons[i].getpMother().addChildren(persons[i]); //ajoute l'enfant à la mère
			}
			if(persons[i].hasFather())
			{
				persons[i].getpFather().addChildren(persons[i]); // ajoute l'enfant au père
			}
		}
	}
	
	
	/**
	 * configure le père et la mère 
	 * @param people
	 */
	public void setMotherAndFather(HashMap<String, Person> people)
	{	
		Person[] persons = people.values().toArray(new Person[people.size()]);
		for (int i = 0; i < persons.length; i++) 
		{
			for (int j = 0; j< persons.length; j++) 
			{
				if (persons[i].getMother().equalsIgnoreCase(persons[j].getName())) 
				{
					persons[i].setpMother(persons[j]);
				}
				if (persons[i].getFather().equalsIgnoreCase(persons[j].getName()))
				{
					persons[i].setpFather(persons[j]);
				}
		  	}
		}
	}
	
	/**
	 * configure les frères et soeurs
	 * @param people
	 */
	public void setSiblings(HashMap<String, Person> people)
	{
		Person[] persons = people.values().toArray(new Person[people.size()]);
		for (int i = 0; i < persons.length; i++) 
		{
			for (int j = 0; j< persons.length; j++) 
			{
				if(persons[i].hasMother() && persons[j].hasMother()) // si les deux ont une mère
				{
					if(persons[i].getMother().equals(persons[j].getMother())) // si les deux mère sont identiques
						if(!persons[i].getSiblings().contains(persons[j])) //si elles n'existent pas
							persons[i].addSibling(persons[j]); //ajouter la personne
				}
				
				if(persons[i].hasFather() && persons[j].hasFather()) //si les deux ont un père
				{
					if(persons[i].getFather().equals(persons[j].getFather())) // si les deux pères sont identiques
						if(!persons[i].getSiblings().contains(persons[j])) //si ils n'existent pas
							persons[i].addSibling(persons[j]);
				}
			}
		}
	}
	
	
	public Node addNodes(Person person)
	{
		Node root = new Node(person, null, null);
		if(person.hasMother())
		{
			root.left = (new Node(person.getpMother(), null, null));
		}
		if(person.hasFather())
		{
			root.right = (new Node(person.getpFather(), null, null));
		}
		return root;
	}
	
}
