


public class Main {
    public static void main(String[] args) {

        mailConfig mail1 = new mailConfig("poczta.o2.pl", "zabinskimichal@o2.pl", "Zabka123", "michal@frognet.com.pl");

        if(true){
            mail1.sendMail(mail1.createConnection(), "temat", "dzis mamy spadki na rynku");
        }

    }
}