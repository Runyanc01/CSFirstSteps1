package com.csfirststeps.application.views.imagegame;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;


public class Cell extends Button {

    //define data members
    private String defaultColor = "#ffffff";
    private String hexColor = defaultColor;


    public Cell() {

        //style cells
        this.setMaxHeight("20px");
        this.setMinHeight("20px");
        this.setMaxWidth("20px");
        this.setMinWidth("20px");
        this.getStyle()
                .set("padding", "0")
                .set("margin", "1px")
                .set("border-radius", "0")
                .set("border-color", "black")
                .set("border-thickness", "1px")
                .set("background-color", defaultColor);

        //add click listener to cell
        this.addClickListener(e -> showColorDialog());

    }


    public void updateColor(Cell cell, String color) {
        //test color reading
        System.out.println("Updating color to: " + color);

        //change cell background color to color parameter
        cell.getElement().getStyle().set("background-color", color);
    }

    public void showColorDialog() {
        //instantiate dialog for color selection
        Dialog colorPicker = new Dialog();
        colorPicker.setHeaderTitle("Color Select");

        //define dialog layout and add to dialog
        VerticalLayout dialogLayout = createDialogLayout();
        colorPicker.add(dialogLayout);

        //define save button
        Button save = new Button("Save", e -> {

            //capture text field of dialog
            TextField colorSelect = (TextField) dialogLayout.getComponentAt(0);
            String newColor = colorSelect.getValue();
            System.out.println("Selected color: " + newColor);

            //check if entered value is valid hex and update color if true
            if (isValidHexColor(newColor)) {
                hexColor = newColor;
                if(newColor.contains("#")) {
                    updateColor(this, hexColor);
                } else {
                    hexColor = "#" + hexColor;
                    updateColor(this, hexColor);
                }
                colorPicker.close();
            } else {
                colorSelect.setInvalid(true);
            }
            });

        //make save primary button variant
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        //define cancel button
        Button cancel = new Button("Cancel", e-> colorPicker.close());

        //add buttons to footer
        colorPicker.getFooter().add(cancel);
        colorPicker.getFooter().add(save);

        //add footer elements to dialog
        colorPicker.add(cancel, save);

        //open dialog when cell is clicked
        colorPicker.open();

    }

    public VerticalLayout createDialogLayout() {

        //define dialog layout
        VerticalLayout dialogLayout = new VerticalLayout();
        TextField colorSelect = new TextField("Color code select");
        colorSelect.setClearButtonVisible(true);
        colorSelect.setPrefixComponent(VaadinIcon.PAINTBRUSH.create());

        //add components to layout and return layout
        dialogLayout.add(colorSelect);
        return dialogLayout;


    }

    private boolean isValidHexColor(String color) {

        //if "#" present in entered text, remove it
        color = color.replaceAll("^#", "");

        //convert text to lowercase
        color = color.toLowerCase();
        System.out.println("Input color: " + color);

        //compare input to regular expression to verify valid hex code
        boolean isValid = color.matches("^[a-f0-9]{6}$");
        System.out.println("Is valid color? " + isValid);
        return isValid;
    }

    public String getColor() {
        //return hex color
        return hexColor;
    }
}
