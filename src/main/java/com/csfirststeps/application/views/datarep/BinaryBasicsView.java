package com.csfirststeps.application.views.datarep;

import com.csfirststeps.application.views.MainLayout;
import com.csfirststeps.application.views.datarep.binarygame.BinaryGameDriver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;


@PageTitle("Binary Basics")
@Route(value = "binaryBasics", layout = MainLayout.class)

public class BinaryBasicsView extends DataRepView{

        public BinaryBasicsView() {

                BinaryGameDriver binGame = new BinaryGameDriver();

                add(binGame);


        }



}
