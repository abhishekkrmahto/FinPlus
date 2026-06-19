package services;

import java.util.Properties;
import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import models.Account;
import privateFiles.PrivateFiles;

public class EmailService {

    static PrivateFiles credentials = new PrivateFiles();

    static private final String fromEmail = credentials.getFromEmail().trim();
    static private final String password = credentials.getPassword().trim();

    public void accountCreationSuccessMail(Account account) {

        String toEmail = account.getEmail();

        // 1. prop banao
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        // 2. session banao

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            message.setSubject("FinPlus Bank - Your Account Has Been Created Successfully");

            // html formate mai email bhejo
            String htmlText = "<div style='font-family: Arial, sans-serif; max-width: 600px; margin: 0 auto;'>"
                    + "  <div style='font-size: 32px; font-weight: 900; font-family: \"Arial Black\", Gadget, sans-serif; "
                    + "              letter-spacing: 2px; display: inline-block; "
                    + "              background: linear-gradient(135deg, #f0f0f0 0%, #b8b8b8 25%, #ffffff 50%, #8a8a8a 75%, #a6a6a6 100%); "
                    + "              -webkit-background-clip: text; -webkit-text-fill-color: transparent; "
                    + "              filter: drop-shadow(0px 2px 4px rgba(0,0,0,0.15)) drop-shadow(0px 0px 10px rgba(255,255,255,0.6));'>"
                    + "    FINPLUS"
                    + "  </div><br><br>"
                    + "  <hr style='border: 0; border-top: 1px solid #eee;'>"
                    + "  <p>Dear Customer,</p>"
                    + "  <p>Hello! I am Abhishek (Founder and CEO) Welcomes you in our Bank.</p>"
                    + "  <p>Thank you for choosing <b>FinPlus</b>. We are excited to help you manage your finances smarter.</p>"
                    + "  <p><b>Account Details:-</b></p>"
                    + "  <p>Name:- " + account.getName().toUpperCase() + "</p>"
                    + "  <p>Account Number:- " + String.valueOf(account.getAccountNumber()) + "</p>"
                    + "  <p>Current Balance:- " + String.valueOf(account.getBalance()) + "</p>"
                    + "  <br>"
                    + "  <p>Best Regards,<br><b>FinPlus Team</b></p>"
                    + "</div>";

            message.setContent(htmlText, "text/html; charset=utf-8");

            Transport.send(message);
            System.out.println("Success: Email sent successfully");

        } catch (Exception e) {
            System.out.println("Error: Sending email unsuccessfully.");
            e.printStackTrace();
        }
    }

    public void balanceAddedSuccessfullyMail(Account account) {
        String toEmail = account.getEmail();

        // 1. prop banao
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        // 2. session banao

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            message.setSubject("FinPlus Bank - Amount Deposited Successfully");

            // html formate mai email bhejo
            String htmlText = "<div style='font-family: Arial, sans-serif; max-width: 600px; margin: 0 auto;'>"
                    + "  <div style='font-size: 32px; font-weight: 900; font-family: \"Arial Black\", Gadget, sans-serif; "
                    + "              letter-spacing: 2px; display: inline-block; "
                    + "              background: linear-gradient(135deg, #f0f0f0 0%, #b8b8b8 25%, #ffffff 50%, #8a8a8a 75%, #a6a6a6 100%); "
                    + "              -webkit-background-clip: text; -webkit-text-fill-color: transparent; "
                    + "              filter: drop-shadow(0px 2px 4px rgba(0,0,0,0.15)) drop-shadow(0px 0px 10px rgba(255,255,255,0.6));'>"
                    + "    FINPLUS"
                    + "  </div><br><br>"
                    + "  <hr style='border: 0; border-top: 1px solid #eee;'>"
                    + "  <p>Dear Customer,</p>"
                    + "  <p>Hello! I am Abhishek (Founder and CEO)</p>"
                    + "  <p>Thank you for choosing <b>FinPlus</b>. Your amount is deposited successfully .</p>"
                    + "  <p><b>Account Details:-</b></p>"
                    + "  <p>Name:- " + account.getName().toUpperCase() + "</p>"
                    + "  <p>Account Number:- " + String.valueOf(account.getAccountNumber()) + "</p>"
                    + "  <p>Current Balance:- " + String.valueOf(account.getBalance()) + "</p>"
                    + "  <br>"
                    + "  <p>Best Regards,<br><b>FinPlus Team</b></p>"
                    + "</div>";

            message.setContent(htmlText, "text/html; charset=utf-8");

            Transport.send(message);
            System.out.println("Success: Email sent successfully");

        } catch (Exception e) {
            System.out.println("Error: Sending email unsuccessfully.");
            e.printStackTrace();
        }

    }

}