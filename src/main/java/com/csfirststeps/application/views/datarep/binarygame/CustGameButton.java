package com.csfirststeps.application.views.datarep.binarygame;
import com.vaadin.flow.component.button.Button;

public class CustGameButton extends Button {

    int[] values = new int[8];
    int numClicks = 0;

    public CustGameButton(int[] values, int index){

        this.setText("0");
        this.getStyle()
                .set("max-width", "var(--lumo-size-xl)")
                .set("min-width", "var(--lumo-size-xl)");
        this.addClickListener(event -> { btnClicked(values, index);
            numClicks++;
        });
    }

    private void btnClicked(int[] values, int index) {

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
