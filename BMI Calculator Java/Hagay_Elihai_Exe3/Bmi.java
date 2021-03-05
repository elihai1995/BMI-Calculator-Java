package gui_hagay_elichai;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.*;
import java.util.Hashtable;
import java.util.Enumeration;

public class Bmi extends JFrame { 
	
	private JFrame theFrame;
	private JPanel gender, age, height, weight, result;
	private JButton calculate;
	private JLabel titel, Lheight, Lweight1, Lweight2 , recWeightT, status, yourBmi;
	private JTextField textAge, textWeight, textHeight;
	private JRadioButton male, female;
	private ButtonGroup group;
	private JComboBox ageBox;
	private JSlider heightSlider;

	public Bmi() {
		theFrame= new JFrame();
		theFrame.setTitle("Bmi Calculator");
		theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//theFrame.setSize(600, 800);
		theFrame.setBackground(Color.ORANGE);
		theFrame.setVisible(true);
		titel = new JLabel("BMI Calculator");
		titel.setFont(new Font("Tahoma", Font.BOLD, 17));
		theFrame.setLayout(new GridLayout(7, 1));
		theFrame.add(titel);
		
		

		//gender:
		gender = new JPanel();
		gender.setBorder(BorderFactory.createTitledBorder ("Gender")); //up title
		male = new JRadioButton("Male");
		female = new JRadioButton("Female");
		//gender.setBackground(Color.WHITE);
		group = new ButtonGroup();	
	    group.add (male);			    
	    group.add (female);
	    //color:
		male.setForeground(Color.BLUE); //change color of text.

		female.setForeground(Color.PINK);
		
		gender.add(male);
		gender.add(female);
		theFrame.add(gender);

		//age:
		age = new JPanel();
		age.setBorder(BorderFactory.createTitledBorder ("Age")); //up title
		textAge = new JTextField(7);
		String [] combo = {"monthes", "years"}; 
		ageBox = new JComboBox(combo);

		
		//add:
		theFrame.add(age);
		age.add(textAge);
		age.add(ageBox);
		
		//height:
		height = new JPanel();
		height.setBorder(BorderFactory.createTitledBorder ("Height")); //up title
		textHeight = new JTextField(7);
		Lheight = new JLabel("CM");
		
		
		heightSlider = new JSlider();
		heightSlider.setMinorTickSpacing(10);
		heightSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				textHeight.setText(String.valueOf(heightSlider.getValue()));
			}
		});
		heightSlider.setValue(0);
		heightSlider.setMajorTickSpacing(50);
		heightSlider.setPaintTicks(true);
		heightSlider.setPaintLabels(true);
		heightSlider.setMaximum(260);
		heightSlider.setFont(new Font("Tahoma", Font.ITALIC, 11));

		theFrame.add(height);
		height.add(heightSlider);
		height.add(textHeight);
		height.add(Lheight);
		//weight:
		weight = new JPanel();
		weight.setBorder(BorderFactory.createTitledBorder ("Weight")); //up title
		textWeight =  new JTextField(7);
		Lweight1 = new JLabel("Actual Weight");
		Lweight2 = new JLabel("KG");
		theFrame.add(weight);
		weight.add(Lweight1);
		weight.add(textWeight);
		weight.add(Lweight2);
		
		//result:
		result = new JPanel();
		result.setBorder(BorderFactory.createTitledBorder ("Result")); //up title
		yourBmi = new JLabel("");
		recWeightT = new JLabel("");
		status = new JLabel("");
		calculate = new JButton("calculate");
		yourBmi.setFont(new Font("Tahoma", Font.LAYOUT_RIGHT_TO_LEFT, 13));
		status.setFont(new Font("Tahoma", Font.CENTER_BASELINE, 13));
		recWeightT.setFont(new Font("Tahoma", Font.CENTER_BASELINE, 13));
		theFrame.add(result);
		result.setLayout(new BoxLayout (result, BoxLayout.Y_AXIS));
		result.add(yourBmi);
		result.add(recWeightT);
		result.add(status);
		
		setLayout(new BorderLayout());
		theFrame.add(calculate,BorderLayout.CENTER);
		
		calculate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent act) {
		    	  String genderG, ageStatus;
		    	  double age=0, height, actualWeight, recWeight = -1 , bmi, temp;
		    	  
		    		  // Gender
			    	  genderG = getOfGroup(group);
			    	  // Age
			    	  ageStatus = ageBox.getSelectedItem().toString();
			    	  //System.out.println(ageStatus);
			    	  if (ageStatus.equals("monthes")) 
			    		  age = Double.parseDouble(textAge.getText()) / 12; 
			    	  else if(ageStatus.equals("years")) 
			    		  age = Double.parseDouble(textAge.getText());
			    	 // System.out.println(age);
			    	  // Height
			    	  height = heightSlider.getValue();
			    	  // Weight
			    	  actualWeight = Double.parseDouble(textWeight.getText());
			    	  // The recommended weight
			    	  if (age >= 0) {
			    		  if (age <= 1) 
			    			  recWeight = 6 * age + 4; // (0.5 * 12) * age + 4
			    		  else if (age <= 10) 
			    			  recWeight = 2 * age + 10;
			    		  	if(age>10) {
			    		  		System.out.println(genderG);
			    		  		if (genderG.equals("Male")) 
			    		  			recWeight = 48 + 1.1 * (height - 152);
			    		  		else if (genderG.equals("Female")) 
			    		  			recWeight = 45.4 + 0.9 * (height - 152);
			    	  }
			    	  }
			    	  if (recWeight != -1) {
				    	  temp = Math.round(recWeight * 100);
				    	  recWeight = temp / 100;
				    	  recWeightT.setText("Your recommended weight is: " + recWeight);
			    	  }
			    	  // BMI
			    	  bmi = actualWeight / ((height / 100) * (height / 100)); 
			    	  temp = Math.round(bmi * 100);
			    	  bmi = temp / 100;
			    	  yourBmi.setText("Your BMI is: " + bmi);                           
			    	  if (bmi < 15)                          
			    		  status.setText("Your weight status is: Anorexic");
			    	  else if (bmi >= 15 && bmi < 18.5)      
			    		  status.setText("Your weight status is: Underweight");
			    	  else if (bmi >= 18.5 && bmi <= 24.9)   
			    		  status.setText("Your weight status is: Normal");
			    	  else if (bmi >= 25 && bmi <= 29.9)     
			    		  status.setText("Your weight status is: Overweight");
			    	  else if (bmi >= 30 && bmi <= 35)       
			    		  status.setText("Your weight status is: Obese");
			    	  else if (bmi > 35)                     
			    		  status.setText("Your weight status is: Extreme Obese");
			}   	
		});
		theFrame.pack();
	}
	
	public String getOfGroup(ButtonGroup group) {
        for (Enumeration<AbstractButton> buttons = group.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                return button.getText();
            }
        }
        return null;
 }
}


			