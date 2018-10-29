package view;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import main.Main;
import model.Pizza;
import model.IllegalPizza;
import model.LineItem;

public class PizzaController {
	
	@FXML private TextArea order;   
 
    @FXML private ChoiceBox<String> numMushroom;
    
    @FXML private ChoiceBox<String> numCheese;
    
    @FXML private ChoiceBox<String> numPepperoni;
    
    @FXML private ChoiceBox<String> numSize;
    
    @FXML private Label cost;
    
    @FXML private Label orderCost;
    
    @FXML private TextField quantity;
    
    @FXML private Button add;
       
    private float orderCostData = 0;
    
    private ObservableList<String> sizeList = FXCollections.observableArrayList(
			"Small", "Medium", "Large");
    
    private ObservableList<String> cheeseList = FXCollections.observableArrayList(
			"Single", "Double", "Triple");
    
    private ObservableList<String> pepperoniList = FXCollections.observableArrayList(
			"None","Single", "Double");
    
    private ObservableList<String> mushroomList = FXCollections.observableArrayList(
			"None","Single", "Double");

   
    // Reference to the main application.
    @SuppressWarnings("unused")
	private Main Main;
    

    @FXML
    private void initialize() {
  	  numSize.setItems(sizeList);
	  numCheese.setItems(cheeseList);
	  numPepperoni.setItems(pepperoniList);
    	  numMushroom.setItems(mushroomList);

    	  numSize.setValue("Small");
    	  numCheese.setValue("Single");
    	  numPepperoni.setValue("Single");
    	  numMushroom.setValue("None");

    	  cost.setText("$8.50");
    	  quantity.setText("1");
    	  
    	  numSize.valueProperty().addListener((observableValue, currentVal, updatedVal) ->
    	{
    	    	String mushroom = numMushroom.getValue();
    	    	String pepperoni = numPepperoni.getValue();
    	    	String cheese = numCheese.getValue();
    	    	int num = Integer.parseInt(quantity.getText());
    	    	try {
					Pizza pizza = new Pizza(updatedVal.toLowerCase(),cheese,mushroom,pepperoni);
					double newCost = pizza.getCost() * num;
					cost.setText("$" + Double.toString(newCost) + "0");					
				} catch (IllegalPizza e) {
					System.out.println(e);
					e.printStackTrace();
				}
    	
    		});
    	  
    	  numMushroom.valueProperty().addListener((observableValue, currentVal, updatedVal) ->
      	{
      	    	String size  = numSize.getValue();
      	    	String pepperoni = numPepperoni.getValue();
      	    	String cheese = numCheese.getValue();
      	    	int num = Integer.parseInt(quantity.getText());
      	    	try {
  					Pizza pizza = new Pizza(size.toLowerCase(),cheese, updatedVal,pepperoni);
  					double newCost = pizza.getCost() * num;
  					cost.setText("$" + Double.toString(newCost) +"0");					
  				} catch (IllegalPizza e) {
  					System.out.println(e);
  					Alert alert = new Alert(AlertType.ERROR);
  					alert.setTitle("Error...");
  					alert.setHeaderText("Topping Error");
  					alert.setContentText("You must have pepperoni with your mushrooms!");
   					alert.showAndWait();
   					numMushroom.setValue(currentVal);
  				}
      	
      		});
    	  
    	  numPepperoni.valueProperty().addListener((observableValue, currentVal, updatedVal) ->
        	{
        	    	String size  = numSize.getValue().toString();
        	    	String mushroom = numMushroom.getValue();
        	    	String cheese = numCheese.getValue();
        	    	int num = Integer.parseInt(quantity.getText());
        	    	try {
    					Pizza pizza = new Pizza(size.toLowerCase(),cheese,mushroom,updatedVal);
    					double newCost = pizza.getCost() * num;
    					cost.setText("$" + Double.toString(newCost) + "0");					
    				} catch (IllegalPizza e) {
    					System.out.println(e);
    					e.printStackTrace();
    				}
        	
        		});
    	  
    	  numCheese.valueProperty().addListener((observableValue, currentVal, updatedVal) ->
      	{
      	    	String size  = numSize.getValue();
      	    String mushroom = numMushroom.getValue();
      	    	String pepperoni = numPepperoni.getValue();
      	    	int num = Integer.parseInt(quantity.getText());
      	    	try {
  					Pizza pizza = new Pizza(size.toLowerCase(),updatedVal,mushroom,pepperoni);
  					double newCost = pizza.getCost() * num;
  					cost.setText("$" + Double.toString(newCost) + "0");					
  				} catch (IllegalPizza e) {
  					System.out.println(e);
  					e.printStackTrace();
  				}
      	
      		});
    	  
    	  quantity.textProperty().addListener(new ChangeListener<String>() {
    		    @Override public void changed(ObservableValue<? extends String> observable, String currentValue, String updatedValue) {
    		        if (updatedValue.matches("\\d*")) {
    		            int newNum = Integer.parseInt(updatedValue);
    		            
    		            if(newNum < 1 || newNum > 100){
    		            	Alert alert = new Alert(AlertType.ERROR);
        					alert.setTitle("Error...");
        					alert.setHeaderText("Illegal number of pizzas!");
        					alert.setContentText("Quantity must be between 1 and 100!");
         					alert.showAndWait();
        		            quantity.setText(currentValue);
    		            } 		            	
    		            
    		            String size  = numSize.getValue();
    		            String mushroom = numMushroom.getValue();
    		            String pepperoni = numPepperoni.getValue();
    		            String cheese = numCheese.getValue();
    	      	    	try {
    	  					Pizza pizza = new Pizza(size.toLowerCase(),cheese,mushroom,pepperoni);
    	  					LineItem lineItem = new LineItem(newNum, pizza);
    	  					double newCost = lineItem.getCost();
    	  					cost.setText("$" + Double.toString(newCost) + "0");					
    	  				} catch (IllegalPizza e) {
    	  					System.out.println(e);
    	  				}
    		        } else {
    		        	Alert alert = new Alert(AlertType.ERROR);
    					alert.setTitle("Error...");
    					alert.setHeaderText("Illegal number of pizzas!");
    					alert.setContentText("Quantity must be a number!");
     					alert.showAndWait();
    		            quantity.setText(currentValue);
    		        }
    		    }
    		});
    	  
    	  add.setOnAction((event) -> {
    		    String size  = numSize.getValue();
      	    	String mushroom = numMushroom.getValue();
      	    	String pepperoni = numPepperoni.getValue();
      	    	String cheese = numCheese.getValue();
    	    	int num = Integer.parseInt(quantity.getText());
    	    	Pizza pizza;
				try {
					pizza = new Pizza(size.toLowerCase(),cheese,mushroom,pepperoni);
					try {
						LineItem lineItem = new LineItem(num, pizza);
						float lineCost = lineItem.getCost();
						orderCostData += lineCost;
						orderCost.setText("$" + Float.toString(orderCostData) + "0");
						order.appendText(lineItem.toString() + "\n");
				        
					} catch (IllegalPizza e) {
						e.printStackTrace();
					}
				} catch (IllegalPizza e1) {
					e1.printStackTrace();
				}
    	    	
    		    
    		});
    	  
    	  
    	  

    	}
    
 
    
    
    
    public void setMain(Main Main) {
        this.Main = Main;
    }
}