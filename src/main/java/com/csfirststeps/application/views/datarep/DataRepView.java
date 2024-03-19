package com.csfirststeps.application.views.datarep;

import com.csfirststeps.application.views.MainLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Data Representation")
@Route(value = "datarep", layout = MainLayout.class)
public class DataRepView extends VerticalLayout {

    public DataRepView() {

    }

}
