package edu.proyectofinal.integradorrs.configurations;

import edu.proyectofinal.integradorrs.model.Token;
import edu.proyectofinal.integradorrs.services.usuario.UsuarioService;
import edu.proyectofinal.integradorrs.services.usuario.impl.UsuarioServiceImpl;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import static sun.rmi.transport.TransportConstants.Return;
import twitter4j.conf.ConfigurationBuilder;

/**
 *
 * @author Emi
 */
public class TwitterCredentials {
   
   //private UsuarioService usuarioService;
   private static TwitterCredentials credentials = null;

   private TwitterCredentials() { }
   private String OAuthConsumerKey = "ogIANEpF2RkLxvHrzO0Cu5sVi";
   private String OAuthConsumerSecret = "UbOselGMS6lmGQrey3NsjxO231UzWfOG8akh7Nhc6wbbxtBMQE";
   private String OAuthAccessToken;
   private String OAuthAccessTokenSecret;
           
   public static TwitterCredentials getInstance( ) {
      if(credentials == null)
      {
          credentials = new TwitterCredentials();
      }
       return credentials;
   }

   public ConfigurationBuilder GetCredentials(String email)
   {   
       Token token = GetToken(email);
      ConfigurationBuilder cb = new ConfigurationBuilder();
      cb.setDebugEnabled(true)
     .setOAuthConsumerKey(this.OAuthConsumerKey)
     .setOAuthConsumerSecret(this.OAuthConsumerSecret)
     .setOAuthAccessToken(token.getToken())
     .setOAuthAccessTokenSecret(token.getSecret());
      
      return cb;
   }

   public Token GetToken(String email)
   {
      RestTemplate restTemplate = new RestTemplate();
      Token atoken = restTemplate.getForObject("http://localhost:8080/api/usuario/token/twitter/email/emii.corsaro@gmail.com?socialnetwork=Twitter",Token.class);
      return atoken;
   }
}