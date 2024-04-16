package com.csfirststeps.application.views.datarep.binarygame;

import com.vaadin.flow.component.html.Span;


import java.util.Random;

public class Row extends Span {

    Random random;
    int randNum;
    Span decVal = new Span();

    private CustGameButton[] buttons = new CustGameButton[8];

    public Row() {

        this.random = new Random();

        int[] values = new int[8];

        int targetNum = getDecimalValue();


        Span container = new Span();
        decVal.setText(String.valueOf(targetNum));
        decVal.getStyle()
                .set("height", "50px")
                .set("width", "60px")
                .set("margin-left", "8px");

        for (int i = 0; i < 8; i++) {
            buttons[i] = new CustGameButton(values, i);
            buttons[i].getStyle().set("margin-left", "8px");
            buttons[i].getStyle().set("margin-right", "8 px");
            container.add(buttons[i]);
        }

        container.add(decVal);



        add(container);


    }

    public int getButtonValuesSum () {
        int sum = 0;
        int power = 0;
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
        randNum = random.nextInt(128) +1;
        System.out.println("Rand num: " + randNum);
        return randNum;
    }

    public int findDecVal() {
        int target;
        target = Integer.parseInt(decVal.getText());
        System.out.println("decVal: " + target);
        return target;
    }



}
