package util;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class MailSender {

    public static void sendMail(String to, String subject, String textMessage) {
        final String from = "Akilaudantha09@gmail.com";   // your email
        final String password = "orfl zpmr zikm ltaq"; // Gmail App Password

        // SMTP properties
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(
                    Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(textMessage);

            Transport.send(message);
            System.out.println("✅ Email sent to " + to);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
