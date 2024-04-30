package com.csfirststeps.application.views.basesgame;

import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class HexLabelRow extends HorizontalLayout {

    private Span[] labelRow;

    public HexLabelRow() {
        //create hex label row for game reference
        this.labelRow = new Span[8];
        for (int i = 3; i >= 0; i--) {
            labelRow[i] = new Span();
            labelRow[i].getElement().setProperty("innerHTML", "16<sup>" + i + "<sup>");
            labelRow[i].getStyle()
                    .set("width", "50px")
                    .set("height", "36px")
                    .set("margin-left", "20px")
                    .set("margin-right", "20px");

            add(labelRow[i]);

        }
    }

}
