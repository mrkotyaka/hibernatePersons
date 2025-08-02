package ru.mrkotyaka.hibernatepersons.services;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @PreAuthorize("#username == authentication.principal.username")
    public String greetingUserSM(String username) {
        return "Greetings, my younger java developer, " + username;
    }
}
