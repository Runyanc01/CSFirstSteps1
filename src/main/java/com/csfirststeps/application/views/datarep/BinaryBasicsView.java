package com.csfirststeps.application.views.datarep;

import com.csfirststeps.application.views.MainLayout;
import com.csfirststeps.application.views.datarep.binarygame.BinaryGameDriver;
import com.csfirststeps.application.views.datarep.calculator.CalculatorWidget;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;


@PageTitle("Binary Basics")
@Route(value = "binaryBasics", layout = MainLayout.class)

public class BinaryBasicsView extends DataRepView {

        private Span[] labelRow;

        VerticalLayout pageLayout = new VerticalLayout();

        public BinaryBasicsView() {

                BinaryGameDriver binGame = new BinaryGameDriver();

                HorizontalLayout calcWithTable = new HorizontalLayout();

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

                CalculatorWidget calculatorWidget = new CalculatorWidget();

                calcWithTable.add(calculatorWidget, twosTable);

                Span contentHeader = new Span(new H1("The Machine Language"));

                Div contentPane = new Div();
                Paragraph content = new Paragraph(new H4("The base-2 (binary) numbering system is particularly important in computing. " +
                        "The base in base-2 refers to the number of digits that base uses to represent any value, in this case, 2. " +
                        "For binary, these 2 digits are 0 and 1. At the lowest level of computing, all data is stored, retrieved, and manipulated in binary. " +
                        "In the game above, you are given a number in base-10 (decimal), the number system that is used in conventional mathematics. " +
                        "You are to use the buttons to the left of the decimal value to represent the number in binary. " +
                        "Don't worry, we'll show you how to convert before you have to play!"));

                contentPane.add(content);

                Span videoHeader = new Span(new H3("Watch this video, then try the game!"));

                IFrame numberSystemsVid = new IFrame("https://www.youtube.com/embed/ku4KOFQ-bB4");
                numberSystemsVid.setHeight("400px");
                numberSystemsVid.setWidth("500px");
                numberSystemsVid.setAllow("accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture");
                numberSystemsVid.getElement().setAttribute("allowfullscreen", true);

                pageLayout.add(contentHeader, contentPane, videoHeader, numberSystemsVid);

                add(pageLayout, binGame, calcWithTable);


        }



}
