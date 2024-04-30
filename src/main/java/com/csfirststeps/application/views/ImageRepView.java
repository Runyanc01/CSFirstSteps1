package com.csfirststeps.application.views;

import com.csfirststeps.application.views.imagegame.ColorGrid;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.vaadin.addons.tatu.ColorPicker;

//define routing
@PageTitle("Images from Bits and Hex")
@Route(value = "imagerep", layout = MainLayout.class)
public class ImageRepView extends VerticalLayout {


    public ImageRepView() {

        //create content for images
        Span contentHeader = new Span(new H1("From Bits and Hex to Images and Videos"));
        Div contentPane = new Div();
        Paragraph imagesContent = new Paragraph(new H4("We've come a long way from binary and bits, all the way " +
                "to color, and now we're going to cover images and video! How can you take colors and turn them into " +
                "something more, like a picture or a video? Well, you can break down the image into smaller units that you " +
                "can represent as one color! This is called a picture element, or pixel. These pixels can be put together in " +
                "different ways with different colors to create any image. There are two main ways that images are stored: " +
                "pixel-by-pixel and as mathematical representations of lines. The first, called raster-graphics, are stored " +
                "as coordinates and hex colors in a couple of different formats. The simplest, bitmap(BMP), is simply that, " +
                "stored from left to right and bottom to top. Other formats include JPEG, Portable Network Graphics(PNG), and " +
                "Graphics Interchange Format(GIF). They differ in the way that they are compressed, as well as how they use color " +
                "to create clear images. The other way images are stored, called vector graphics, are stored as mathematical representations " +
                "of lines and geometric shapes. The lines and shapes also store their color and size. These tend to be smaller " +
                "when stored because they do not account for every single pixel. They are good for cartoon drawings and other simple graphics, " +
                "but are considered a poor choice for high-definition photography of real objects. JPEG is considered to be the " +
                "best filetype for that purpose."));

        //create content for videos
        Paragraph videoContent = new Paragraph(new H4("Video can be stored in similar ways to images in terms of data. " +
                "The biggest issue for video storage and representation is file size. Videos are usually stored as a compilation of " +
                "static images, called frames, a lot like the image storage we just talked about! Instead of raster-graphics or " +
                "vector graphics, however, videos are often stored as blocks of color as a way to condense the file. That way every " +
                "bit doesn't have to be stored individually, like in vector graphics. Videos can be compressed using a \"video codec\" " +
                "in 2 ways: they can be compressed by similarities in consecutive frames, or by similarities within a frame. How this " +
                "is done is a bit above the level of this intro class, so we'll just understand that it happens for now! There are 2 " +
                "videos below, one on bitmap images and their resolution, and the other is a much more in-depth look at JPEG and the H.264 " +
                "video codec and how they are compressed and stored. Watch them both, and then try and make your own bitmap image using the " +
                "interactive grid below!"));

        //add to vertical layout
        contentPane.add(imagesContent, videoContent);

        //create images video pane
        Span imgVidHeader = new Span(new H3("Watch this video about how images are stored!"));
        IFrame imageVideo = new IFrame("https://www.youtube.com/embed/0KmimFoalTI?si=mx7kVoTN-XxY8KSI");
        imageVideo.setHeight("400px");
        imageVideo.setWidth("500px");
        imageVideo.setAllow("accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture");
        imageVideo.getElement().setAttribute("allowfullscreen", true);

        //create video video pane
        Span detailedVideoHeader = new Span(new H3("Watch this video for a more in-depth look at JPEG and H.264 encoding!"));
        IFrame detailedVideo = new IFrame("https://www.youtube.com/embed/Kv1Hiv3ox8I");
        detailedVideo.setHeight("400px");
        detailedVideo.setWidth("500px");
        detailedVideo.setAllow("accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture");
        detailedVideo.getElement().setAttribute("allowfullscreen", true);

        //create bitmap game header
        Span pictureGridInstructions = new Span(new H3("Draw your own bitmap image using hex codes!"));

        //instantiate colorPicker
        ColorPicker colorPicker = new ColorPicker();

        //instantiate bitmap game grid
        ColorGrid pictureGrid = new ColorGrid();

        //add content to view
        add(contentHeader, contentPane, imgVidHeader, imageVideo, detailedVideoHeader, detailedVideo, pictureGridInstructions,pictureGrid, colorPicker);

    }

}
