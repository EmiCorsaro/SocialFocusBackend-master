/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.proyectofinal.integradorrs.services.tweets;

import java.util.Collection;
import twitter4j.Status;

/**
 *
 * @author MarianoAndres
 */
public interface TweetsService {
    
    	Collection<Status> getAllTweets(String email);

        Collection<Status> getUserTimeline(String user, String email);
    
}
