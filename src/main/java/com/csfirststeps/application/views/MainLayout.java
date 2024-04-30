package com.csfirststeps.application.views;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.Footer;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.SvgIcon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.server.StreamResource;
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
        //Create drawer for menu
        DrawerToggle toggle = new DrawerToggle();
        toggle.setAriaLabel("Menu toggle");

        //Add title of view to header
        viewTitle = new H2();
        viewTitle.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.NONE);

        //add to navbar
        addToNavbar(true, toggle, viewTitle);
    }

    private void addDrawerContent() {
        //Add app name to menu drawer with icon in header
        H1 appName = new H1("CSFirstSteps");
        appName.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.NONE);
        Icon icon = new Icon(VaadinIcon.ACADEMY_CAP);
        icon.setSize(LumoUtility.IconSize.MEDIUM);
        Header header = new Header(icon, appName);

        //create scroller
        Scroller scroller = new Scroller(createNavigation());

        //add to menu drawer
        addToDrawer(header, scroller, createFooter());
    }

    private SideNav createNavigation() {
        //create sidenav
        SideNav nav = new SideNav();

        //define sidenav items and icons
        SideNavItem home = new SideNavItem("Home", HomeView.class, LineAwesomeIcon.HOME_SOLID.create());
        SideNavItem binBasics = new SideNavItem("Binary Basics", BinaryBasicsView.class, VaadinIcon.HARDDRIVE.create());
        SideNavItem convertBases = new SideNavItem("Convert Bases for Beginners", ConvertBasesView.class, VaadinIcon.FUNCTION.create());
        SideNavItem hexToColors = new SideNavItem("Hexadecimal to Colors", HexToColorsView.class, VaadinIcon.PAINT_ROLL.create());
        SideNavItem images = new SideNavItem("Images from Bits and Hex", ImageRepView.class, VaadinIcon.PICTURE.create());

        //add to nav
        nav.addItem(home, binBasics, convertBases, hexToColors, images);
        return nav;
    }

    private Footer createFooter() {
        //create footer
        Footer layout = new Footer();

        return layout;
    }

    @Override
    protected void afterNavigation() {
        //load view after navigation and set page title to view title
        super.afterNavigation();
        viewTitle.setText(getCurrentPageTitle());
    }

    private String getCurrentPageTitle() {
        //get the page title of current view
        PageTitle title = getContent().getClass().getAnnotation(PageTitle.class);
        return title == null ? "" : title.value();
    }
}
