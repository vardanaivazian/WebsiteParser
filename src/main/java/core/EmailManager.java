package core;

/**
 * Created by Vardan Aivazian
 * Date: 4/12/2018
 * Time: 6:34 PM
 */
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailManager {
    
    private static final String FROM = "real@localhost.com";
    private static final String HOST = "localhost";
    private Session session;

    public EmailManager() {
        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.setProperty("mail.smtp.host", HOST);

        // Get the default Session object.
        this.session = Session.getDefaultInstance(properties);
    }

    public void sendEmail(String to, String messageSubject, String messageContent) {

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(FROM));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject(messageSubject);

            // Send the actual HTML message, as big as you like
            message.setText(messageContent);

            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }

    public static void main(String [] args) {
        // Recipient's email ID needs to be mentioned.
        String to = "nadrav27@gmail.com";

        // Sender's email ID needs to be mentioned
        String from = "vardan27a@gmail.com";

        // Assuming you are sending email from localhost
        String host = "localhost";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.setProperty("mail.smtp.host", host);

        // Get the default Session object.
        Session session = Session.getDefaultInstance(properties);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("This is the Subject Line!");

            // Send the actual HTML message, as big as you like
            message.setContent("<h1>This is actual message</h1>", "text/html");

            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}