package com.ozarko.classes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

public class Window extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2291762877213609992L;
	
	private JPanel panel = new JPanel();
	
	private JLabel titleArticle = new JLabel("Title article: ");
	private JTextField titleInput = new JTextField();
	
	private JLabel typeArticle = new JLabel("Type article: ");
	private String[] articles = {"Basic Article", "Article with date", "Article with question", "Article with date and question"};
	private JComboBox<String> type = new JComboBox<String>(articles);
	
	private JLabel description = new JLabel("Description: ");
	private JTextArea descArea = new JTextArea();
	
	private JButton release = new JButton("Release Article");
	private JButton clear = new JButton("Clear");
	private JButton exit = new JButton("Exit");
	
	private JTextArea result = new JTextArea();
	
	//
	
	private JLabel date = new JLabel("Date: ");
	private JTextField dateInput = new JTextField();

	//
	
	private JLabel question = new JLabel("Question: ");
	private JTextArea quesArea = new JTextArea();
	
	public Window(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		
		// Панелька для розміщення елементів
		panel.setLayout(null);
		
		defaultForm();
		
		exit.addActionListener(new ExitActionListener());
		clear.addActionListener(new ClearActionListener());
		release.addActionListener(new ReleaseActionListener());
		type.addItemListener(new TypeChangeListener());
		
		setContentPane(panel);
	}
	
	private void defaultForm() {
		
		setSize(700, 320);
		
		// Label + Input
		titleArticle.setSize(100, 20);
		titleArticle.setLocation(10, 10);
		panel.add(titleArticle);
				
		titleInput.setSize(250, 25);
		titleInput.setLocation(90, 10);
		panel.add(titleInput);
				
		//Label + ComboBox
		typeArticle.setSize(100, 20);
		typeArticle.setLocation(10, 50);
		panel.add(typeArticle);
				
		type.setSelectedItem(0);
		type.setSize(250, 25);
		type.setLocation(90, 50);
		panel.add(type);
				
		// Label + TextArea
		description.setSize(100, 20);
		description.setLocation(10, 100);
		panel.add(description);
				
		descArea.setSize(250, 100);
		descArea.setLocation(90, 100);
		panel.add(descArea);
				
		//buttons
		release.setSize(120, 25);
		release.setLocation(10, 250);
		panel.add(release);
				
		clear.setSize(80, 25);
		clear.setLocation(155, 250);
		panel.add(clear);
				
		exit.setSize(80, 25);
		exit.setLocation(260, 250);
		panel.add(exit);
				
		//big text Area
		result.setSize(320, 265);
		result.setLocation(360, 10);
		panel.add(result);
	}
	
	
	// Вихід
	
	public class ExitActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.exit(0);
		}
		
	}
	
	// Очистка 
	
	public class ClearActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			titleInput.setText(null);
			descArea.setText(null);
			result.setText(null);
			dateInput.setText(null);
			quesArea.setText(null);
		}
		
	}
	
	// Публикація статті
	
	public class ReleaseActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if (type.getSelectedIndex() == 0) {
				BaseArticle base = new BaseArticle(titleInput.getText(), descArea.getText());
				result.setText(null);
				result.append(base.getArticle());
			}
			else if(type.getSelectedIndex() == 1) {
				DateArticle dateArticle = new DateArticle(new BaseArticle(titleInput.getText(), descArea.getText()), dateInput.getText());
				result.setText(null);
				result.append(dateArticle.getArticle());
			} 
			else if (type.getSelectedIndex() == 2) {
				QuestionArticle questionArticle = new QuestionArticle(new BaseArticle(titleInput.getText(), descArea.getText()), quesArea.getText());
				result.setText(null);
				result.append(questionArticle.getArticle());
			}
			else if (type.getSelectedIndex() == 3) {
				DateAndQuestionArticle dateAndQuestionArticle = new DateAndQuestionArticle(new DateArticle(null, dateInput.getText()), new QuestionArticle(new BaseArticle(titleInput.getText(), descArea.getText()), quesArea.getText()));
				result.setText(null);
				result.append(dateAndQuestionArticle.getArticle());
			}
			
		}
		
	}
	
	// Обробник подій для комбо бокса
	
	class TypeChangeListener implements ItemListener{
	    @Override
	    public void itemStateChanged(ItemEvent event) {
	    	
	       switch ((String)type.getSelectedItem()) {
	       
	       		case "Basic Article":
	       			defaultForm();
	       			date.setVisible(false);
	       			dateInput.setVisible(false);
	       			
	       			question.setVisible(false);
	       			quesArea.setVisible(false);
	       			break;
	       
	       		case "Article with date":
	       			question.setVisible(false);
	       			quesArea.setVisible(false);
	       			
	       			defaultForm();
	       			setSize(700, 350);
	       			
	       			//buttons
	       			release.setLocation(10, 280);
	       			panel.add(release);
	       					
	       			clear.setLocation(155, 280);
	       			panel.add(clear);
	       					
	       			exit.setLocation(260, 280);
	       			panel.add(exit);
	       			
	       			//result
	       			result.setSize(320, 295);
	       			panel.add(result);
	       			
	       			date.setSize(100, 10);
	       			date.setLocation(10, 230);
	       			panel.add(date);
	       			
	       			dateInput.setSize(250, 25);
	       			dateInput.setLocation(90, 225);
	       			panel.add(dateInput);
	       			
	       			date.setVisible(true);
	       			dateInput.setVisible(true);
	       			
	       			break;
	       			
	       		case "Article with question":
	       			
	       			date.setVisible(false);
	       			dateInput.setVisible(false);
	       			
	       			defaultForm();
	       			setSize(700, 380);
	       			
	       			//buttons
	       			release.setLocation(10, 310);
	       			panel.add(release);
	       					
	       			clear.setLocation(155, 310);
	       			panel.add(clear);
	       					
	       			exit.setLocation(260, 310);
	       			panel.add(exit);
	       			
	       			//result
	       			result.setSize(320, 325);
	       			panel.add(result);
	       			
	       			//
	       			
	       			question.setSize(100,10);
	       			question.setLocation(10, 230);
	       			panel.add(question);
	       			
	       			quesArea.setSize(250, 60);
	       			quesArea.setLocation(90, 225);
	       			panel.add(quesArea);
	       			
	       			question.setVisible(true);
	       			quesArea.setVisible(true);
	       			
	       			break;
	       			
	       		case "Article with date and question":
	       			
	       			defaultForm();
	       			setSize(700, 420);
	       			
	       			//buttons
	       			release.setLocation(10, 355);
	       			panel.add(release);
	       					
	       			clear.setLocation(155, 355);
	       			panel.add(clear);
	       					
	       			exit.setLocation(260, 355);
	       			panel.add(exit);
	       			
	       			//result
	       			result.setSize(320, 370);
	       			panel.add(result);
	       			
	       			//
	       			
	       			question.setSize(100,10);
	       			question.setLocation(10, 230);
	       			panel.add(question);
	       			
	       			
	       			quesArea.setSize(250, 60);
	       			quesArea.setLocation(90, 225);
	       			panel.add(quesArea);
	       			
	       			date.setSize(100, 10);
	       			date.setLocation(10, 310);
	       			panel.add(date);
	       			
	       			dateInput.setSize(250, 25);
	       			dateInput.setLocation(90, 310);
	       			panel.add(dateInput);
	       			
	       			date.setVisible(true);
	       			dateInput.setVisible(true);
	       			
	       			question.setVisible(true);
	       			quesArea.setVisible(true);
	       			
	       			break;
	       }
	    }       
	}
}
