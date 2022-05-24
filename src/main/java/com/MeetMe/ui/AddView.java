package com.MeetMe.ui;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.datetimepicker.DateTimePicker;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.time.Duration;

@PageTitle("MeetMe create event")
@Route(value="add", layout = MainLayout.class)
public class AddView extends Composite {

    protected Component initContent() {
        TextArea title = new TextArea("Title");
        title.setWidth("25%");
        title.setRequired(true);


        TextArea localization = new TextArea("Localization");
        localization.setWidth("25%");
        localization.setRequired(true);

        TextArea description = new TextArea("Description");
        description.setWidth("25%");
        description.setRequired(true);

        DateTimePicker dateTimePicker = new DateTimePicker();
        dateTimePicker.setLabel("Meeting date and time");
        dateTimePicker.setStep(Duration.ofMinutes(15));
        dateTimePicker.setWidth("25%");

        Button createButton = new Button("Create");
        createButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        VerticalLayout layout = new VerticalLayout(
                new H2("Create your own event!"),
                title,
                dateTimePicker,
                localization,
                description,
                createButton
        );

        layout.setAlignItems(FlexComponent.Alignment.CENTER);
        layout.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        return layout;
    }
}
