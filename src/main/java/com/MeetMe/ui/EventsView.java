package com.MeetMe.ui;

import com.MeetMe.backend.Event;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value="events", layout = MainLayout.class)
@PageTitle("MeetMe All Events")
public class EventsView extends Composite {
    VerticalLayout layout = new VerticalLayout();
    Grid<Event> grid = new Grid<>(Event.class);

    protected Component initContent(){
        configureGrid();
        layout.add(
                new H2("Events"),
                grid
        );

        layout.setAlignItems(FlexComponent.Alignment.CENTER);
        layout.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        return layout;
    }

    private void configureGrid() {
        grid.setSizeFull();
        grid.setColumns("title", "date", "location","description");
        //grid.addColumn(event -> event.getStatus().getName()).setHeader("");
        //grid.addColumn(contact -> contact.getCompany().getName()).setHeader("Company");
        grid.getColumns().forEach(col -> col.setAutoWidth(true));
    }
}
