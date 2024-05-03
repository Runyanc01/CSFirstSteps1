package com.csfirststeps.application.views;

import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;
import org.vaadin.addons.tatu.ColorPicker;

import java.util.Arrays;

//define routing
@PageTitle("Hexadecimal to Colors")
@Route(value = "hextocolors", layout = MainLayout.class)
public class HexToColorsView extends VerticalLayout {


    public HexToColorsView() {

        //create page content
        Span contentHeader = new Span(new H1("From Hex to Colors"));
        Div contentPane = new Div();
        Paragraph content = new Paragraph(new H4("Now that you have a solid understanding of hexadecimal, " +
                "we can begin our discussion of colors! Colors can be represented in several ways, but the major way that color is represented " +
                "and stored in memory is in hex. The 6-character hex code can be broken into 3 sets of 2 hex characters. Each set represents " +
                "the amount of either red, green, or blue that a color is made up of. The first set represents the red, the second set represents the green, and the third set the blue. " +
                "This is actually the same way you might have seen color represented in terms of \"RGB\" which just stands for red, green, and blue! " +
                "Because each set of 2 hex values is equal to 8 bits (one byte), they can store a total of 256 possible values, which is also why the max value " +
                "in RGB for any color is 255! The video below will go into more detail about RGB, but just remember that RGB is the decimal " +
                "representation of the hex code for a color!"));

        //add to div
        contentPane.add(content);

        //create video pane
        Span videoHeader = new Span(new H3("Watch this, then play with the color picker!"));
        IFrame colorVideo = new IFrame("https://www.youtube.com/embed/hhI4x6hx21s");
        colorVideo.setHeight("400px");
        colorVideo.setWidth("500px");
        colorVideo.setAllow("accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture");
        colorVideo.getElement().setAttribute("allowfullscreen", true);

        //define colorPicker container
        Div colorPickerContent = new Div();
        colorPickerContent.getStyle()
                .set("height", "150px");

        //instantiate colorPicker with preset colors
        Span colorPickerInstructions = new Span("Use the HEX input in the color picker, " +
                "and see if you can figure out how to make the colors you want in hex!");
        ColorPicker colorPicker = new ColorPicker();
        colorPicker.setHelperText("Try clicking the color window, and then click the \"RGB\" row until " +
                "you get to \"HEX,\" then type in the field!");
        colorPicker.setPresets(Arrays.asList(new ColorPicker.ColorPreset("#ff0000", "Red"),
                new ColorPicker.ColorPreset("#00ff00", "Green"),
                new ColorPicker.ColorPreset("#0000ff", "Blue"),
                new ColorPicker.ColorPreset("#ffff00", "Yellow"),
                new ColorPicker.ColorPreset("#ff00ff", "Purple"),
                new ColorPicker.ColorPreset("#ff7d00", "Orange")));

        //add to div
        Span colorPickerTitle = new Span(new H2("Hex Color Picker"));
        colorPickerContent.add(colorPickerTitle, colorPickerInstructions, colorPicker);
        colorPickerContent.addClassName(LumoUtility.Padding.XLARGE);

        //add content to view
        add(contentHeader, contentPane, videoHeader,colorVideo, colorPickerContent);

    }

}
