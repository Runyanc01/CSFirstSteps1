package com.csfirststeps.application.views.datarep.binarygame;

import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.textfield.NumberField;

import java.util.Random;
import java.util.function.Consumer;

public class Row extends Span {

    Random random;
    int randNum;

    private CustGameButton[] buttons = new CustGameButton[8];

    private Consumer<Row> rowRemovalCallback;


    public Row(Consumer<Row> rowRemovalCallback) {
        
        this.rowRemovalCallback = rowRemovalCallback;
        this.random = new Random();


        int[] values = new int[8];

        int targetNum = getDecimalValue();

        Span decVal = new Span();

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
            buttons[i].addClickListener(event -> checkAndRemoveRow(targetNum));
            container.add(buttons[i]);
        }

        container.add(decVal);



        add(container);


    }

    private void checkAndRemoveRow(int targetNum) {
        if (rowRemovalCallback != null) {
            if (getButtonValuesSum() == targetNum) {
                rowRemovalCallback.accept(this);
            }
        }
    }

    public int getButtonValuesSum () {
        int sum = 0;
        for (int i = 0; i < buttons.length; i++) {
            if (buttons[i].getText().equals("1")) {
                sum += Math.pow(2, i);
            }
        }
        return sum;
    }

    public int getDecimalValue() {
        randNum = random.nextInt(255) +1;
        return randNum;
    }



}
