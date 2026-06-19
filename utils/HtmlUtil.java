package utils;

import models.Account;

public class HtmlUtil {

    public String accountCreationHTML(Account account) {
        String htmlText = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>FinPlus - Welcome Email</title>\n" +
                "    <style>\n" +
                "        * {\n" +
                "            margin: 0;\n" +
                "            padding: 0;\n" +
                "            box-sizing: border-box;\n" +
                "        }\n" +
                "\n" +
                "        body {\n" +
                "            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;\n" +
                "            background: linear-gradient(135deg, #0f0f1e 0%, #1a1a2e 100%);\n" +
                "            color: #333;\n" +
                "            line-height: 1.6;\n" +
                "        }\n" +
                "\n" +
                "        .container {\n" +
                "            max-width: 650px;\n" +
                "            margin: 20px auto;\n" +
                "            background: #ffffff;\n" +
                "            border-radius: 12px;\n" +
                "            overflow: hidden;\n" +
                "            box-shadow: 0 20px 60px rgba(0, 0, 0, 0.3);\n" +
                "        }\n" +
                "\n" +
                "        .header {\n" +
                "            background: linear-gradient(135deg, #0f0f1e 0%, #1a1a2e 50%, #0f0f1e 100%);\n" +
                "            padding: 50px 40px;\n" +
                "            text-align: center;\n" +
                "            position: relative;\n" +
                "            overflow: hidden;\n" +
                "        }\n" +
                "\n" +
                "        .header::before {\n" +
                "            content: '';\n" +
                "            position: absolute;\n" +
                "            top: 50%;\n" +
                "            left: 50%;\n" +
                "            transform: translate(-50%, -50%);\n" +
                "            width: 400px;\n" +
                "            height: 400px;\n" +
                "            background: radial-gradient(circle, rgba(192, 192, 192, 0.2) 0%, rgba(192, 192, 192, 0.05) 50%, transparent 70%);\n"
                +
                "            border-radius: 50%;\n" +
                "            filter: blur(40px);\n" +
                "            animation: glow 8s ease-in-out infinite;\n" +
                "            z-index: 0;\n" +
                "        }\n" +
                "\n" +
                "        @keyframes glow {\n" +
                "            0%, 100% {\n" +
                "                opacity: 0.4;\n" +
                "                transform: translate(-50%, -50%) scale(1);\n" +
                "            }\n" +
                "            50% {\n" +
                "                opacity: 0.8;\n" +
                "                transform: translate(-50%, -50%) scale(1.1);\n" +
                "            }\n" +
                "        }\n" +
                "\n" +
                "        .logo-wrapper {\n" +
                "            position: relative;\n" +
                "            z-index: 2;\n" +
                "            display: inline-block;\n" +
                "        }\n" +
                "\n" +
                "        .logo-text {\n" +
                "            font-size: 48px;\n" +
                "            font-weight: 900;\n" +
                "            letter-spacing: 3px;\n" +
                "            background: linear-gradient(135deg, #e8e8e8 0%, #ffffff 25%, #d0d0d0 50%, #c0c0c0 75%, #e0e0e0 100%);\n"
                +
                "            -webkit-background-clip: text;\n" +
                "            -webkit-text-fill-color: transparent;\n" +
                "            background-clip: text;\n" +
                "            filter: drop-shadow(0 0 20px rgba(192, 192, 192, 0.4)) \n" +
                "                    drop-shadow(0 0 40px rgba(192, 192, 192, 0.2));\n" +
                "            text-shadow: 0 0 30px rgba(192, 192, 192, 0.3);\n" +
                "            font-family: 'Arial Black', sans-serif;\n" +
                "            animation: shine 6s ease-in-out infinite;\n" +
                "        }\n" +
                "\n" +
                "        @keyframes shine {\n" +
                "            0%, 100% {\n" +
                "                filter: drop-shadow(0 0 20px rgba(192, 192, 192, 0.4)) \n" +
                "                        drop-shadow(0 0 40px rgba(192, 192, 192, 0.2));\n" +
                "            }\n" +
                "            50% {\n" +
                "                filter: drop-shadow(0 0 30px rgba(192, 192, 192, 0.6)) \n" +
                "                        drop-shadow(0 0 60px rgba(192, 192, 192, 0.3));\n" +
                "            }\n" +
                "        }\n" +
                "\n" +
                "        .tagline {\n" +
                "            color: #c0c0c0;\n" +
                "            font-size: 12px;\n" +
                "            letter-spacing: 4px;\n" +
                "            margin-top: 10px;\n" +
                "            text-transform: uppercase;\n" +
                "            font-weight: 300;\n" +
                "        }\n" +
                "\n" +
                "        .content {\n" +
                "            padding: 50px 40px;\n" +
                "            background: #ffffff;\n" +
                "        }\n" +
                "\n" +
                "        .greeting {\n" +
                "            font-size: 18px;\n" +
                "            color: #1a1a2e;\n" +
                "            font-weight: 600;\n" +
                "            margin-bottom: 20px;\n" +
                "        }\n" +
                "\n" +
                "        .greeting-text {\n" +
                "            color: #555;\n" +
                "            margin-bottom: 25px;\n" +
                "            font-size: 15px;\n" +
                "            line-height: 1.8;\n" +
                "        }\n" +
                "\n" +
                "        .welcome-message {\n" +
                "            background: linear-gradient(135deg, #f5f5f5 0%, #fafafa 100%);\n" +
                "            border-left: 4px solid #c0c0c0;\n" +
                "            padding: 20px;\n" +
                "            margin: 30px 0;\n" +
                "            border-radius: 6px;\n" +
                "            font-style: italic;\n" +
                "            color: #555;\n" +
                "        }\n" +
                "\n" +
                "        .divider {\n" +
                "            height: 2px;\n" +
                "            background: linear-gradient(90deg, transparent, #d0d0d0, transparent);\n" +
                "            margin: 35px 0;\n" +
                "        }\n" +
                "\n" +
                "        .section-title {\n" +
                "            font-size: 16px;\n" +
                "            font-weight: 700;\n" +
                "            color: #0f0f1e;\n" +
                "            margin-bottom: 25px;\n" +
                "            display: flex;\n" +
                "            align-items: center;\n" +
                "        }\n" +
                "\n" +
                "        .section-title::before {\n" +
                "            content: '';\n" +
                "            width: 4px;\n" +
                "            height: 20px;\n" +
                "            background: linear-gradient(180deg, #c0c0c0, #e0e0e0);\n" +
                "            margin-right: 12px;\n" +
                "            border-radius: 2px;\n" +
                "        }\n" +
                "\n" +
                "        .details-grid {\n" +
                "            display: grid;\n" +
                "            grid-template-columns: 1fr 1fr;\n" +
                "            gap: 20px;\n" +
                "            margin-bottom: 30px;\n" +
                "        }\n" +
                "\n" +
                "        .detail-box {\n" +
                "            background: linear-gradient(135deg, #f9f9f9 0%, #ffffff 100%);\n" +
                "            padding: 20px;\n" +
                "            border-radius: 8px;\n" +
                "            border: 1px solid #e8e8e8;\n" +
                "        }\n" +
                "\n" +
                "        .detail-label {\n" +
                "            font-size: 12px;\n" +
                "            color: #888;\n" +
                "            text-transform: uppercase;\n" +
                "            letter-spacing: 1px;\n" +
                "            margin-bottom: 8px;\n" +
                "            font-weight: 600;\n" +
                "        }\n" +
                "\n" +
                "        .detail-value {\n" +
                "            font-size: 18px;\n" +
                "            color: #1a1a2e;\n" +
                "            font-weight: 700;\n" +
                "            word-break: break-all;\n" +
                "        }\n" +
                "\n" +
                "        .balance-box {\n" +
                "            grid-column: 1 / -1;\n" +
                "            background: linear-gradient(135deg, #1a1a2e 0%, #0f0f1e 100%);\n" +
                "            padding: 30px;\n" +
                "            border-radius: 8px;\n" +
                "            color: #ffffff;\n" +
                "            text-align: center;\n" +
                "        }\n" +
                "\n" +
                "        .balance-label {\n" +
                "            font-size: 13px;\n" +
                "            color: #c0c0c0;\n" +
                "            text-transform: uppercase;\n" +
                "            letter-spacing: 1px;\n" +
                "            margin-bottom: 10px;\n" +
                "            font-weight: 600;\n" +
                "        }\n" +
                "\n" +
                "        .balance-amount {\n" +
                "            font-size: 36px;\n" +
                "            font-weight: 900;\n" +
                "            background: linear-gradient(135deg, #e8e8e8, #ffffff, #d0d0d0);\n" +
                "            -webkit-background-clip: text;\n" +
                "            -webkit-text-fill-color: transparent;\n" +
                "            background-clip: text;\n" +
                "            filter: drop-shadow(0 2px 4px rgba(192, 192, 192, 0.3));\n" +
                "        }\n" +
                "\n" +
                "        .cta-button {\n" +
                "            display: inline-block;\n" +
                "            padding: 14px 40px;\n" +
                "            background: linear-gradient(135deg, #c0c0c0 0%, #e0e0e0 50%, #d0d0d0 100%);\n" +
                "            color: #0f0f1e;\n" +
                "            text-decoration: none;\n" +
                "            border-radius: 6px;\n" +
                "            font-weight: 700;\n" +
                "            font-size: 14px;\n" +
                "            letter-spacing: 1px;\n" +
                "            border: 1px solid #d0d0d0;\n" +
                "        }\n" +
                "\n" +
                "        .footer {\n" +
                "            background: #f5f5f5;\n" +
                "            padding: 30px 40px;\n" +
                "            text-align: center;\n" +
                "            border-top: 1px solid #e8e8e8;\n" +
                "        }\n" +
                "\n" +
                "        .footer-text {\n" +
                "            color: #888;\n" +
                "            font-size: 13px;\n" +
                "            margin-bottom: 15px;\n" +
                "            line-height: 1.6;\n" +
                "        }\n" +
                "\n" +
                "        .footer-signature {\n" +
                "            color: #1a1a2e;\n" +
                "            font-weight: 600;\n" +
                "            font-size: 14px;\n" +
                "            margin: 15px 0;\n" +
                "        }\n" +
                "\n" +
                "        .footer-logo {\n" +
                "            font-size: 14px;\n" +
                "            color: #c0c0c0;\n" +
                "            font-weight: 700;\n" +
                "            letter-spacing: 2px;\n" +
                "            margin-top: 20px;\n" +
                "        }\n" +
                "\n" +
                "        @media (max-width: 600px) {\n" +
                "            .container { margin: 10px; border-radius: 8px; }\n" +
                "            .header { padding: 35px 25px; }\n" +
                "            .logo-text { font-size: 36px; letter-spacing: 2px; }\n" +
                "            .content { padding: 35px 25px; }\n" +
                "            .details-grid { grid-template-columns: 1fr; }\n" +
                "            .balance-box { grid-column: 1; }\n" +
                "            .balance-amount { font-size: 28px; }\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <div class=\"container\">\n" +
                "        <div class=\"header\">\n" +
                "            <div class=\"logo-wrapper\">\n" +
                "                <div class=\"logo-text\">FINPLUS</div>\n" +
                "                <div class=\"tagline\">Financial Excellence</div>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "\n" +
                "        <div class=\"content\">\n" +
                "            <div class=\"greeting\">Dear Valued Customer,</div>\n" +
                "\n" +
                "            <div class=\"welcome-message\">\n" +
                "                \"Welcome to FinPlus - Where Your Financial Future Matters\"\n" +
                "            </div>\n" +
                "\n" +
                "            <div class=\"greeting-text\">\n" +
                "                Hello! <strong>Abhishek (Founder and CEO)</strong> welcomes you to <strong>FinPlus</strong>. We're thrilled to have you join our banking family.\n"
                +
                "            </div>\n" +
                "\n" +
                "            <div class=\"greeting-text\">\n" +
                "                Thank you for choosing <strong>FinPlus</strong>. We are excited to help you manage your finances smarter, safer, and better.\n"
                +
                "            </div>\n" +
                "\n" +
                "            <div class=\"divider\"></div>\n" +
                "\n" +
                "            <div class=\"section-title\">Account Details</div>\n" +
                "\n" +
                "            <div class=\"details-grid\">\n" +
                "                <div class=\"detail-box\">\n" +
                "                    <div class=\"detail-label\">Account Holder</div>\n" +
                "                    <div class=\"detail-value\">" + account.getName().toUpperCase() + "</div>\n" +
                "                </div>\n" +
                "\n" +
                "                <div class=\"detail-box\">\n" +
                "                    <div class=\"detail-label\">Account Number</div>\n" +
                "                    <div class=\"detail-value\">" + String.valueOf(account.getAccountNumber())
                + "</div>\n" +
                "                </div>\n" +
                "\n" +
                "                <div class=\"balance-box\">\n" +
                "                    <div class=\"balance-label\">Current Balance</div>\n" +
                "                     <div class=\"balance-amount\">₹ "
                + String.format("%,.2f", (double) account.getBalance())
                + "</div>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "\n" +
                "            <div style='text-align: center; margin: 35px 0 20px 0;'>\n" +
                "                <a href='#' style='display: inline-block; padding: 14px 40px; background: linear-gradient(135deg, #c0c0c0 0%, #e0e0e0 50%, #d0d0d0 100%); color: #0f0f1e; text-decoration: none; border-radius: 6px; font-weight: 700; font-size: 14px; letter-spacing: 1px; border: 1px solid #d0d0d0;'>EXPLORE YOUR ACCOUNT</a>\n"
                +
                "            </div>\n" +
                "\n" +
                "            <div class=\"divider\"></div>\n" +
                "\n" +
                "            <div class=\"greeting-text\">\n" +
                "                For security, never share your account details with anyone. Our team will never ask for your password or sensitive information.\n"
                +
                "            </div>\n" +
                "\n" +
                "            <div class=\"greeting-text\" style=\"color: #888; font-size: 13px;\">\n" +
                "                If you have any questions or need assistance, please don't hesitate to reach out to our support team at <strong>support@finplus.com</strong> or call us at <strong>1-800-FINPLUS</strong>.\n"
                +
                "            </div>\n" +
                "        </div>\n" +
                "\n" +
                "        <div class=\"footer\">\n" +
                "            <div class=\"footer-text\">\n" +
                "                Best Regards,<br/>\n" +
                "                <span class=\"footer-signature\">FinPlus Team</span>\n" +
                "            </div>\n" +
                "\n" +
                "            <div class=\"footer-text\">\n" +
                "                © 2024 FinPlus Banking. All Rights Reserved.<br/>\n" +
                "                Your Trust, Our Commitment to Excellence.\n" +
                "            </div>\n" +
                "\n" +
                "            <div class=\"footer-logo\">FINPLUS</div>\n" +
                "\n" +
                "            <div class=\"footer-text\" style=\"margin-top: 20px; font-size: 12px;\">\n" +
                "                This email contains confidential information. If received in error, please delete immediately.\n"
                +
                "            </div>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</body>\n" +
                "</html>";

        return htmlText;
    }

