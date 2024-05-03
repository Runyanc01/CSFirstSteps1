package com.csfirststeps.application.views;

import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.server.StreamResource;

//define routing
@PageTitle("Home")
@Route(value = "home", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
public class HomeView extends VerticalLayout {

    public HomeView() {

        //create welcome
        Div welcomeDiv = new Div();
        welcomeDiv.add(new H1("Welcome to CSFirstSteps"));
        HorizontalLayout welcomeText = new HorizontalLayout(welcomeDiv);
        welcomeText.addClassNames("welcome-text");

        //create content explaining website
        Paragraph content1 = new Paragraph(new H4("This website is meant to be a learning aid for the " +
                "intro class COMP-101 at Wittenberg University. It has been designed as an interactive, fun, " +
                "and engaging aid, but should be used as a supplement to class material."));
        Paragraph content2 = new Paragraph(new H4("We will cover the basics of data and data representation " +
                "as it relates to computer science. First, we will cover the machine language, binary, and how to " +
                "convert between it and decimal. Then, we will cover hexadecimal and its conversion to binary and decimal, and " +
                "then apply that to colors, images, and videos. Please use the interactive components included in each " +
                "section as examples and application-based supplements to the material presented. They have been designed " +
                "to be interactive, and are hopefully fun and helpful!"));


        //create image for home page
        Image laptop = new Image("/images/_2d3a6563-c054-4111-a7d1-1dadcc8ebc47.jpg", "CSFirst Steps Logo");
        laptop.setSizeFull();

        //add content to view
        add(welcomeText, laptop, content1, content2);

    }

}
