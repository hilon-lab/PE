package gui;

import control.Calculator;
import control.ProjectHandling;
import data.Packet;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class CalculatorArea extends GridPane {

	// input fields
	TextField lengthTextField = new TextField();
	TextField widthTextField  = new TextField();
	TextField heightTextField = new TextField();
	TextField weightTextField = new TextField();

	// output label
	Label shippingCostLabel = new Label("?");

	// buttons
	Button calcButton = new Button("Calculate");

	/**
	 * This method checks and returns the users input values a double
	 * @return the costs for the shipping of the Packet
	 */
	private double calcShippingCosts() {
		// init
		Calculator calc = new Calculator();

		// get user input values
		int length = parseUserInputLength(lengthTextField.getText());
		int width = parseUserInputLength(widthTextField.getText());
		int height = parseUserInputLength(heightTextField.getText());
		int weight = parseUserInputWeight(weightTextField.getText());

		/*
		 * Open's a Error window when one of the Userinputs is a illegal statment
		 */
		if((length == Integer.MIN_VALUE) || (width == Integer.MIN_VALUE) ||
				(height == Integer.MIN_VALUE)||(weight == Integer.MIN_VALUE)){
			ProjectHandling.showError("Invalid value for the Packet!");


		}else {


			// peform calculation
			Packet packet = new Packet(length, width, height, weight);
			Double costs = calc.calcShippingCosts(packet);

			// show result
			shippingCostLabel.setText(costs.toString());

			return costs;
		}
		return 0;
	}

	// constructor
	public CalculatorArea() {

		// set standard distance between elements
		this.setPadding(new Insets(10, 10, 10, 10));

		// add decription labels
		this.add(new Label("Length: "), 1, 1);
		this.add(new Label("Width:  "), 1, 2);
		this.add(new Label("Height: "), 1, 3);
		this.add(new Label("Weight: "), 1, 4);

		// add input fields
		this.add(lengthTextField, 2, 1);
		this.add(widthTextField,  2, 2);
		this.add(heightTextField, 2, 3);
		this.add(weightTextField, 2, 4);

		// add labels for units
		this.add(new Label(), 3, 1);
		this.add(new Label(), 3, 2);
		this.add(new Label(), 3, 3);
		this.add(new Label(), 3, 4);

		// add shipping cost calculation line
		this.add(new Label("Shipping Costs: "), 1, 5);
		this.add(shippingCostLabel, 2, 5);
		this.add(calcButton, 3, 5);

		// set action listeners
		calcButton.setOnAction(ae-> {calcShippingCosts();});
	}
	/*
	 * This method checks if the userinput is in gram or in kilogram 
	 * @returns Integer.MIN_VALUE when nothing from the both things is true
	 */
	protected static int parseUserInputWeight(String inputWeight) {

		inputWeight = inputWeight.trim();
		if (inputWeight.endsWith("g") || inputWeight.endsWith("kg")){
			inputWeight = inputWeight.replace ("g","");
			inputWeight = inputWeight.replace("kg","");
			inputWeight = inputWeight.trim();
			try {
				return Integer.parseInt(inputWeight);
			}catch (NumberFormatException e) {
				return Integer.MIN_VALUE;
			}

		}
		else return Integer.MIN_VALUE;

	}
	/*This method checks if the userinput is in centimeter or in millimeter 
	 * @returns Integer.MIN_VALUE when nothing from the both things is true
	 * 
	 */
	protected static  int parseUserInputLength(String inputLength) {

		inputLength = inputLength.trim();
		if (inputLength.endsWith("cm") || inputLength.endsWith("mm")){
			inputLength = inputLength.replace ("cm","");
			inputLength = inputLength.replace("mm","");
			inputLength = inputLength.trim();
			try {
				return Integer.parseInt(inputLength);
			}catch (NumberFormatException e) {
				return Integer.MIN_VALUE;
			}

		}
		else return Integer.MIN_VALUE;

	}
}





