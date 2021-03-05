package Hagay_Elihai_Exe3;

import javax.swing.*;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.awt.Color;

public class BMICalculator extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField ageField, weightField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private String ageParameterStrings[] = {"years old", "months old"};
	private JSlider heightSlider;
	final JTextField centimetersField = new JTextField();
	private String exitString = "Exit";
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BMICalculator frame = new BMICalculator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BMICalculator() {
		setTitle("BMI Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 712, 417);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtpnBmiCalculator = new JTextPane();
		txtpnBmiCalculator.setFont(new Font("Tahoma", Font.BOLD, 17));
		txtpnBmiCalculator.setBackground(Color.CYAN);
		txtpnBmiCalculator.setText("BMI Calculator");
		txtpnBmiCalculator.setBounds(255, 0, 132, 23);
		contentPane.add(txtpnBmiCalculator);
		
		JPanel genderPanel = new JPanel();
		genderPanel.setBackground(Color.WHITE);
		genderPanel.setBorder(new TitledBorder(null, "Gender", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		genderPanel.setToolTipText("");
		genderPanel.setBounds(0, 30, 460, 48);
		contentPane.add(genderPanel);
		genderPanel.setLayout(null);
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		buttonGroup.add(rdbtnMale);
		rdbtnMale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		rdbtnMale.setBounds(120, 12, 67, 23);
		genderPanel.add(rdbtnMale);
		rdbtnMale.setForeground(Color.BLUE);
		rdbtnMale.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnMale.setBackground(Color.WHITE);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		buttonGroup.add(rdbtnFemale);
		rdbtnFemale.setBounds(218, 9, 79, 28);
		genderPanel.add(rdbtnFemale);
		rdbtnFemale.setForeground(Color.MAGENTA);
		rdbtnFemale.setFont(new Font("Tahoma", Font.BOLD, 15));
		rdbtnFemale.setBackground(Color.WHITE);
		
		JPanel agePanel = new JPanel();
		agePanel.setBackground(Color.WHITE);
		agePanel.setBorder(new TitledBorder(null, "Age", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		genderPanel.setToolTipText("");
		agePanel.setBounds(0, 76, 460, 48);
		contentPane.add(agePanel);
		agePanel.setLayout(null);
		
		ageField = new JTextField();
		ageField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		ageField.setBounds(120, 10, 86, 20);
		agePanel.add(ageField);
		ageField.setColumns(10);
		
		final JComboBox ageBox = new JComboBox();
		ageBox.setBackground(Color.WHITE);
		ageBox.setModel(new DefaultComboBoxModel(ageParameterStrings));
		ageBox.setBounds(216, 10, 92, 20);
		agePanel.add(ageBox);
		
		JPanel heightPanel = new JPanel();
		heightPanel.setBackground(Color.WHITE);
		heightPanel.setBorder(new TitledBorder(null, "Height", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		heightPanel.setToolTipText("");
		heightPanel.setBounds(0, 122, 460, 76);
		contentPane.add(heightPanel);
		heightPanel.setLayout(null);
		
		heightSlider = new JSlider();
		heightSlider.setMinorTickSpacing(10);
		heightSlider.setBounds(5, 19, 348, 46);
		heightPanel.add(heightSlider);
		heightSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				centimetersField.setText(String.valueOf(heightSlider.getValue()));
			}
		});
		heightSlider.setFont(new Font("Tahoma", Font.PLAIN, 11));
		heightSlider.setValue(0);
		heightSlider.setMajorTickSpacing(20);
		heightSlider.setPaintTicks(true);
		heightSlider.setPaintLabels(true);
		heightSlider.setMaximum(260);
		heightSlider.setForeground(Color.BLACK);
		heightSlider.setBackground(Color.WHITE);
		
		centimetersField.setBackground(Color.WHITE);
		centimetersField.setBounds(370, 23, 55, 20);
		heightPanel.add(centimetersField);
		centimetersField.setColumns(10);
		
		JTextPane txtpnCentimeters = new JTextPane();
		txtpnCentimeters.setBounds(367, 40, 83, 23);
		heightPanel.add(txtpnCentimeters);
		txtpnCentimeters.setText("centimeters");
		txtpnCentimeters.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtpnCentimeters.setBackground(Color.WHITE);
		
		JPanel weightPanel = new JPanel();
		weightPanel.setBorder(new TitledBorder(null, "Weight", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		weightPanel.setBackground(Color.WHITE);
		weightPanel.setBounds(0, 197, 460, 60);
		contentPane.add(weightPanel);
		weightPanel.setLayout(null);
		
		JTextPane txtpnActualWeight = new JTextPane();
		txtpnActualWeight.setText("Actual Weight:");
		txtpnActualWeight.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtpnActualWeight.setBackground(Color.WHITE);
		txtpnActualWeight.setBounds(54, 30, 97, 23);
		weightPanel.add(txtpnActualWeight);
		
		weightField = new JTextField();
		weightField.setColumns(10);
		weightField.setBackground(Color.WHITE);
		weightField.setBounds(157, 29, 55, 20);
		weightPanel.add(weightField);
		
		JTextPane txtpnKg = new JTextPane();
		txtpnKg.setBounds(215, 25, 26, 23);
		weightPanel.add(txtpnKg);
        txtpnKg.setText("kg");
        txtpnKg.setFont(new Font("Tahoma", Font.BOLD, 16));
        txtpnKg.setBackground(Color.WHITE);
        
        JPanel resultsPanel = new JPanel();
        resultsPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Results", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        resultsPanel.setBackground(Color.WHITE);
        resultsPanel.setBounds(0, 257, 460, 66);
        contentPane.add(resultsPanel);
        resultsPanel.setLayout(null);
        
        final JLabel bmiResult = new JLabel("Your BMI is:");
        bmiResult.setFont(new Font("Tahoma", Font.BOLD, 12));
        bmiResult.setBackground(Color.WHITE);
        bmiResult.setBounds(126, 15, 126, 14);
		resultsPanel.add(bmiResult);	
		final JLabel statusResult = new JLabel("Your weight status is:");
		statusResult.setFont(new Font("Tahoma", Font.BOLD, 12));
		statusResult.setBackground(Color.WHITE);
		statusResult.setBounds(126, 30, 246, 14);
		resultsPanel.add(statusResult);
		final JLabel recommendedWeight = new JLabel("Your recommended weight is:");
		recommendedWeight.setBackground(Color.WHITE);
		recommendedWeight.setFont(new Font("Tahoma", Font.BOLD, 12));
		recommendedWeight.setBounds(126, 45, 313, 14);
		resultsPanel.add(recommendedWeight);
		
		JPanel definitionsPanel = new JPanel();
		definitionsPanel.setBorder(new TitledBorder(null, "BMI definitions", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		definitionsPanel.setBackground(Color.WHITE);
		definitionsPanel.setBounds(459, 30, 238, 294);
		contentPane.add(definitionsPanel);
		definitionsPanel.setLayout(null);
		
		JTextPane txtpnBmi = new JTextPane();
		txtpnBmi.setText("BMI");
		txtpnBmi.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtpnBmi.setBackground(Color.WHITE);
		txtpnBmi.setBounds(10, 23, 41, 23);
		definitionsPanel.add(txtpnBmi);
		
		JTextPane txtpnWeightStatus = new JTextPane();
		txtpnWeightStatus.setText("Weight Status");
		txtpnWeightStatus.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtpnWeightStatus.setBackground(Color.WHITE);
		txtpnWeightStatus.setBounds(120, 23, 111, 23);
		definitionsPanel.add(txtpnWeightStatus);
		
		JTextPane txtpnBelow = new JTextPane();
		txtpnBelow.setText("Below 15");
		txtpnBelow.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnBelow.setBackground(Color.WHITE);
		txtpnBelow.setBounds(10, 57, 61, 23);
		definitionsPanel.add(txtpnBelow);
		
		JTextPane textPane = new JTextPane();
		textPane.setText("15 - 18.5");
		textPane.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textPane.setBackground(Color.WHITE);
		textPane.setBounds(10, 91, 63, 23);
		definitionsPanel.add(textPane);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setText("18.5 - 24.9");
		textPane_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textPane_1.setBackground(Color.WHITE);
		textPane_1.setBounds(10, 125, 75, 23);
		definitionsPanel.add(textPane_1);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setText("25.0 - 29.9");
		textPane_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textPane_2.setBackground(Color.WHITE);
		textPane_2.setBounds(10, 159, 85, 23);
		definitionsPanel.add(textPane_2);
		
		JTextPane textPane_3 = new JTextPane();
		textPane_3.setText("30.0 - 35");
		textPane_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textPane_3.setBackground(Color.WHITE);
		textPane_3.setBounds(10, 193, 68, 23);
		definitionsPanel.add(textPane_3);
		
		JTextPane txtpnAbove = new JTextPane();
		txtpnAbove.setText("Above 35");
		txtpnAbove.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnAbove.setBackground(Color.WHITE);
		txtpnAbove.setBounds(10, 227, 68, 23);
		definitionsPanel.add(txtpnAbove);
		
		JTextPane txtpnAnorexic = new JTextPane();
		txtpnAnorexic.setText("Anorexic");
		txtpnAnorexic.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnAnorexic.setBackground(Color.WHITE);
		txtpnAnorexic.setBounds(120, 57, 61, 23);
		definitionsPanel.add(txtpnAnorexic);
		
		JTextPane txtpnUnderweight = new JTextPane();
		txtpnUnderweight.setText("Underweight");
		txtpnUnderweight.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnUnderweight.setBackground(Color.WHITE);
		txtpnUnderweight.setBounds(120, 91, 85, 23);
		definitionsPanel.add(txtpnUnderweight);
		
		JTextPane txtpnNormal = new JTextPane();
		txtpnNormal.setText("Normal");
		txtpnNormal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnNormal.setBackground(Color.WHITE);
		txtpnNormal.setBounds(120, 125, 49, 23);
		definitionsPanel.add(txtpnNormal);
		
		JTextPane txtpnOverweight = new JTextPane();
		txtpnOverweight.setText("Overweight");
		txtpnOverweight.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnOverweight.setBackground(Color.WHITE);
		txtpnOverweight.setBounds(120, 159, 75, 23);
		definitionsPanel.add(txtpnOverweight);
		
		JTextPane txtpnObese = new JTextPane();
		txtpnObese.setText("Obese");
		txtpnObese.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnObese.setBackground(Color.WHITE);
		txtpnObese.setBounds(120, 193, 49, 23);
		definitionsPanel.add(txtpnObese);
		
		JTextPane txtpnExtremeObese = new JTextPane();
		txtpnExtremeObese.setText("Extreme Obese");
		txtpnExtremeObese.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnExtremeObese.setBackground(Color.WHITE);
		txtpnExtremeObese.setBounds(120, 227, 100, 23);
		definitionsPanel.add(txtpnExtremeObese);
		
		JButton btnCalculateBmi = new JButton("Calculate BMI");
		btnCalculateBmi.setBounds(202, 334, 123, 33);
		contentPane.add(btnCalculateBmi);
		JButton btnExit = new JButton(exitString);
		btnExit.setBounds(350, 334, 79, 33);
		contentPane.add(btnExit);
		
		btnCalculateBmi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent act) {
		    	  String gender, ageStatus;
		    	  double age, height, actualWeight, recWeight = -1 , bmi, temp;
		    	  try {
		    		  // Gender
			    	  gender = getSelectedButtonText(buttonGroup);
			    	  // Age
			    	  ageStatus = ageBox.getSelectedItem().toString();
			    	  if (ageStatus.equals("months old")) 
			    		  age = Double.parseDouble(ageField.getText()) / 12; 
			    	  else 
			    		  age = Double.parseDouble(ageField.getText());
			    	  // Height
			    	  height = heightSlider.getValue();
			    	  // Weight
			    	  actualWeight = Double.parseDouble(weightField.getText());
			    	  // The recommended weight
			    	  if (age >= 0) {
			    		  if (age <= 1) 
			    			  recWeight = 6 * age + 4; // (0.5 * 12) * age + 4
			    		  else if (age <= 10) 
			    			  recWeight = 2 * age + 10;
			    		  else if (gender.equals("Male")) 
			    			  recWeight = 48 + 1.1 * (height - 152);
			    		  else if (gender.equals("Female")) 
			    			  recWeight = 45.4 + 0.9 * (height - 152);
			    	  }
			    	  if (recWeight != -1) {
				    	  temp = Math.round(recWeight * 100);
				    	  recWeight = temp / 100;
				    	  recommendedWeight.setText("Your recommended weight is: " + recWeight);
			    	  }
			    	  // BMI
			    	  bmi = actualWeight / ((height / 100) * (height / 100)); 
			    	  temp = Math.round(bmi * 100);
			    	  bmi = temp / 100;
			    	  bmiResult.setText("Your BMI is: " + bmi);                           
			    	  if (bmi < 15)                          
			    		  statusResult.setText("Your weight status is: Anorexic");
			    	  else if (bmi >= 15 && bmi < 18.5)      
			    		  statusResult.setText("Your weight status is: Underweight");
			    	  else if (bmi >= 18.5 && bmi <= 24.9)   
			    		  statusResult.setText("Your weight status is: Normal");
			    	  else if (bmi >= 25 && bmi <= 29.9)     
			    		  statusResult.setText("Your weight status is: Overweight");
			    	  else if (bmi >= 30 && bmi <= 35)       
			    		  statusResult.setText("Your weight status is: Obese");
			    	  else if (bmi > 35)                     
			    		  statusResult.setText("Your weight status is: Extreme Obese");
		    	  }
		    	  catch(Exception missed)
		    	  {
		    		  System.out.println("You have to fill all the fields");
		    	  }
		      }
		});
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (event.getSource() == btnExit) // If the user push the Exit button
					System.exit(EXIT_ON_CLOSE);
			}
		});
	}
	     // Method that returns the label of the button.
		 public String getSelectedButtonText(ButtonGroup buttonGroup) {
		        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
		            AbstractButton button = buttons.nextElement();
		            if (button.isSelected()) {
		                return button.getText();
		            }
		        }
		        return null;
		 }
}