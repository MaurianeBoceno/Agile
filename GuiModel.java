package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;


public class GuiModel implements ActionListener
{
	public JLabel label, nameLabel,fnameLabel, genderLabel, dobLabel, dodLabel, motherLabel, fatherLabel;  
	public JButton searchButton, button, addButton; 
	public JTextField textfield; 
	public JTextArea output, nameOutput,fnameOutput, genderOutput, dobOutput,dodOutput, motherOutput, fatherOutput, empty; //first frame text area
	public JTextField nameField,fnameField, genderField, dobField,dodField, motherField, fatherField;
	public JLabel pNameLabel,pfnameLabel, pGenderLabel, pDoBLabel,pdodLabel, pMotherLabel, pFatherLabel;
	private JPanel panel, inputpanel;
	private JFrame frame;

	public Reader reader;
	
	public GuiModel() // Interface Principale 
	{
		frame = new JFrame();
		frame.setLayout(new FlowLayout());
		frame.setTitle("Arbre Genealogique");
		label = new JLabel("Rechercher une personne");
		frame.add(label);
		
		textfield = new JTextField(20);
		
		frame.add(textfield);
		
		searchButton = new JButton();
		searchButton.setText("Recherche ...");
		frame.add(searchButton);
		
		// Sortie generale
		output = new JTextArea(1,25);
		output.setEditable(false);
		output.setLineWrap(true);
		output.setWrapStyleWord(true);
		frame.add(output);
		
		// Sortie Prenom
		nameLabel = new JLabel("Prenom");
		frame.add(nameLabel);
		nameOutput = new JTextArea(1,25);
		nameOutput.setEditable(false);
		nameOutput.setLineWrap(true);
		nameOutput.setWrapStyleWord(true);
		frame.add(nameOutput);
		
		// Sortie Nom de Famille
				fnameLabel = new JLabel("Nom de Famille");
				frame.add(fnameLabel);
				fnameOutput = new JTextArea(1,25);
				fnameOutput.setEditable(false);
				fnameOutput.setLineWrap(true);
				fnameOutput.setWrapStyleWord(true);
				frame.add(fnameOutput);
		
		//Sortie Sexe
		genderLabel = new JLabel("Sexe");
		frame.add(genderLabel);
		genderOutput = new JTextArea(1,25);
		genderOutput.setEditable(false);
		genderOutput.setLineWrap(true);
		genderOutput.setWrapStyleWord(true);
		frame.add(genderOutput);
		
		// Sortie date de naissance
		dobLabel = new JLabel("Date de naissance");
		frame.add(dobLabel);
		dobOutput = new JTextArea(1,25);
		dobOutput.setEditable(false);
		dobOutput.setLineWrap(true);
		dobOutput.setWrapStyleWord(true);
		frame.add(dobOutput);
		
		dodLabel = new JLabel("Date de deces");
		frame.add(dodLabel);
		dodOutput = new JTextArea(1,25);
		dodOutput.setEditable(false);
		dodOutput.setLineWrap(true);
		dodOutput.setWrapStyleWord(true);
		frame.add(dodOutput);
		
		// Sortie Mère
		motherLabel = new JLabel("Mère");
		frame.add(motherLabel);
		motherOutput = new JTextArea(1,25);
		motherOutput.setEditable(false);
		motherOutput.setLineWrap(true);
		motherOutput.setWrapStyleWord(true);
		frame.add(motherOutput);
		
		// Sortie Père
		fatherLabel = new JLabel("Père");
		frame.add(fatherLabel);
		fatherOutput = new JTextArea(1,25);
		fatherOutput.setEditable(false);
		fatherOutput.setLineWrap(true);
		fatherOutput.setWrapStyleWord(true);
		frame.add(fatherOutput);
		
		// Ajout d'une personne
		frame.setSize(300,500);
		button = new JButton("Ajouter une personne");
		frame.add(button);
		frame.setResizable(false);
	
		
        try 
        {
           UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } 
        catch (Exception e) 
        {
           e.printStackTrace();
        }

        
	}
	
	public void createFrame()
    {
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
            	//reader = new Reader();
                JFrame frame = new JFrame("Ajouter une personne");
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                try 
                {
                   UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception e) {
                   e.printStackTrace();
                }
                panel = new JPanel();
                panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
                panel.setOpaque(true);
                inputpanel = new JPanel();
                inputpanel.setLayout(new FlowLayout());
                // Demande des informations sur la nouvelle personne a créer 
                pNameLabel = new JLabel("Prenom");
                panel.add(pNameLabel);
                nameField = new JTextField(15);
                panel.add(nameField);
                 pNameLabel = new JLabel("Nom de famille");
                panel.add(pfnameLabel);
                fnameField = new JTextField(15);
                panel.add(fnameField);
                
                pGenderLabel = new JLabel("Sexe (H/F)");
                panel.add(pGenderLabel);
                genderField = new JTextField(1);
                panel.add(genderField);
                
                pDoBLabel = new JLabel("Date de naissance");
                panel.add(pDoBLabel);
                dobField = new JTextField(20);
                panel.add(dobField);
                
                pdodLabel = new JLabel("Date de deces");
                panel.add(pdodLabel);
                dodField = new JTextField(20);
                panel.add(dodField);
                
                pMotherLabel = new JLabel("Mère");
                panel.add(pMotherLabel);
                motherField = new JTextField(20);
                panel.add(motherField);
                
                pFatherLabel = new JLabel("Père");
                panel.add(pFatherLabel);
                fatherField = new JTextField(20);
                panel.add(fatherField);
                // ajoute la personne à la base de données
                addButton = new JButton("Ajouter Personne");
        		
                inputpanel.add(addButton);
                panel.add(inputpanel);
                frame.getContentPane().add(BorderLayout.CENTER, panel);
                frame.pack();
                frame.setLocationByPlatform(true);
                frame.setVisible(true);
                frame.setResizable(false);
                
            }
        });
    }

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		
	}
	
	public JButton getSearchButton()
	{
		return searchButton;
	}
	
	public JFrame getFrame()
	{
		return frame;
	}
	
	
	
}
