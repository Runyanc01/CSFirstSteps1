package com.csfirststeps.application.views.imagegame;

import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class ColorGrid extends VerticalLayout {

    //define data members
    private final int GRID_SIZE = 100;

    public ColorGrid() {

        //add cells to grid
        addCells();
    }

    private void addCells() {

        //create flex layout that wraps after 10 cells
        FlexLayout flexLayout = new FlexLayout();
        flexLayout.setFlexWrap(FlexLayout.FlexWrap.WRAP);
        flexLayout.setMaxWidth("220px");

        //create cells and add to flex layout
        for (int i = 0; i < GRID_SIZE; i++) {
            Cell cell = new Cell();
            flexLayout.add(cell);
        }

        //add flex layout to component layout
        add(flexLayout);
    }


}