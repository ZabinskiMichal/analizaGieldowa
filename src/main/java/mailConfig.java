import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;



public class mailConfig {
    private String host;
    private String fromWhichAccount;
    private String passowrd;
    private String toWhichAccount;
    private String domena;
    private String auth;


    public mailConfig(String host, String fromWhichAccount, String passowrd, String toWhichAccount){
        this.host = host;
        this.fromWhichAccount = fromWhichAccount;
        this.passowrd = passowrd;
        this.toWhichAccount = toWhichAccount;
        this.domena = "mail.smtp.host";
        this.auth = "mail.smtp.auth";
    }



    public Session createConnection(){
        Properties props = new Properties();
        props.put(this.domena, this.host);
        props.put(this.auth, "true");

        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromWhichAccount,passowrd);
            }
        });

        return session;
    }


    public void sendMail(Session session, String topic, String text){
        try{
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromWhichAccount));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(toWhichAccount));
            message.setSubject(topic);
            message.setText(text);

            //send the message
            Transport.send(message);

            System.out.println("Success, mail send");

        }catch (MessagingException e){
            e.printStackTrace();

        }
    }


}
