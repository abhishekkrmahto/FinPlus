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
import utils.HtmlUtil;

public class EmailService {

    static PrivateFiles credentials = new PrivateFiles();

    static private final String fromEmail = credentials.getFromEmail().trim();
    static private final String password = credentials.getPassword().trim();

    HtmlUtil htmlUtil = new HtmlUtil();

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

            String htmlText = htmlUtil.accountCreationHTML(account);

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

            String htmlText = htmlUtil.accountDepositHTML(account);

            message.setContent(htmlText, "text/html; charset=utf-8");

            Transport.send(message);
            System.out.println("Success: Email sent successfully");

        } catch (Exception e) {
            System.out.println("Error: Sending email unsuccessfully.");
            e.printStackTrace();
        }

    }

    public void tryingToRegisterWithExistingEmailMail(String toEmail) {

        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

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
            message.setSubject("FinPlus Bank - Anonymous Activity Found");

            Account account = new Account();
            account.setBalance(000000);
            account.setAccountNumber("NA");
            account.setEmail(toEmail);
            account.setName("Anonymous");

            String htmlText = htmlUtil.templateHTML(account,
                    "Don't be afraid your data is secure in database, someone is trying to register with your existing email");

            message.setContent(htmlText, "text/html; charset=utf-8");

            Transport.send(message);
            System.out.println("Success: Email sent successfully");

        } catch (Exception e) {
            System.out.println("Error: Sending email unsuccessfully.");
            e.printStackTrace();
        }

    }

    //

    public void otpMail(String toEmail, int otp) {

        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

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
            message.setSubject("FinPlus Bank - OTP Verification");

            Account account = new Account();
            account.setBalance(000000);
            account.setAccountNumber("NA");
            account.setEmail(toEmail);
            account.setName("Anonymous");

            String htmlText = htmlUtil.otpHTML("Your OTP is:- " + String.valueOf(otp));

            message.setContent(htmlText, "text/html; charset=utf-8");

            Transport.send(message);

        } catch (Exception e) {
            System.out.println("Error: Sending email unsuccessfully.");
            e.printStackTrace();
        }

    }

    //

    public void creditBalance(String toEmail, long amount, String transactionIdString) {

        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

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
            message.setSubject("FinPlus Bank - OTP Verification");

            String htmlText = htmlUtil
                    .otpHTML("Amount credited to your account Successfully 😊 ,AMOUNT = " + amount + "\n"
                            + "Transaction id:- " + transactionIdString);

            message.setContent(htmlText, "text/html; charset=utf-8");

            Transport.send(message);

        } catch (Exception e) {
            System.out.println("Error: Sending email unsuccessfully.");
            e.printStackTrace();
        }

    }

    public void debitBalance(String toEmail, long amount, String transactionIdString) {

        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

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
            message.setSubject("FinPlus Bank - OTP Verification");

            String htmlText = htmlUtil
                    .otpHTML("Amount debited to your account Successfully 😊 ,AMOUNT = " + amount + "\n"
                            + "Transaction id:- " + transactionIdString);

            message.setContent(htmlText, "text/html; charset=utf-8");

            Transport.send(message);

        } catch (Exception e) {
            System.out.println("Error: Sending email unsuccessfully.");
            e.printStackTrace();
        }

    }

}