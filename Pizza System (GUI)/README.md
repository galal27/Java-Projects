# Pizza System GUI using JavaFX

This project was part of a Queen's Computer Engineering Java course. 

## Project Statement

For this project we will complete a portion of the Pizza order system used in an earlier project. However, instead of the supplied console-based interface we will build our own GUI interface using JavaFX. We will need your Pizza, LineItem and IllegalPizza classes.

Here is what our GUI must do:

 - The user must be able to configure a pizza by choosing a size, and then the cheese, pepperoni and mushroom toppings. The user's choices must be limited to the legal options given with the assignment.
 - Display the cost of the pizza configured by the user.
 - The user must be able to specify a quantity of these pizzas and must be restricted to entering an integer between 1 and 100, inclusive.
 - Display the cost of this quantity of the configured pizza.
 - A button is used to save the current pizza configuration and quantity as a line item which is added to the order being displayed. Instead of displaying the current order to the console, display it in the same way in a TextArea control. Every time this button is clicked by the user another line item is added to and displayed in the order.
 - As the last line in the displayed order, show the total order cost (without tax!).
 - Our GUI must be "monkey proof". The user must not be able to configure an illegal pizza or supply an illegal quantity. The user cannot be allowed to edit displayed costs or the displayed order. As you might expect, every time the program starts the order will be empty. Our GUI should also remain fairly stable on re-sizing and its operation should be self-explanatory and user-friendly.