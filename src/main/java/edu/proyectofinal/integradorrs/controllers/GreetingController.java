package edu.proyectofinal.integradorrs.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.proyectofinal.integradorrs.model.AbstractModel;
import edu.proyectofinal.integradorrs.model.Greeting;

import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.twitter.api.Twitter;

@RestController
public class GreetingController<T extends AbstractModel> {

    private Twitter twitter;
    ConnectionRepository connectionRepository;
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {

        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @RequestMapping("/greetingtwitter")
    public Greeting helloTwitter() {
        if (connectionRepository.findPrimaryConnection(Twitter.class) == null) {

        }

        return new Greeting(counter.incrementAndGet(), String.format(template));
    }
}
