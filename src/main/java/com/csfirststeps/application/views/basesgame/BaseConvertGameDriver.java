package com.csfirststeps.application.views.basesgame;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

//define as div component
@Tag("div")
public class BaseConvertGameDriver extends Div{
    //define data members
    HorizontalLayout gameWithMode = new HorizontalLayout();
    VerticalLayout game = new VerticalLayout();
    Div gameArea = new Div();
    Div gameMenu = new Div();
    Div gameMode = new Div();
    Button stop = new Button("End Game");
    Button checkRow = new Button("Check");
    Button binaryToHex = new Button("Binary to Hex");
    Button hexToBinary = new Button("Hex to Binary");
    Button decimalToHex = new Button("Decimal to Hex");
    int gameType = 0;
    int score = 0;

    public BaseConvertGameDriver() {
        //instantiate and style label row
        LabelRow labelRow = new LabelRow();
        labelRow.getStyle()
                .set("width", "600px")
                .set("padding-left", "18px");
        labelRow.setVisible(false);

        //instantiate and style hex label row
        HexLabelRow hexLabelRow = new HexLabelRow();
        labelRow.getStyle()
                .set("width", "600px")
                .set("padding-left", "20px");
        hexLabelRow.setVisible(false);

        //style gameMode container
        gameMode.getStyle()
                .set("padding", "12px")
                .set("display", "flex")
                .set("justify-content", "center")
                .set("flex-direction", "column");

        //style binaryToHex button
        binaryToHex.getStyle()
                .set("max-height", "50px")
                .set("max-width", "150px")
                .set("background-color", "var(--lumo-base-color)")
                .set("border-radius", "10px");

        //style hexToBinary button
        hexToBinary.getStyle()
                .set("max-height", "50px")
                .set("max-width", "150px")
                .set("background-color", "var(--lumo-base-color)")
                .set("border-radius", "10px");

        //style decimalToHex button
        decimalToHex.getStyle()
                .set("max-height", "50px")
                .set("max-width", "150px")
                .set("background-color", "var(--lumo-base-color)")
                .set("border-radius", "10px");

        //add click listener to binaryToHex button to run corresponding game type logic
        //and dynamically style gameMode container
        binaryToHex.addClickListener(event -> {
            gameType = 2;
            binaryToHex.setEnabled(false);
            hexToBinary.setEnabled(false);
            decimalToHex.setEnabled(false);
            hexLabelRow.setVisible(true);
            run(gameType);
        });

        //add click listener to hexToBinary button to run corresponding game type logic
        //and dynamically style gameMode container
        hexToBinary.addClickListener(event -> {
           gameType = 3;
            binaryToHex.setEnabled(false);
            hexToBinary.setEnabled(false);
            decimalToHex.setEnabled(false);
            labelRow.setVisible(true);
            run(gameType);
        });

        //add click listener to decimalToHex button to run corresponding game type logic
        //and dynamically style gameMode container
        decimalToHex.addClickListener(event -> {
            gameType = 1;
            binaryToHex.setEnabled(false);
            hexToBinary.setEnabled(false);
            decimalToHex.setEnabled(false);
            hexLabelRow.setVisible(true);
            run(gameType);
        });

        //add buttons to gameMode container
        gameMode.add(binaryToHex, hexToBinary, decimalToHex);

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

        //add click listener to checkRow button to use gameType and
        //remove row if matching values
        checkRow.addClickListener(event -> {
            Row currentRow = getCurrentRow();
            if (currentRow != null) {
                removeRowIfMatch(currentRow,gameType);
            }
            //if game mode has not been selected, display warning notification
            if (gameType == 0) {
                Notification notification = Notification.show("Please select a game mode");
                notification.setPosition(Notification.Position.MIDDLE);
                notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
                notification.setDuration(3000);
            }
        });

        //style stop button
        stop.getStyle()
                .set("padding", "3px")
                .set("height", "60px")
                .set("background-color", "var(--lumo-base-color)")
                .set("color", "white")
                .set("min-width", "250px");

        //add click listener to stop button to remove label rows
        //and end game
        stop.addClickListener(event -> {
            hexLabelRow.setVisible(false);
            labelRow.setVisible(false);
            end();
        });

        //add checkRow and stop buttons to gameMenu container
        gameMenu.add(checkRow, stop);

        //style gameArea container
        gameArea.getStyle()
                .set("border-radius", "5px")
                .set("padding", "0px")
                .set("height", "66px")
                .set("width", "600px")
                .set("display", "flex")
                .set("flex-direction", "column-reverse")
                .set("align-items", "flex-start");

        //add containers to game container
        game.add(gameArea, labelRow, hexLabelRow,gameMenu);

        //add game and gameMode containers to gameWithMode container
        gameWithMode.add(game, gameMode);

        //add container to component view
        add(gameWithMode);

    }


    public void removeRowIfMatch(Row row, int gameType) {
        //logic to remove row in decimal to hex game mode
        if (gameType == 1) {
            System.out.println(Integer.toHexString(row.findDecVal()));
            if (Integer.toHexString(row.findDecVal()).equals(row.getHexButtonValue())) {
                System.out.println("entered into if");
                gameArea.remove(row);
                gameType = 1;
                score++;
                run(gameType);
            }
        }
        //logic to remove row in binary to hex game mode
        else if (gameType == 2) {
            int sum = 0;
            int power = 0;
            String binNum = row.binNum.getText();
            char[] binArray = binNum.toCharArray();
            for (int i = binArray.length - 1; i >= 0; i--) {
                if (binArray[i] == '1') {
                    sum += Math.pow(2, power);
                }
                power++;
            }
            if (Integer.parseInt(row.getHexButtonValue(), 16) == sum) {
                gameArea.remove(row);
                score++;
                gameType = 2;
                run(gameType);
            }
        }
        //logic to remove row in hex to binary game mode
        else if (gameType == 3) {
            int sum = row.getButtonValuesSumBinary();
            int targetValue = row.findHexVal();
            if (sum == targetValue) {
                gameArea.remove(row);
                score++;
                gameType = 3;
                run(gameType);
            }
        }
    }

    private Row getCurrentRow() {
        //get current row
        for (int i = 0; i < gameArea.getComponentCount(); i++) {
            if (gameArea.getComponentAt(i) instanceof Row) {
                return (Row) gameArea.getComponentAt(i);
            }
        }
        return null;
    }


    public void run(int gameType) {
        //add row of game type parameter to gameArea container
        Row row = new Row(gameType);
        gameArea.add(row);
    }

    public void end() {
        //remove all elements from the gameArea container and reset gameType and score
        gameArea.removeAll();
        gameType = 0;
        score = 0;

        //enable gameMode buttons
        binaryToHex.setEnabled(true);
        hexToBinary.setEnabled(true);
        decimalToHex.setEnabled(true);

    }

}






