package com.csfirststeps.application.views;

import com.csfirststeps.application.views.binarygame.BinaryGameDriver;
import com.csfirststeps.application.views.calculator.CalculatorWidget;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;

//define routing
@PageTitle("Binary Basics")
@Route(value = "binaryBasics", layout = MainLayout.class)

public class BinaryBasicsView extends VerticalLayout {

        //add data members and page layout structures
        private Span[] labelRow;
        VerticalLayout pageLayout = new VerticalLayout();

        public BinaryBasicsView() {

                //instantiate binary game and style
                BinaryGameDriver binGame = new BinaryGameDriver();
                binGame.getStyle().set("background-color", "var(--lumo-contrast-10pct)").set("border-radius", "15px");

                Span binGameTitle = new Span(new H2("Binary Conversion Game"));

                //create horizontal layout for calculator widget and reference table
                HorizontalLayout calcWithTable = new HorizontalLayout();
                calcWithTable.addClassNames(
                        LumoUtility.Padding.MEDIUM
                );

                //create binary reference table for game
                VerticalLayout twosTable = new VerticalLayout();
                labelRow = new Span[8];
                for (int i = 0; i <= 7; i++) {
                        labelRow[i] = new Span();
                        labelRow[i].getElement().setProperty("innerHTML", "2<sup>" + i + "</sup> =" + (int) Math.pow(2, i));
                        labelRow[i].getStyle()
                                .set("width", "60px")
                                .set("height", "36px")
                                .set("margin-left", "8px")
                                .set("margin-right", "8px");

                        twosTable.add(labelRow[i]);

                }

                //instantiate calculator widget and add to horizontal layout
                CalculatorWidget calculatorWidget = new CalculatorWidget();
                calcWithTable.add(calculatorWidget, twosTable);

                //create page content
                Span contentHeader = new Span(new H1("The Machine Language"));
                Div contentPane = new Div();
                Paragraph content = new Paragraph(new H4("The base-2 (binary) numbering system is particularly important in computing. " +
                        "The base in base-2 refers to the number of digits that base uses to represent any value, in this case, 2. " +
                        "For binary, these 2 digits are 0 and 1. At the lowest level of computing, all data is stored, retrieved, and manipulated in binary. " +
                        "In the game above, you are given a number in base-10 (decimal), the number system that is used in conventional mathematics. " +
                        "You are to use the buttons to the left of the decimal value to represent the number in binary. " +
                        "Don't worry, we'll show you how to convert before you have to play!"));
                contentPane.add(content);

                //create video pane
                Span videoHeader = new Span(new H3("Watch this video, then try the game!"));
                IFrame numberSystemsVid = new IFrame("https://www.youtube.com/embed/ku4KOFQ-bB4");
                numberSystemsVid.setHeight("400px");
                numberSystemsVid.setWidth("500px");
                numberSystemsVid.setAllow("accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture");
                numberSystemsVid.getElement().setAttribute("allowfullscreen", true);

                //add content to vertical layout
                pageLayout.add(contentHeader, contentPane, videoHeader, numberSystemsVid);
                pageLayout.addClassName(LumoUtility.Padding.LARGE);

                //add all content to view
                add(pageLayout, binGameTitle,binGame, calcWithTable);


        }
}
