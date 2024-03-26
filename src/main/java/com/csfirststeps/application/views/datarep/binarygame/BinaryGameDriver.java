package com.csfirststeps.application.views.datarep.binarygame;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.util.Timer;
import java.util.TimerTask;

@Tag("div")
public class BinaryGameDriver extends VerticalLayout{
//create variables

    private Timer timer;

    Button startButton;

    Button gameOverButton;

    Div gameArea = new Div();

    Div gameMenu = new Div();

    int rowCount = 0;

    //add variables as parameters
    public BinaryGameDriver() {


        LabelRow labelRow = new LabelRow();
        labelRow.getStyle()
                .set("width", "600px")
                .set("padding-left", "18px");

        gameOverButton = new Button("Play Again");
        gameOverButton.getStyle()
                .setHeight("50px")
                .setWidth("200px")
                .setBackgroundColor("red")
                .setColor("black");
        gameOverButton.setEnabled(false);

        startButton = new Button("Start");
        startButton.getStyle()
                .setHeight("50px")
                .setWidth("200px")
                .setBackgroundColor("green")
                .setColor("white");

        startButton.addClickListener(event -> startGame());

        gameArea.getStyle()
                .set("border", "1.25px solid black")
                .set("border-radius", "5px")
                .set("padding", "0px")
                .set("height", "525px")
                .set("width", "600px")
                .set("display", "flex")
                .set("flex-direction", "column-reverse")
                .set("align-items", "flex-start");

        gameMenu.getStyle()
                .set("border", "1.25px border")
                .set("border-radius", "5px")
                .set("padding", "0")
                .set("height", "90px")
                .set("width", "600px")
                .set("display", "flex")
                .set("justify-content", "center");

        gameMenu.add(startButton);



        add(gameArea, labelRow, gameMenu);

    }

    public void startGame() {
        startButton.setEnabled(false);
        startButton.setVisible(false);

        startPolling();

        generateFirstRow();
    }

    private void startPolling() {

        UI.getCurrent().addPollListener(event -> handlePolling());

        UI.getCurrent().setPollInterval(5000);

    }

    private void stopPolling() {
        if (timer != null) {
            timer.cancel();
            timer = null;
            UI.getCurrent().setPollInterval(-1);
        }

        gameOverButton.setEnabled(true);
    }

    private void handlePolling() {
        UI.getCurrent().access(() -> {
           startGameTimer();
        });
    }

    private void startGameTimer() {
      final int intervalSeconds = 35;

        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                getUI().ifPresent(ui -> ui.access(() -> createGame()));
            }
        }, 0, intervalSeconds * 1000);
    }


    public void generateFirstRow () {

        Row row = new Row(this::removeRowIfMatch);
        gameArea.getElement().insertChild(0,row.getElement());
        rowCount++;
        UI.getCurrent().push();

    }


    public void createGame () {

        if (rowCount < 12) {

            Row row = new Row(this::removeRowIfMatch);
            gameArea.getElement().insertChild(0, row.getElement());
            rowCount++;
            UI.getCurrent().push();


        } else {
            stopPolling();
            gameArea.removeAll();
            gameArea.getStyle()
                    .set("background-color", "black")
                    .set("justify-content", "center")
                    .set("align-items", "center");
            gameArea.add(gameOverButton);
            gameArea.setEnabled(true);
            gameOverButton.addClickListener(event -> {
                rowCount = 0;
                gameArea.getStyle()
                        .set("background-color", "transparent")
                        .set("display", "flex")
                        .set("justify-content", "flex-start")
                        .set("flex-direction", "column-reverse")
                        .set("align-items", "flex-start");
                gameArea.removeAll();
                restartGame();
            });
        }
    }

    public void removeRowIfMatch(Row row) {
        int sum = row.getButtonValuesSum();
        int targetValue = row.getDecimalValue();
        if (sum == targetValue) {
            gameArea.getElement().removeChild(row.getElement());
            rowCount--;
        }
    }

    public void restartGame() {
        startButton.setEnabled(false);
        startButton.setVisible(false);
        if (timer == null) {
            startPolling();
            generateFirstRow();
        }
    }

}