    public String accountDepositHTML(Account account) {
        String htmlText = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>FinPlus - Deposit Successful</title>\n" +
                "    <style>\n" +
                "        * {\n" +
                "            margin: 0;\n" +
                "            padding: 0;\n" +
                "            box-sizing: border-box;\n" +
                "        }\n" +
                "\n" +
                "        body {\n" +
                "            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;\n" +
                "            background: linear-gradient(135deg, #0f0f1e 0%, #1a1a2e 100%);\n" +
                "            color: #333;\n" +
                "            line-height: 1.6;\n" +
                "        }\n" +
                "\n" +
                "        .container {\n" +
                "            max-width: 650px;\n" +
                "            margin: 20px auto;\n" +
                "            background: #ffffff;\n" +
                "            border-radius: 12px;\n" +
                "            overflow: hidden;\n" +
                "            box-shadow: 0 20px 60px rgba(0, 0, 0, 0.3);\n" +
                "        }\n" +
                "\n" +
                "        .header {\n" +
                "            background: linear-gradient(135deg, #0f0f1e 0%, #1a1a2e 50%, #0f0f1e 100%);\n" +
                "            padding: 50px 40px;\n" +
                "            text-align: center;\n" +
                "            position: relative;\n" +
                "            overflow: hidden;\n" +
                "        }\n" +
                "\n" +
                "        .header::before {\n" +
                "            content: '';\n" +
                "            position: absolute;\n" +
                "            top: 50%;\n" +
                "            left: 50%;\n" +
                "            transform: translate(-50%, -50%);\n" +
                "            width: 400px;\n" +
                "            height: 400px;\n" +
                "            background: radial-gradient(circle, rgba(192, 192, 192, 0.2) 0%, rgba(192, 192, 192, 0.05) 50%, transparent 70%);\n"
                +
                "            border-radius: 50%;\n" +
                "            filter: blur(40px);\n" +
                "            animation: glow 8s ease-in-out infinite;\n" +
                "            z-index: 0;\n" +
                "        }\n" +
                "\n" +
                "        @keyframes glow {\n" +
                "            0%, 100% {\n" +
                "                opacity: 0.4;\n" +
                "                transform: translate(-50%, -50%) scale(1);\n" +
                "            }\n" +
                "            50% {\n" +
                "                opacity: 0.8;\n" +
                "                transform: translate(-50%, -50%) scale(1.1);\n" +
                "            }\n" +
                "        }\n" +
                "\n" +
                "        .logo-wrapper {\n" +
                "            position: relative;\n" +
                "            z-index: 2;\n" +
                "            display: inline-block;\n" +
                "        }\n" +
                "\n" +
                "        .logo-text {\n" +
                "            font-size: 48px;\n" +
                "            font-weight: 900;\n" +
                "            letter-spacing: 3px;\n" +
                "            background: linear-gradient(135deg, #e8e8e8 0%, #ffffff 25%, #d0d0d0 50%, #c0c0c0 75%, #e0e0e0 100%);\n"
                +
                "            -webkit-background-clip: text;\n" +
                "            -webkit-text-fill-color: transparent;\n" +
                "            background-clip: text;\n" +
                "            filter: drop-shadow(0 0 20px rgba(192, 192, 192, 0.4)) \n" +
                "                    drop-shadow(0 0 40px rgba(192, 192, 192, 0.2));\n" +
                "            text-shadow: 0 0 30px rgba(192, 192, 192, 0.3);\n" +
                "            font-family: 'Arial Black', sans-serif;\n" +
                "            animation: shine 6s ease-in-out infinite;\n" +
                "        }\n" +
                "\n" +
                "        @keyframes shine {\n" +
                "            0%, 100% {\n" +
                "                filter: drop-shadow(0 0 20px rgba(192, 192, 192, 0.4)) \n" +
                "                        drop-shadow(0 0 40px rgba(192, 192, 192, 0.2));\n" +
                "            }\n" +
                "            50% {\n" +
                "                filter: drop-shadow(0 0 30px rgba(192, 192, 192, 0.6)) \n" +
                "                        drop-shadow(0 0 60px rgba(192, 192, 192, 0.3));\n" +
                "            }\n" +
                "        }\n" +
                "\n" +
                "        .tagline {\n" +
                "            color: #c0c0c0;\n" +
                "            font-size: 12px;\n" +
                "            letter-spacing: 4px;\n" +
                "            margin-top: 10px;\n" +
                "            text-transform: uppercase;\n" +
                "            font-weight: 300;\n" +
                "        }\n" +
                "\n" +
                "        .content {\n" +
                "            padding: 50px 40px;\n" +
                "            background: #ffffff;\n" +
                "        }\n" +
                "\n" +
                "        .greeting {\n" +
                "            font-size: 18px;\n" +
                "            color: #1a1a2e;\n" +
                "            font-weight: 600;\n" +
                "            margin-bottom: 20px;\n" +
                "        }\n" +
                "\n" +
                "        .greeting-text {\n" +
                "            color: #555;\n" +
                "            margin-bottom: 25px;\n" +
                "            font-size: 15px;\n" +
                "            line-height: 1.8;\n" +
                "        }\n" +
                "\n" +
                "        .divider {\n" +
                "            height: 2px;\n" +
                "            background: linear-gradient(90deg, transparent, #d0d0d0, transparent);\n" +
                "            margin: 35px 0;\n" +
                "        }\n" +
                "\n" +
                "        .section-title {\n" +
                "            font-size: 16px;\n" +
                "            font-weight: 700;\n" +
                "            color: #0f0f1e;\n" +
                "            margin-bottom: 25px;\n" +
                "            display: flex;\n" +
                "            align-items: center;\n" +
                "        }\n" +
                "\n" +
                "        .section-title::before {\n" +
                "            content: '';\n" +
                "            width: 4px;\n" +
                "            height: 20px;\n" +
                "            background: linear-gradient(180deg, #c0c0c0, #e0e0e0);\n" +
                "            margin-right: 12px;\n" +
                "            border-radius: 2px;\n" +
                "        }\n" +
                "\n" +
                "        .details-grid {\n" +
                "            display: grid;\n" +
                "            grid-template-columns: 1fr 1fr;\n" +
                "            gap: 20px;\n" +
                "            margin-bottom: 30px;\n" +
                "        }\n" +
                "\n" +
                "        .detail-box {\n" +
                "            background: linear-gradient(135deg, #f9f9f9 0%, #ffffff 100%);\n" +
                "            padding: 20px;\n" +
                "            border-radius: 8px;\n" +
                "            border: 1px solid #e8e8e8;\n" +
                "        }\n" +
                "\n" +
                "        .detail-label {\n" +
                "            font-size: 12px;\n" +
                "            color: #888;\n" +
                "            text-transform: uppercase;\n" +
                "            letter-spacing: 1px;\n" +
                "            margin-bottom: 8px;\n" +
                "            font-weight: 600;\n" +
                "        }\n" +
                "\n" +
                "        .detail-value {\n" +
                "            font-size: 18px;\n" +
                "            color: #1a1a2e;\n" +
                "            font-weight: 700;\n" +
                "            word-break: break-all;\n" +
                "        }\n" +
                "\n" +
                "        .balance-box {\n" +
                "            grid-column: 1 / -1;\n" +
                "            background: linear-gradient(135deg, #1a1a2e 0%, #0f0f1e 100%);\n" +
                "            padding: 30px;\n" +
                "            border-radius: 8px;\n" +
                "            color: #ffffff;\n" +
                "            text-align: center;\n" +
                "        }\n" +
                "\n" +
                "        .balance-label {\n" +
                "            font-size: 13px;\n" +
                "            color: #c0c0c0;\n" +
                "            text-transform: uppercase;\n" +
                "            letter-spacing: 1px;\n" +
                "            margin-bottom: 10px;\n" +
                "            font-weight: 600;\n" +
                "        }\n" +
                "\n" +
                "        .balance-amount {\n" +
                "            font-size: 36px;\n" +
                "            font-weight: 900;\n" +
                "            background: linear-gradient(135deg, #e8e8e8, #ffffff, #d0d0d0);\n" +
                "            -webkit-background-clip: text;\n" +
                "            -webkit-text-fill-color: transparent;\n" +
                "            background-clip: text;\n" +
                "            filter: drop-shadow(0 2px 4px rgba(192, 192, 192, 0.3));\n" +
                "        }\n" +
                "\n" +
                "        .footer {\n" +
                "            background: #f5f5f5;\n" +
                "            padding: 30px 40px;\n" +
                "            text-align: center;\n" +
                "            border-top: 1px solid #e8e8e8;\n" +
                "        }\n" +
                "\n" +
                "        .footer-text {\n" +
                "            color: #888;\n" +
                "            font-size: 13px;\n" +
                "            margin-bottom: 15px;\n" +
                "            line-height: 1.6;\n" +
                "        }\n" +
                "\n" +
                "        .footer-signature {\n" +
                "            color: #1a1a2e;\n" +
                "            font-weight: 600;\n" +
                "            font-size: 14px;\n" +
                "            margin: 15px 0;\n" +
                "        }\n" +
                "\n" +
                "        .footer-logo {\n" +
                "            font-size: 14px;\n" +
                "            color: #c0c0c0;\n" +
                "            font-weight: 700;\n" +
                "            letter-spacing: 2px;\n" +
                "            margin-top: 20px;\n" +
                "        }\n" +
                "\n" +
                "        @media (max-width: 600px) {\n" +
                "            .container { margin: 10px; border-radius: 8px; }\n" +
                "            .header { padding: 35px 25px; }\n" +
                "            .logo-text { font-size: 36px; letter-spacing: 2px; }\n" +
                "            .content { padding: 35px 25px; }\n" +
                "            .details-grid { grid-template-columns: 1fr; }\n" +
                "            .balance-box { grid-column: 1; }\n" +
                "            .balance-amount { font-size: 28px; }\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <div class=\"container\">\n" +
                "        <div class=\"header\">\n" +
                "            <div class=\"logo-wrapper\">\n" +
                "                <div class=\"logo-text\">FINPLUS</div>\n" +
                "                <div class=\"tagline\">Financial Excellence</div>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "\n" +
                "        <div class=\"content\">\n" +
                "            <div class=\"greeting\">Dear Customer,</div>\n" +
                "\n" +
                "            <div class=\"greeting-text\">\n" +
                "                Hello! I am <strong>Abhishek (Founder and CEO)</strong>.\n" +
                "            </div>\n" +
                "\n" +
                "            <div class=\"greeting-text\">\n" +
                "                Thank you for choosing <strong>FinPlus</strong>. Your amount is deposited successfully.\n"
                +
                "            </div>\n" +
                "\n" +
                "            <div class=\"divider\"></div>\n" +
                "\n" +
                "            <div class=\"section-title\">Account Details</div>\n" +
                "\n" +
                "            <div class=\"details-grid\">\n" +
                "                <div class=\"detail-box\">\n" +
                "                    <div class=\"detail-label\">Account Holder</div>\n" +
                "                    <div class=\"detail-value\">" + account.getName().toUpperCase() + "</div>\n" +
                "                </div>\n" +
                "\n" +
                "                <div class=\"detail-box\">\n" +
                "                    <div class=\"detail-label\">Account Number</div>\n" +
                "                    <div class=\"detail-value\">" + String.valueOf(account.getAccountNumber())
                + "</div>\n" +
                "                </div>\n" +
                "\n" +
                "                <div class=\"balance-box\">\n" +
                "                    <div class=\"balance-label\">Current Balance</div>\n" +
                "                    <div class=\"balance-amount\">₹ "
                + String.format("%,.2f", (double) account.getBalance())
                + "</div>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "\n" +
                "            <div style='text-align: center; margin: 35px 0 20px 0;'>\n" +
                "                <a href='#' style='display: inline-block; padding: 14px 40px; background: linear-gradient(135deg, #c0c0c0 0%, #e0e0e0 50%, #d0d0d0 100%); color: #0f0f1e; text-decoration: none; border-radius: 6px; font-weight: 700; font-size: 14px; letter-spacing: 1px; border: 1px solid #d0d0d0;'>VIEW TRANSACTIONS</a>\n"
                +
                "            </div>\n" +
                "        </div>\n" +
                "\n" +
                "        <div class=\"footer\">\n" +
                "            <div class=\"footer-text\">\n" +
                "                Best Regards,<br/>\n" +
                "                <span class=\"footer-signature\">FinPlus Team</span>\n" +
                "            </div>\n" +
                "\n" +
                "            <div class=\"footer-text\">\n" +
                "                © 2026 FinPlus Banking. All Rights Reserved.<br/>\n" +
                "                Your Trust, Our Commitment to Excellence.\n" +
                "            </div>\n" +
                "\n" +
                "            <div class=\"footer-logo\">FINPLUS</div>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</body>\n" +
                "</html>";

        return htmlText;
    }
}