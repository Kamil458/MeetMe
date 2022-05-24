package com.MeetMe.ui;

import com.MeetMe.backend.DatabaseConnection;
import com.MeetMe.backend.Event;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.List;

@Route(value="events", layout = MainLayout.class)
@PageTitle("MeetMe All Events")
public class EventsView extends Composite {
    VerticalLayout layout = new VerticalLayout();
    Grid<Event> grid = new Grid<>(Event.class,false);

    protected Component initContent(){
        configureGrid();
        layout.setAlignItems(FlexComponent.Alignment.CENTER);
        layout.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layout.add(
                new H2("Events"),
                grid
        );
        return layout;
    }

    private void configureGrid() {
        grid.addColumn(Event::getTitle).setHeader("Title");
        grid.addColumn(Event::getDate).setHeader("Date");
        grid.addColumn(Event::getLocation).setHeader("Location");
        grid.setItemDetailsRenderer(createPersonDetailsRenderer());
        grid.setAllRowsVisible(true);
        grid.setWidth("80%");

        DatabaseConnection databaseConnection = new DatabaseConnection();
        List<Event> people = databaseConnection.getEvents();

        grid.setItems(people);
    }

    private static ComponentRenderer<EventDetailsFormLayout, Event> createPersonDetailsRenderer() {
        return new ComponentRenderer<>(EventDetailsFormLayout::new,
                EventDetailsFormLayout::setEvent);
    }
}
