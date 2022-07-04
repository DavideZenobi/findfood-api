package io.spring.demo.events;

import org.springframework.context.ApplicationEvent;

import io.spring.demo.models.User;

public class OnRegistrationEvent extends ApplicationEvent {
    
    private User user;

    public OnRegistrationEvent(User user) {
        super(user);

        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
}
