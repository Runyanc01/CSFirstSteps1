package com.csfirststeps.application.views.basesgame;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.Span;

import java.util.Random;

public class Row extends Span {

    //define data members
    Random random;
    int randNum;
    Span decVal = new Span();
    Span binNum = new Span();
    Span hexNum = new Span();
    StringBuffer hexButtons = new StringBuffer();
    ComboBox[] userHex = new ComboBox[4];
    private CustGameButton[] buttons = new CustGameButton[8];

    public Row(int gameMode) {

        //instantiate random and create int array
        this.random = new Random();
        int[] values = new int[8];

        //get value of random number in each base
        int targetNum = getDecimalValue();
        String binaryNum = getBinaryValue();
        String hexVal = getHexValue();

        //create container and deVal and style
        Span container = new Span();
        decVal.setText(String.valueOf(targetNum));
        decVal.getStyle()
                .set("height", "50px")
                .set("width", "60px")
                .set("margin-left", "8px");

        //style binNum container
        binNum.setText(binaryNum);
        binNum.getStyle()
                .set("height", "50px")
                .set("width", "120px")
                .set("margin-left", "8px");

        //style hexNum container
        hexNum.setText(hexVal);
        hexNum.getStyle()
                .set("height", "50px")
                .set("width", "70px")
                .set("margin-left", "8px");

        //create switch for game mode selection
        switch (gameMode) {
            case 1:
                //logic for decimal to hex game mode generation
                for (int i = 0; i < 4; i++) {
                    userHex[i] = new ComboBox();
                    userHex[i].getStyle()
                            .set("max-width", "100px")
                            .set("min-width", "100px");
                    userHex[i].setItems("0","1","2","3","4","5","6","7","8", "9", "a", "b", "c", "d", "e", "f");
                    container.add(userHex[i]);
                }
                container.add(decVal);
                break;
            case 2:
                //logic for binary to hex game mode generation
                for (int i = 0; i < 4; i++) {
                    userHex[i] = new ComboBox();
                    userHex[i].getStyle()
                            .set("max-width", "100px")
                            .set("min-width", "100px");
                    userHex[i].setItems("0","1","2","3","4","5","6","7","8", "9", "a", "b", "c", "d", "e", "f");
                    container.add(userHex[i]);
                }
                container.add(binNum);
                break;
            case 3:
                //logic for hex to binary game mode generation
                for (int i = 0; i < 8; i++) {
                    buttons[i] = new CustGameButton(values, i);
                    buttons[i].getStyle().set("margin-left", "8px");
                    buttons[i].getStyle().set("background-color", "var(--lumo-base-color)");
                    buttons[i].getStyle().set("color", "white");
                    container.add(buttons[i]);
                }
                container.add(hexNum);
                break;
        }
        //add container to component view
        add(container);
    }

    public int getButtonValuesSumBinary() {
        //define power and sum
        int sum = 0;
        int power = 0;

        //use position and text to determine binary value of buttons in decimal
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
        //generate random number from 1-128 inclusive in decimal
        randNum = random.nextInt(128) +1;
        System.out.println("Rand num: " + randNum);
        return randNum;
    }

    public String getBinaryValue() {
        //generate random number from 1-128 inclusive in binary
        randNum = random.nextInt(128) + 1;
        String binNum = Integer.toBinaryString(randNum);
        while (binNum.length() < 8) {
            binNum = "0" + binNum;
        }
        System.out.println("Rand num: " + binNum);
        return binNum;
    }

    public String getHexValue() {
        //generate random number from 1-128 inclusive in hex
        randNum = random.nextInt(128) + 1;
        String hexVal = Integer.toHexString(randNum);
        System.out.println("Rand num = " + hexVal);
        return hexVal;
    }

    public int findDecVal() {
        //get decimal value
        int target;
        target = Integer.parseInt(decVal.getText());
        System.out.println("decVal: " + target);
        return target;
    }

    public int findHexVal() {
        //get hex value
        int target;
        target = Integer.parseInt(hexNum.getText(), 16);
        System.out.println("hexVal: " + target);
        return target;
    }

    public String getHexButtonValue() {
        //get value of hex buttons in string form
        for (int i = 0; i < userHex.length; i ++){
            if (userHex[i].getValue() != null) {
                hexButtons.append(userHex[i].getValue());
            }
        }
        System.out.println(hexButtons.toString());
        return hexButtons.toString();
    }



}
