package com.csfirststeps.application.views;

import com.csfirststeps.application.views.basesgame.BaseConvertGameDriver;
import com.csfirststeps.application.views.calculator.CalculatorWidget;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;

@PageTitle("Convert Bases for Beginners")
@Route(value = "convertbases", layout = MainLayout.class)
public class ConvertBasesView extends VerticalLayout {

    Span[] labelRow;

    public ConvertBasesView() {

        //create layout structures
        VerticalLayout pageLayout = new VerticalLayout();
        HorizontalLayout calcWithTable = new HorizontalLayout();
        VerticalLayout twosTable = new VerticalLayout();

        //create binary table for gae reference
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

        //create hex table for game reference
        VerticalLayout hexTable = new VerticalLayout();
        Span[] hexLabelRow = new Span[3];
        for (int i = 0; i <= 2; i++) {
            hexLabelRow[i] = new Span();
            hexLabelRow[i].getElement().setProperty("innerHTML", "16<sup>" + i + "</sup> =" + String.valueOf((int) Math.pow(16, i)));
            hexLabelRow[i].getStyle()
                    .set("width", "70px")
                    .set("height", "36px")
                    .set("margin-left", "8px")
                    .set("margin-right", "8px");

            hexTable.add(hexLabelRow[i]);
        }

        //create table of decimal to hex for game reference
        VerticalLayout hexValueTableColumn = new VerticalLayout();
        HorizontalLayout hexValueTable = new HorizontalLayout();
        Span[] hexValueRow = new Span[16];
        for (int i = 0; i <= 15; i ++) {
            hexValueRow[i] = new Span();
            hexValueRow[i].setText(i + " = "  + Integer.toHexString(i));
            hexValueRow[i].getStyle()
                    .set("width", "60px")
                    .set("height", "36px")
                    .set("margin-left", "8px")
                    .set("margin-right", "8px");

            hexValueTableColumn.add(hexValueRow[i]);

            if (hexValueTableColumn.getComponentCount() == 8) {
                hexValueTable.add(hexValueTableColumn);
                hexValueTableColumn = new VerticalLayout();
            }
        }

        //instantiate calculator widget class
        CalculatorWidget calculatorWidget = new CalculatorWidget();

        //add to horizontal layout
        calcWithTable.add(calculatorWidget, twosTable, hexTable, hexValueTable);
        calcWithTable.addClassNames(LumoUtility.Padding.Top.SMALL);


        //create page content
        Span contentHeader = new Span(new H1("Base Conversion"));
        Div contentPane = new Div();
        Paragraph content = new Paragraph(new H4("You're well on your way to taking your first steps into the world of " +
                "computer science, beginning with how data is stored and represented! " +
                "Next, we're going to cover converting between other bases besides base 2 (binary) and base 10 (decimal). " +
                "Another important base in computing systems is hexadecimal, or base 16. That means we use 16 symbols to represent any value. " +
                "You might be wondering, where are we going to get 16 distinct symbols when there are only 9? We are going to use letters " +
                "to fill in the remaining 6 symbols, A, B, C, D, E, and F. What comes after F? 10! The base number tells you what number in decimal " +
                "is going to be represented by the symbols \"10\". " +
                "Just like 2 in binary is 10 and the number ten in decimal is 10, 16 is represented as 10 in hex (short for hexadecimal). " +
                "The same can be said for other bases like base 8, or octal. The decimal number 8 is represented as 10 in octal! " +
                "With this information, we can start converting! Watch the video below, then try the game! It's very similar to the binary game in the " +
                "section before, but now you can choose to convert between any of the bases we've talked about so far! Have fun!"));

        contentPane.add(content);

        //create video pane
        Span videoHeader = new Span(new H3("Watch this video explaining converting bases using the remainder method"));
        IFrame convertBasesVid = new IFrame("https://www.youtube.com/embed/hXVr8CG6YUM");
        convertBasesVid.setHeight("400px");
        convertBasesVid.setWidth("500px");
        convertBasesVid.setAllow("accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture");
        convertBasesVid.getElement().setAttribute("allowfullscreen", true);
        convertBasesVid.addClassName(LumoUtility.Margin.Top.SMALL);
        Div videoFrame = new Div(videoHeader, convertBasesVid);

        //instantiate base conversion game
        BaseConvertGameDriver baseGame = new BaseConvertGameDriver();
        baseGame.getStyle().set("background-color", "var(--lumo-contrast-10pct)").set("border-radius", "15px");
        baseGame.addClassName(LumoUtility.Margin.Top.LARGE);
        Span baseGameTitle = new Span(new H2("Base Conversion Game"));
        baseGameTitle.addClassName(LumoUtility.Padding.Top.LARGE);

        //add all elements to vertical layout
        pageLayout.add(contentHeader, contentPane, videoFrame, baseGameTitle,baseGame, calcWithTable);

        //add vertical layout to view
        add(pageLayout);

    }
}
