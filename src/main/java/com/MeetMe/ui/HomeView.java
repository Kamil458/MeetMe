package com.MeetMe.ui;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;

@PageTitle("MeetMe!")
@Route("")
public class HomeView extends AppLayout {
    
    public HomeView() {
        DrawerToggle toggle = new DrawerToggle();

        H1 title = new H1("MeetMe!");
        title.getStyle()
                .set("font-size", "var(--lumo-font-size-l)")
                .set("margin", "0");

        Tabs tabs = getTabs();

        addToDrawer(tabs);
        addToNavbar(toggle, title);
    }

    private Tabs getTabs() {
        Tab events = new Tab(VaadinIcon.USERS.create());
        RouterLink home_link = new RouterLink("Events", HomeView.class);
        events.add(home_link);

        Tab addEvent = new Tab(VaadinIcon.PLUS.create());
        RouterLink add_link = new RouterLink("Add new event", AddView.class);
        addEvent.add(add_link);

        Tab login = new Tab(VaadinIcon.SHARE.create());
        RouterLink login_link = new RouterLink("Sign In", LoginView.class);
        login.add(login_link);

        Tab profile = new Tab(
                VaadinIcon.USER.create(),
                new Span("Profile")
        );
        Tab settings = new Tab(
                VaadinIcon.COG.create(),
                new Span("Settings")
        );
        Tab logout = new Tab(
                VaadinIcon.REPLY.create(),
                new Span("Logout")
        );

        profile.setEnabled(false);
        logout.setEnabled(false);

        Tabs tabs = new Tabs(events,addEvent,login,profile,settings,logout);
        tabs.setOrientation(Tabs.Orientation.VERTICAL);
        return tabs;
    }
}