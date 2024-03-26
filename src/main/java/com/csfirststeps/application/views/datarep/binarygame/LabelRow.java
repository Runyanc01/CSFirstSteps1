package com.csfirststeps.application.views.datarep.binarygame;

import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class LabelRow extends HorizontalLayout {

    private Span[] labelRow;

    public LabelRow() {

        this.labelRow = new Span[8];

        for (int i = 7; i >= 0; i--) {
            labelRow[i] = new Span();
            labelRow[i].getElement().setProperty("innerHTML", "2<sup>" + i + "<sup>");
            labelRow[i].getStyle()
                    .set("width", "32px")
                    .set("height", "36px")
                    .set("margin-left", "8px")
                    .set("margin-right", "8px");

            add(labelRow[i]);

        }


    }

}
