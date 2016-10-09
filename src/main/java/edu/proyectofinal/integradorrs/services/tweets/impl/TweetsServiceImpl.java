/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.proyectofinal.integradorrs.services.tweets.impl;

import edu.proyectofinal.integradorrs.configurations.TwitterCredentials;
import edu.proyectofinal.integradorrs.model.TweetsModel;
import edu.proyectofinal.integradorrs.repositorys.TweetsRepository;
import edu.proyectofinal.integradorrs.services.tweets.TweetsService;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import twitter4j.Paging;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 *
 * @author MarianoAndres
 */
@Service
public class TweetsServiceImpl implements TweetsService {

    @Autowired
    private TweetsRepository repository;

    @Override
    public Collection<Status> getAllTweets(String email) {
     
     TwitterCredentials tc = TwitterCredentials.getInstance();
     ConfigurationBuilder cb = tc.GetCredentials(email);
    
     TwitterFactory tf = new TwitterFactory(cb.build());
     Twitter twitter = tf.getInstance();
       List<Status> statuses = null;
        try {
            statuses = twitter.getHomeTimeline();
        } catch (TwitterException ex) {
            Logger.getLogger(TweetsServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        Collection<Status> result = (Collection<Status>)statuses;
        return result;

    }

    @Override
    public Collection<Status> getUserTimeline(String user, String email) {
     TwitterCredentials tc = TwitterCredentials.getInstance();
     ConfigurationBuilder cb = tc.GetCredentials(email);
    
     TwitterFactory tf = new TwitterFactory(cb.build());
     Twitter twitter = tf.getInstance();
     List<Status> statuses = null;    
     Paging paging = new Paging(1, 30);
        try {
            statuses = twitter.getUserTimeline(user, paging);
        } catch (TwitterException ex) {
            Logger.getLogger(TweetsServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
      Collection<Status> result = (Collection<Status>)statuses;
      return result;
    }

    
}
