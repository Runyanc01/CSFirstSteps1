package com.example.application.views.compbasics;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
@PageTitle("Computer Basics")
@Route(value = "compbasics", layout = MainLayout.class)
public class CompBasicsView extends VerticalLayout {

    public CompBasicsView() {

    }
}
