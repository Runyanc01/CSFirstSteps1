package com.csfirststeps.application.views;

import com.csfirststeps.application.views.datarep.*;
import com.csfirststeps.application.views.compsecurity.CompSecurityView;
import com.csfirststeps.application.views.compbasics.CompBasicsView;
import com.csfirststeps.application.views.home.HomeView;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.Footer;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.theme.lumo.LumoUtility;
import org.vaadin.lineawesome.LineAwesomeIcon;

public class MainLayout extends AppLayout {

    private H2 viewTitle;

    public MainLayout() {
        setPrimarySection(Section.DRAWER);
        addDrawerContent();
        addHeaderContent();
    }

    private void addHeaderContent() {
        DrawerToggle toggle = new DrawerToggle();
        toggle.setAriaLabel("Menu toggle");

        viewTitle = new H2();
        viewTitle.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.NONE);

        addToNavbar(true, toggle, viewTitle);
    }

    private void addDrawerContent() {
        H1 appName = new H1("CSFirstSteps");
        appName.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.NONE);
        Header header = new Header(appName);

        Scroller scroller = new Scroller(createNavigation());

        addToDrawer(header, scroller, createFooter());
    }

    private SideNav createNavigation() {
        SideNav nav = new SideNav();

        SideNavItem home = new SideNavItem("Home", HomeView.class, LineAwesomeIcon.GLOBE_SOLID.create());
        SideNavItem dataRep = new SideNavItem("Data Representation", DataRepView.class, LineAwesomeIcon.BOOK_SOLID.create());
        SideNavItem compBasics = new SideNavItem("Computer Basics", CompBasicsView.class, LineAwesomeIcon.HARD_HAT_SOLID.create());
        SideNavItem netsAndSecurity = new SideNavItem("Networking and Security", CompSecurityView.class, LineAwesomeIcon.NETWORK_WIRED_SOLID.create());

        dataRep.addItem(new SideNavItem("Binary Basics", BinaryBasicsView.class));
        dataRep.addItem(new SideNavItem("Convert Bases for Beginners", ConvertBasesView.class));
        dataRep.addItem(new SideNavItem("Hexadecimal to Colors", HexToColorsView.class));
        dataRep.addItem(new SideNavItem("Images from Bits and Hex", ImageRepView.class));
        dataRep.addItem(new SideNavItem("Text from Bits", TextRepView.class));

        nav.addItem(home, dataRep, compBasics, netsAndSecurity);
        return nav;
    }

    private Footer createFooter() {
        Footer layout = new Footer();

        return layout;
    }

    @Override
    protected void afterNavigation() {
        super.afterNavigation();
        viewTitle.setText(getCurrentPageTitle());
    }

    private String getCurrentPageTitle() {
        PageTitle title = getContent().getClass().getAnnotation(PageTitle.class);
        return title == null ? "" : title.value();
    }
}
