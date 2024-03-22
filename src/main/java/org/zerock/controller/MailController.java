package org.zerock.controller;

import java.security.SecureRandom;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.service.LoginService;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
public class MailController {

	@Setter(onMethod_ =@Autowired )
	JavaMailSenderImpl mailSender; // 메일보내는 bean 
	
	@Setter(onMethod_ =@Autowired )
	LoginService loginService;
	
	
	@PostMapping(value ="/resetPw", produces = {MediaType.TEXT_PLAIN_VALUE} )
	public ResponseEntity<String> sendPwMail(String useremail, String userid){
		//패스워드 리셋 메일 보내는 컨트롤러
		
		String newpassword =getRandomPassword(5);
		
		//resetPassword 메서드를 통해 회원 비밀번호 초기화 
		if(!loginService.resetPassword(newpassword ,userid).equals("success")) {
			//비밀번호 reset 오류 시 오류 상태 전송 
			return new ResponseEntity<String>("fail",HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
		//비밀번호 초기화 성공시 사용자의 이메일로 메일 전송 
		String setfrom = "ponkuu@naver.com"; //보내는 사람
		String settitle = "비밀번호 초기화"; // 제목
		
		String setcontent = ""
				+ "안녕하세요, 고객님의 비밀번호 초기화 메일을 보내드립니다. 재로그인 후 비밀번호를 변경해주세요."
				+ "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional //EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n"
				+ "<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\">\r\n"
				+ "<head>\r\n"
				+ "<!--[if gte mso 9]>\r\n"
				+ "<xml>\r\n"
				+ "  <o:OfficeDocumentSettings>\r\n"
				+ "    <o:AllowPNG/>\r\n"
				+ "    <o:PixelsPerInch>96</o:PixelsPerInch>\r\n"
				+ "  </o:OfficeDocumentSettings>\r\n"
				+ "</xml>\r\n"
				+ "<![endif]-->\r\n"
				+ "  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n"
				+ "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "  <meta name=\"x-apple-disable-message-reformatting\">\r\n"
				+ "  <!--[if !mso]><!--><meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"><!--<![endif]-->\r\n"
				+ "  <title></title>\r\n"
				+ "  \r\n"
				+ "    <style type=\"text/css\">\r\n"
				+ "      @media only screen and (min-width: 620px) {\r\n"
				+ "  .u-row {\r\n"
				+ "    width: 600px !important;\r\n"
				+ "  }\r\n"
				+ "  .u-row .u-col {\r\n"
				+ "    vertical-align: top;\r\n"
				+ "  }\r\n"
				+ "\r\n"
				+ "  .u-row .u-col-100 {\r\n"
				+ "    width: 600px !important;\r\n"
				+ "  }\r\n"
				+ "\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "@media (max-width: 620px) {\r\n"
				+ "  .u-row-container {\r\n"
				+ "    max-width: 100% !important;\r\n"
				+ "    padding-left: 0px !important;\r\n"
				+ "    padding-right: 0px !important;\r\n"
				+ "  }\r\n"
				+ "  .u-row .u-col {\r\n"
				+ "    min-width: 320px !important;\r\n"
				+ "    max-width: 100% !important;\r\n"
				+ "    display: block !important;\r\n"
				+ "  }\r\n"
				+ "  .u-row {\r\n"
				+ "    width: 100% !important;\r\n"
				+ "  }\r\n"
				+ "  .u-col {\r\n"
				+ "    width: 100% !important;\r\n"
				+ "  }\r\n"
				+ "  .u-col > div {\r\n"
				+ "    margin: 0 auto;\r\n"
				+ "  }\r\n"
				+ "}\r\n"
				+ "body {\r\n"
				+ "  margin: 0;\r\n"
				+ "  padding: 0;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "table,\r\n"
				+ "tr,\r\n"
				+ "td {\r\n"
				+ "  vertical-align: top;\r\n"
				+ "  border-collapse: collapse;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "p {\r\n"
				+ "  margin: 0;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ ".ie-container table,\r\n"
				+ ".mso-container table {\r\n"
				+ "  table-layout: fixed;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "* {\r\n"
				+ "  line-height: inherit;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "a[x-apple-data-detectors='true'] {\r\n"
				+ "  color: inherit !important;\r\n"
				+ "  text-decoration: none !important;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "table, td { color: #000000; } </style>\r\n"
				+ "  \r\n"
				+ "  \r\n"
				+ "\r\n"
				+ "<!--[if !mso]><!--><link href=\"https://fonts.googleapis.com/css?family=Lato:400,700&display=swap\" rel=\"stylesheet\" type=\"text/css\"><link href=\"https://fonts.googleapis.com/css?family=Lato:400,700&display=swap\" rel=\"stylesheet\" type=\"text/css\"><!--<![endif]-->\r\n"
				+ "\r\n"
				+ "</head>\r\n"
				+ "\r\n"
				+ "<body class=\"clean-body u_body\" style=\"margin: 0;padding: 0;-webkit-text-size-adjust: 100%;background-color: #f9f9f9;color: #000000\">\r\n"
				+ "  <!--[if IE]><div class=\"ie-container\"><![endif]-->\r\n"
				+ "  <!--[if mso]><div class=\"mso-container\"><![endif]-->\r\n"
				+ "  <table style=\"border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;min-width: 320px;Margin: 0 auto;background-color: #f9f9f9;width:100%\" cellpadding=\"0\" cellspacing=\"0\">\r\n"
				+ "  <tbody>\r\n"
				+ "  <tr style=\"vertical-align: top\">\r\n"
				+ "    <td style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top\">\r\n"
				+ "    <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td align=\"center\" style=\"background-color: #f9f9f9;\"><![endif]-->\r\n"
				+ "    \r\n"
				+ "  \r\n"
				+ "  \r\n"
				+ "<div class=\"u-row-container\" style=\"padding: 0px;background-color: #f9f9f9\">\r\n"
				+ "  <div class=\"u-row\" style=\"margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #f9f9f9;\">\r\n"
				+ "    <div style=\"border-collapse: collapse;display: table;width: 100%;height: 100%;background-color: transparent;\">\r\n"
				+ "      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: #f9f9f9;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px;\"><tr style=\"background-color: #f9f9f9;\"><![endif]-->\r\n"
				+ "      \r\n"
				+ "<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"width: 600px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->\r\n"
				+ "<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\">\r\n"
				+ "  <div style=\"height: 100%;width: 100% !important;\">\r\n"
				+ "  <!--[if (!mso)&(!IE)]><!--><div style=\"box-sizing: border-box; height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\r\n"
				+ "  \r\n"
				+ "<table style=\"font-family:'Lato',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\r\n"
				+ "  <tbody>\r\n"
				+ "    <tr>\r\n"
				+ "      <td style=\"overflow-wrap:break-word;word-break:break-word;padding:15px;font-family:'Lato',sans-serif;\" align=\"left\">\r\n"
				+ "        \r\n"
				+ "  <table height=\"0px\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;border-top: 1px solid #f9f9f9;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%\">\r\n"
				+ "    <tbody>\r\n"
				+ "      <tr style=\"vertical-align: top\">\r\n"
				+ "        <td style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top;font-size: 0px;line-height: 0px;mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%\">\r\n"
				+ "          <span>&#160;</span>\r\n"
				+ "        </td>\r\n"
				+ "      </tr>\r\n"
				+ "    </tbody>\r\n"
				+ "  </table>\r\n"
				+ "\r\n"
				+ "      </td>\r\n"
				+ "    </tr>\r\n"
				+ "  </tbody>\r\n"
				+ "</table>\r\n"
				+ "\r\n"
				+ "  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\r\n"
				+ "  </div>\r\n"
				+ "</div>\r\n"
				+ "<!--[if (mso)|(IE)]></td><![endif]-->\r\n"
				+ "      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\r\n"
				+ "    </div>\r\n"
				+ "  </div>\r\n"
				+ "  </div>\r\n"
				+ "  \r\n"
				+ "\r\n"
				+ "\r\n"
				+ "  \r\n"
				+ "  \r\n"
				+ "<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\r\n"
				+ "  <div class=\"u-row\" style=\"margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #161a39;\">\r\n"
				+ "    <div style=\"border-collapse: collapse;display: table;width: 100%;height: 100%;background-color: transparent;\">\r\n"
				+ "      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px;\"><tr style=\"background-color: #161a39;\"><![endif]-->\r\n"
				+ "      \r\n"
				+ "<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"width: 600px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->\r\n"
				+ "<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\">\r\n"
				+ "  <div style=\"height: 100%;width: 100% !important;\">\r\n"
				+ "  <!--[if (!mso)&(!IE)]><!--><div style=\"box-sizing: border-box; height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\r\n"
				+ "  \r\n"
				+ "<table style=\"font-family:'Lato',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\r\n"
				+ "  <tbody>\r\n"
				+ "    <tr>\r\n"
				+ "      <td style=\"overflow-wrap:break-word;word-break:break-word;padding:35px 10px 10px;font-family:'Lato',sans-serif;\" align=\"left\">\r\n"
				+ "        \r\n"
				+ "<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\r\n"
				+ "  <tr>\r\n"
				+ "    <td style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\">\r\n"
				+ "      \r\n"
				+ "      <img align=\"center\" border=\"0\" src=\"/image-1.png\" alt=\"Image\" title=\"Image\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: inline-block !important;border: none;height: auto;float: none;width: 10%;max-width: 58px;\" width=\"58\"/>\r\n" //이미지
				+ "      \r\n"
				+ "    </td>\r\n"
				+ "  </tr>\r\n"
				+ "</table>\r\n"
				+ "\r\n"
				+ "      </td>\r\n"
				+ "    </tr>\r\n"
				+ "  </tbody>\r\n"
				+ "</table>\r\n"
				+ "\r\n"
				+ "<table style=\"font-family:'Lato',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\r\n"
				+ "  <tbody>\r\n"
				+ "    <tr>\r\n"
				+ "      <td style=\"overflow-wrap:break-word;word-break:break-word;padding:0px 10px 30px;font-family:'Lato',sans-serif;\" align=\"left\">\r\n"
				+ "        \r\n"
				+ "  <div style=\"font-size: 14px; line-height: 140%; text-align: left; word-wrap: break-word;\">\r\n"
				+ "    <p style=\"font-size: 14px; line-height: 140%; text-align: center;\"><span style=\"font-size: 28px; line-height: 39.2px; color: #ffffff; font-family: Lato, sans-serif;\">비밀번호가 변경되었습니다!</span></p>\r\n"
				+ "  </div>\r\n"
				+ "\r\n"
				+ "      </td>\r\n"
				+ "    </tr>\r\n"
				+ "  </tbody>\r\n"
				+ "</table>\r\n"
				+ "\r\n"
				+ "  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\r\n"
				+ "  </div>\r\n"
				+ "</div>\r\n"
				+ "<!--[if (mso)|(IE)]></td><![endif]-->\r\n"
				+ "      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\r\n"
				+ "    </div>\r\n"
				+ "  </div>\r\n"
				+ "  </div>\r\n"
				+ "  \r\n"
				+ "\r\n"
				+ "\r\n"
				+ "  \r\n"
				+ "  \r\n"
				+ "<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\r\n"
				+ "  <div class=\"u-row\" style=\"margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #ffffff;\">\r\n"
				+ "    <div style=\"border-collapse: collapse;display: table;width: 100%;height: 100%;background-color: transparent;\">\r\n"
				+ "      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px;\"><tr style=\"background-color: #ffffff;\"><![endif]-->\r\n"
				+ "      \r\n"
				+ "<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"width: 600px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->\r\n"
				+ "<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\">\r\n"
				+ "  <div style=\"height: 100%;width: 100% !important;\">\r\n"
				+ "  <!--[if (!mso)&(!IE)]><!--><div style=\"box-sizing: border-box; height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\r\n"
				+ "  \r\n"
				+ "<table style=\"font-family:'Lato',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\r\n"
				+ "  <tbody>\r\n"
				+ "    <tr>\r\n"
				+ "      <td style=\"overflow-wrap:break-word;word-break:break-word;padding:40px 40px 30px;font-family:'Lato',sans-serif;\" align=\"left\">\r\n"
				+ "        \r\n"
				+ "  <div style=\"font-size: 14px; line-height: 140%; text-align: left; word-wrap: break-word;\">\r\n"
				+ "    <p style=\"font-size: 14px; line-height: 140%;\"><span style=\"font-size: 18px; line-height: 25.2px; color: #666666;\">안녕하세요,</span></p>\r\n"
				+ "<p style=\"font-size: 14px; line-height: 140%;\"> </p>\r\n"
				+ "<p style=\"line-height: 140%;\"><span style=\"color: #666666; line-height: 19.6px;\"><span style=\"font-size: 18px; line-height: 25.2px;\">고객님의 비밀번호가 초기화 되었습니다.</span></span></p>\r\n"
				+ "<p style=\"font-size: 14px; line-height: 140%;\"> </p>\r\n"
				+ "<p style=\"font-size: 14px; line-height: 140%;\"><span style=\"font-size: 18px; line-height: 25.2px; color: #666666;\">초기화된 비밀번호는[      "+newpassword +"     ]입니다. 감사합니다.</span></p>\r\n"
				+ "  </div>\r\n"
				+ "\r\n"
				+ "      </td>\r\n"
				+ "    </tr>\r\n"
				+ "  </tbody>\r\n"
				+ "</table>\r\n"
				+ "\r\n"
				+ "<table style=\"font-family:'Lato',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\r\n"
				+ "  <tbody>\r\n"
				+ "    <tr>\r\n"
				+ "      <td style=\"overflow-wrap:break-word;word-break:break-word;padding:40px 40px 30px;font-family:'Lato',sans-serif;\" align=\"left\">\r\n"
				+ "        \r\n"
				+ "  <div style=\"font-size: 14px; line-height: 140%; text-align: left; word-wrap: break-word;\">\r\n"
				+ "    <p style=\"line-height: 140%;\"><span style=\"color: #888888; line-height: 19.6px;\"><span style=\"font-size: 16px; line-height: 22.4px;\"><em>임시 비밀번호로 로그인 후, 비밀번호를 재설정 해주세요.</em></span></span><br /><span style=\"font-size: 14px; color: #888888; line-height: 19.6px;\"><em><span style=\"font-size: 16px; line-height: 22.4px;\"> </span></em></span></p>\r\n"
				+ "  </div>\r\n"
				+ "\r\n"
				+ "      </td>\r\n"
				+ "    </tr>\r\n"
				+ "  </tbody>\r\n"
				+ "</table>\r\n"
				+ "\r\n"
				+ "  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\r\n"
				+ "  </div>\r\n"
				+ "</div>\r\n"
				+ "<!--[if (mso)|(IE)]></td><![endif]-->\r\n"
				+ "      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\r\n"
				+ "    </div>\r\n"
				+ "  </div>\r\n"
				+ "  </div>\r\n"
				+ "  \r\n"
				+ "\r\n"
				+ "\r\n"
				+ "  \r\n"
				+ "  \r\n"
				+ "<div class=\"u-row-container\" style=\"padding: 0px;background-color: #f9f9f9\">\r\n"
				+ "  <div class=\"u-row\" style=\"margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #1c103b;\">\r\n"
				+ "    <div style=\"border-collapse: collapse;display: table;width: 100%;height: 100%;background-color: transparent;\">\r\n"
				+ "      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: #f9f9f9;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px;\"><tr style=\"background-color: #1c103b;\"><![endif]-->\r\n"
				+ "      \r\n"
				+ "<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"width: 600px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->\r\n"
				+ "<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\">\r\n"
				+ "  <div style=\"height: 100%;width: 100% !important;\">\r\n"
				+ "  <!--[if (!mso)&(!IE)]><!--><div style=\"box-sizing: border-box; height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\r\n"
				+ "  \r\n"
				+ "<table style=\"font-family:'Lato',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\r\n"
				+ "  <tbody>\r\n"
				+ "    <tr>\r\n"
				+ "      <td style=\"overflow-wrap:break-word;word-break:break-word;padding:15px;font-family:'Lato',sans-serif;\" align=\"left\">\r\n"
				+ "        \r\n"
				+ "  <table height=\"0px\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;border-top: 1px solid #1c103b;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%\">\r\n"
				+ "    <tbody>\r\n"
				+ "      <tr style=\"vertical-align: top\">\r\n"
				+ "        <td style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top;font-size: 0px;line-height: 0px;mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%\">\r\n"
				+ "          <span>&#160;</span>\r\n"
				+ "        </td>\r\n"
				+ "      </tr>\r\n"
				+ "    </tbody>\r\n"
				+ "  </table>\r\n"
				+ "\r\n"
				+ "      </td>\r\n"
				+ "    </tr>\r\n"
				+ "  </tbody>\r\n"
				+ "</table>\r\n"
				+ "\r\n"
				+ "  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\r\n"
				+ "  </div>\r\n"
				+ "</div>\r\n"
				+ "<!--[if (mso)|(IE)]></td><![endif]-->\r\n"
				+ "      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\r\n"
				+ "    </div>\r\n"
				+ "  </div>\r\n"
				+ "  </div>\r\n"
				+ "  \r\n"
				+ "\r\n"
				+ "\r\n"
				+ "  \r\n"
				+ "  \r\n"
				+ "<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\r\n"
				+ "  <div class=\"u-row\" style=\"margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #f9f9f9;\">\r\n"
				+ "    <div style=\"border-collapse: collapse;display: table;width: 100%;height: 100%;background-color: transparent;\">\r\n"
				+ "      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px;\"><tr style=\"background-color: #f9f9f9;\"><![endif]-->\r\n"
				+ "      \r\n"
				+ "<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"width: 600px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->\r\n"
				+ "<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\">\r\n"
				+ "  <div style=\"height: 100%;width: 100% !important;\">\r\n"
				+ "  <!--[if (!mso)&(!IE)]><!--><div style=\"box-sizing: border-box; height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\r\n"
				+ "  \r\n"
				+ "  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\r\n"
				+ "  </div>\r\n"
				+ "</div>\r\n"
				+ "<!--[if (mso)|(IE)]></td><![endif]-->\r\n"
				+ "      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\r\n"
				+ "    </div>\r\n"
				+ "  </div>\r\n"
				+ "  </div>\r\n"
				+ "  \r\n"
				+ "\r\n"
				+ "\r\n"
				+ "    <!--[if (mso)|(IE)]></td></tr></table><![endif]-->\r\n"
				+ "    </td>\r\n"
				+ "  </tr>\r\n"
				+ "  </tbody>\r\n"
				+ "  </table>\r\n"
				+ "  <!--[if mso]></div><![endif]-->\r\n"
				+ "  <!--[if IE]></div><![endif]-->\r\n"
				+ "</body>\r\n"
				+ "\r\n"
				+ "</html>\r\n"
				+ "    "; //내용
		
		String tomail = useremail; // 받을 주소
		
		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(message,
					true, "UTF-8");

			messageHelper.setFrom(setfrom); // 보내는사람 (필수)
			messageHelper.setTo(tomail); // 받는사람 이메일
			messageHelper.setSubject(settitle); // 메일제목은
			messageHelper.setText(setcontent , true); // 메일 내용 , html여부

			mailSender.send(message);
		} catch (Exception e) {
			System.out.println(e);
		}
		

		return new ResponseEntity<String>("success",HttpStatus.OK);

	}
	
	//랜덤 비밀번호 생성을 위한 배열
	private static final char[] rndAllCharacters = new char[]{
	        //number
	        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
	        //uppercase
	        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
	        'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
	        //lowercase
	        'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
	        'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
	        //special symbols
	        '@', '$', '!', '%', '*', '?', '&'
	};
	
	private String getRandomPassword(int length) {
	    SecureRandom random = new SecureRandom();
	    StringBuilder stringBuilder = new StringBuilder();

	    int rndAllCharactersLength = rndAllCharacters.length;
	    for (int i = 0; i < length; i++) {
	        stringBuilder.append(rndAllCharacters[random.nextInt(rndAllCharactersLength)]);
	    }

	    return stringBuilder.toString();
	}

}
