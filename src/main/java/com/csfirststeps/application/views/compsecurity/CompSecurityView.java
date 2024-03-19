package com.csfirststeps.application.views.compsecurity;

import com.csfirststeps.application.views.MainLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Networking and Security")
@Route(value = "compsecurity", layout = MainLayout.class)
public class CompSecurityView extends VerticalLayout {

    public CompSecurityView() {

    }
}
