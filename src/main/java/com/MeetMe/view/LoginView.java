package com.MeetMe.view;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.router.Route;
import org.springframework.web.bind.annotation.GetMapping;

public class LoginView extends Composite<LoginOverlay> {
    public LoginView(){
        LoginOverlay loginOverlay = getContent();
        loginOverlay.setTitle("MeetMe");
        loginOverlay.setDescription("Click and meet me!");
        loginOverlay.setOpened(true);

        // login listener
        loginOverlay.addLoginListener(loginEvent -> {

        });
    }
}
