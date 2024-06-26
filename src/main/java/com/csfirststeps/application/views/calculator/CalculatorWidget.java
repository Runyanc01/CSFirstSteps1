package com.csfirststeps.application.views.calculator;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

//define as div component
@Tag("div")
public class CalculatorWidget extends VerticalLayout {

    //define data members
    private TextField displayField;
    private double currentResult = 0;
    private String currentInput = "";
    private String lastOperation = "";

    public CalculatorWidget() {
        //Create a container for the calculator
        VerticalLayout calculatorContainer = new VerticalLayout();
        calculatorContainer.setWidth("230px");
        calculatorContainer.getStyle()
                .set("border-color", "black")
                .set("border-style", "solid")
                .set("border-radius", "15px")
                .set("border-width", "2px")
                .set("background-color", "#232324");

        //Create a text field to display the result
        displayField = new TextField();
        displayField.setReadOnly(true);
        displayField.setWidth("190px");
        calculatorContainer.add(displayField);

        //Create buttons for numbers and operations
        String[] buttonCaptions = {"7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3", "x", "0", ".", "=", "/", "C"};
        HorizontalLayout rowLayout = new HorizontalLayout();
        for (String caption : buttonCaptions) {
            Button button = new Button(caption);
            button.getStyle().set("max-width", "var(--lumo-size-m)")
                    .set("min-width", "var(--lumo-size-m)")
                    .set("background-color", "#78756b")
                    .set("color", "black");
            button.addClickListener(e -> buttonClicked(caption));
            if (caption.equals("=") || caption.equals("+") || caption.equals("-") || caption.equals("x") || caption.equals(".") || caption.equals("/")) {
                button.getStyle().set("background-color", "#d98911");
            }
            if (caption.equals("C")) {
                button.getStyle().set("min-width", "190px");
            }
            rowLayout.add(button);

            //Add a new row after every 4 buttons
            if (rowLayout.getComponentCount() == 4) {
                calculatorContainer.add(rowLayout);
                rowLayout = new HorizontalLayout();
            }
        }

        //Add the last row if it's not empty
        if (rowLayout.getComponentCount() > 0) {
            calculatorContainer.add(rowLayout);
        }

        add(calculatorContainer);
    }

    private void buttonClicked(String caption) {

        //if button caption "=" return result after calculation
        if (caption.equals("=")) {
            calculateResult();
            return;
        }

        //if caption "C" clear text field
        if (caption.equals("C")) {
            displayField.setValue("");
        }

        //if caption 0-9 or "." add to text field
        if (caption.matches("[0-9]") || caption.equals(".")) {
            currentInput += caption;
            displayField.setValue(currentInput);
        }

        //or if input not empty calculate and return
        else {
            if (!currentInput.isEmpty()) {
                calculateResult();
            }
            lastOperation = caption;
        }
    }

    private void calculateResult() {

        //define calculation method for decimals
        if (displayField.getValue().contains(".")) {
            double inputNumber = Double.parseDouble(currentInput);
            switch (lastOperation) {
                case "+":
                    currentResult += inputNumber;
                    break;
                case "-":
                    currentResult -= inputNumber;
                    break;
                case "x":
                    currentResult *= inputNumber;
                    break;
                case "/":
                    if (inputNumber != 0) {
                        currentResult /= inputNumber;
                    } else {
                        displayField.setValue("Error");
                        currentResult = 0;
                        currentInput = "";
                        lastOperation = "";
                        return;
                    }
                    break;
                default:
                    currentResult = inputNumber;
            }
        }

        //define calculation method for integers
        else {
            int inputNumber = Integer.parseInt(currentInput);
            switch (lastOperation) {
                case "+":
                    currentResult += inputNumber;
                    break;
                case "-":
                    currentResult -= inputNumber;
                    break;
                case "x":
                    currentResult *= inputNumber;
                    break;
                case "/":
                    if (inputNumber != 0) {
                        currentResult /= inputNumber;
                    } else {
                        displayField.setValue("Error");
                        currentResult = 0;
                        currentInput = "";
                        lastOperation = "";
                        return;
                    }
                    break;
                default:
                    currentResult = inputNumber;
            }
        }

        //display result
        displayField.setValue(String.valueOf(currentResult));
        currentInput = "";
    }
}
