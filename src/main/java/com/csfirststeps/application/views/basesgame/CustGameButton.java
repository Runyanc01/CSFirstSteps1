package com.csfirststeps.application.views.basesgame;
import com.vaadin.flow.component.button.Button;

public class CustGameButton extends Button {

    //define data members
    int[] values = new int[8];
    int numClicks = 0;

    public CustGameButton(int[] values, int index){
        //set button text to 0 and style
        this.setText("0");
        this.getStyle()
                .set("max-width", "var(--lumo-size-xl)")
                .set("min-width", "var(--lumo-size-xl)");

        //add click listener to buttons to change text
        this.addClickListener(event -> { btnClicked(values, index);
            numClicks++;
        });
    }

    private void btnClicked(int[] values, int index) {
        //logic for setting button text after click
        if (numClicks == 0) {
            this.setText("1");
            values[index] = 1;
        } else {
            if (this.getText().equals("1")) {
                this.setText("0");
                values[index] = 0;
            } else {
                this.setText("1");
                values[index] = 1;
            }
        }

    }

}
