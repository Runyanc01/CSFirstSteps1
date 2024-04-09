package com.csfirststeps.application.views.datarep.binarygame;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;


@Tag("div")
public class BinaryGameDriver extends VerticalLayout{

    Div gameArea = new Div();

    Div gameMenu = new Div();

    Button start = new Button("Start");

    Button stop = new Button("End Game");

    boolean gameRunning = false;

    int binary;

    int num;

    public BinaryGameDriver() {


        LabelRow labelRow = new LabelRow();
        labelRow.getStyle()
                .set("width", "600px")
                .set("padding-left", "18px");

        gameMenu.getStyle()
                .set("border-radius", "5px")
                .set("padding", "12px")
                .set("height", "66px")
                .set("width", "600px")
                .set("display", "flex")
                .set("flex-direction", "row")
                .set("justify-content", "center");

        start.getStyle()
                .set("padding", "3px")
                .set("height", "60px")
                .set("min-width", "250px");
        start.setDisableOnClick(true);
        start.addClickListener(event -> {
            run();
            start.setEnabled(false);
        });
        stop.getStyle()
                .set("padding", "3px")
                .set("height", "60px")
                .set("min-width", "250px");
        stop.addClickListener(event -> end());
        gameMenu.add(start, stop);

        gameArea.getStyle()
                .set("border-radius", "5px")
                .set("padding", "0px")
                .set("height", "66px")
                .set("width", "600px")
                .set("display", "flex")
                .set("flex-direction", "column-reverse")
                .set("align-items", "flex-start");




        add(gameArea, labelRow, gameMenu);

    }





    public void removeRowIfMatch(Row row) {
        int sum = row.getButtonValuesSum();
        int targetValue = row.getDecimalValue();
        if (sum == targetValue) {
            gameArea.getElement().removeChild(row.getElement());

        }
    }

    public void populateRow () {

            Row row = new Row();
            gameArea.getElement().insertChild(0, row.getElement());
            UI.getCurrent().push();

    }

    public void run() {

        Row row = new Row();
        gameArea.add(row);
        UI.getCurrent().push();
        removeRowIfMatch(row);
        

    }

    public void end() {
        gameArea.removeAll();
        start.setEnabled(true);
    }

}






