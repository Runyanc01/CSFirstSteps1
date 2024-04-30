package com.csfirststeps.application.views.binarygame;

import com.vaadin.flow.component.html.Span;


import java.util.Random;

public class Row extends Span {

    Random random;
    int randNum;
    Span decVal = new Span();

    private CustGameButton[] buttons = new CustGameButton[8];

    public Row() {

        //define data members
        this.random = new Random();
        int[] values = new int[8];

        //get value to match to binary input
        int targetNum = getDecimalValue();

        //create container and style decimal value in row
        Span container = new Span();
        decVal.setText(String.valueOf(targetNum));
        decVal.getStyle()
                .set("height", "50px")
                .set("width", "60px")
                .set("margin-left", "8px");

        //add custom buttons to row
        for (int i = 0; i < 8; i++) {
            buttons[i] = new CustGameButton(values, i);
            buttons[i].getStyle().set("margin-left", "8px");
            buttons[i].getStyle().set("background-color", "var(--lumo-base-color)");
            buttons[i].getStyle().set("color", "white");
            container.add(buttons[i]);
        }

        //add decimal value to container
        container.add(decVal);

        //add container to component view
        add(container);
    }

    public int getButtonValuesSum () {
        //define sum and power
        int sum = 0;
        int power = 0;

        //use position and value in button to determine binary value in decimal
        for (int i = buttons.length - 1; i >= 0; i--) {
            if (buttons[i].getText().equals("1")) {
                sum += Math.pow(2, power);
            }
            power++;
        }
        System.out.println("Button sum: " + sum);
        return sum;
    }

    public int getDecimalValue() {
        //randomly generate value between 1 and 128 inclusive
        randNum = random.nextInt(128) +1;
        System.out.println("Rand num: " + randNum);
        return randNum;
    }

    public int findDecVal() {
        //get value from decVal field
        int target;
        target = Integer.parseInt(decVal.getText());
        System.out.println("decVal: " + target);
        return target;
    }



}
