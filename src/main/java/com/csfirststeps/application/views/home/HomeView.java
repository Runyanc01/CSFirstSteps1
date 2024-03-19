package com.csfirststeps.application.views.home;

import com.csfirststeps.application.views.MainLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@PageTitle("Home")
@Route(value = "home", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
public class HomeView extends VerticalLayout {

    public HomeView() {

        Div welcomeDiv = new Div();
        welcomeDiv.add(new H1("Welcome to CSFirstSteps"));
        HorizontalLayout welcomeText = new HorizontalLayout(welcomeDiv);
        welcomeText.addClassNames("welcome-text");

        add(welcomeText);


    }

}
