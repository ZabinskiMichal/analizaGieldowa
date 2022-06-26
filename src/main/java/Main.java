//import javax.mail.MessagingException;
//import javax.mail.Transport;
//import javax.mail.internet.MimeMessage;
//import javax.sql.rowset.serial.SerialStruct;
//
//
////to utworzenia mail sendera wykorzystamy protokoł SMTP, czyli standart mail sender protocol
//
//
////bedziemy musieli skonfigurowac
////1) polacznie z protokolem SNTP
////2)  autorzacje z poczta email
//
//
//public class Main {
//
//    public static void main (String[] args){
//
//        try{
//            MimeMessage message = MailMessagePrepare.prepareTextMessageObject("michal@frognet.com.pl", "tutlEmaila", "elo mordeczko");
//            Transport.send(message);
//
//        }catch (MessagingException e){
//            throw new RuntimeException(e.getMessage());
//
//        }
//
//    }
//}

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {

        String host="poczta.o2.pl";
        final String user="zabinskimichal@o2.pl";//change accordingly
        final String password="Zabka123";//change accordingly

        String to="michal@frognet.com.pl";//change accordingly

        //Get the session object
        Properties props = new Properties();
        props.put("mail.smtp.host",host);
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(user,password);
                    }
                });

        //Compose the message
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
            message.setSubject("javatpoint");
            message.setText("This is simple program of sending email using JavaMail API");

            //send the message
            Transport.send(message);

            System.out.println("message sent successfully...");

        } catch (MessagingException e) {e.printStackTrace();}
    }
}