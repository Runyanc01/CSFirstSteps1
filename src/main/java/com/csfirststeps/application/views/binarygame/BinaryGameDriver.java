package com.csfirststeps.application.views.binarygame;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;

//define component as div
@Tag("div")
public class BinaryGameDriver extends Div{

    //define data members
    Div gameArea = new Div();
    Div gameMenu = new Div();
    Button start = new Button("Start");
    Button stop = new Button("End Game");
    Button checkRow = new Button("Check");

    public BinaryGameDriver() {
        //instantiate and style labelRow
        LabelRow labelRow = new LabelRow();
        labelRow.getStyle()
                .set("width", "600px")
                .set("padding-left", "18px");

        //style gameMenu container
        gameMenu.getStyle()
                .set("border-radius", "10px")
                .set("padding", "12px")
                .set("height", "66px")
                .set("width", "600px")
                .set("display", "flex")
                .set("justify-content", "center")
                .set("flex-direction", "row");

        //style checkRow button
        checkRow.getStyle()
                .set("padding", "3px")
                .set("height", "60px")
                .set("min-width", "250px")
                .set("background-color", "var(--lumo-base-color")
                .set("color", "white");
        checkRow.setVisible(true);

        //add click listener to compare current row's binary value to decimal value
        //and remove if match
        checkRow.addClickListener(event -> {
            Row currentRow = getCurrentRow();
            if (currentRow != null) {
                removeRowIfMatch(currentRow);
            }
        });

        //style start button
        start.getStyle()
                .set("padding", "3px")
                .set("height", "60px")
                .set("background-color", "var(--lumo-base-color)")
                .set("color", "white")
                .set("min-width", "250px");
        start.setDisableOnClick(true);

        //add click listener to start to run the game and dynamically style
        //the gameMenu container
        start.addClickListener(event -> {
            run();
            gameMenu.remove(start, stop);
            gameMenu.add(checkRow, stop);
        });

        //style stop button
        stop.getStyle()
                .set("padding", "3px")
                .set("height", "60px")
                .set("background-color", "var(--lumo-base-color)")
                .set("color", "white")
                .set("min-width", "250px");

        //add click listener to stop to end game and dynamically
        //style gameMenu container
        stop.addClickListener(event -> {
            end();
            gameMenu.remove(checkRow, stop);
            gameMenu.add(start, stop);
        });

        //add start and stop buttons to gameMenu container
        gameMenu.add(start, stop);

        //style gameArea
        gameArea.getStyle()
                .set("border-radius", "5px")
                .set("padding", "0px")
                .set("height", "66px")
                .set("width", "600px")
                .set("display", "flex")
                .set("flex-direction", "column-reverse")
                .set("align-items", "flex-start");

        //add all containers to component view
        add(gameArea, labelRow, gameMenu);

    }


    public void removeRowIfMatch(Row row) {
        //get value of binary row and decimal value
        int sum = row.getButtonValuesSum();
        int targetValue = row.findDecVal();

        //if match, remove row from gameArea
        if (sum == targetValue) {
            gameArea.remove(row);
            run();
        }
    }

    private Row getCurrentRow() {
        //return current row
        for (int i = 0; i < gameArea.getComponentCount(); i++) {
            if (gameArea.getComponentAt(i) instanceof Row) {
                return (Row) gameArea.getComponentAt(i);
            }
        }
        return null;
    }


    public void run() {
        //generate new row and add to gameArea container
        Row row = new Row();
        gameArea.add(row);
    }

    public void end() {
        //remove all elements from gameArea container and re-enable start button
        gameArea.removeAll();
        start.setEnabled(true);
    }

}






