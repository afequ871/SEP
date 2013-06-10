package gov.va.sep.automatedtesting.objects;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Properties;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.SubjectTerm;


public class GmailReading {
	public static void main(String[] args) throws Exception {
        Properties props = System.getProperties();
        props.setProperty("mail.store.protocol", "imaps");

            Session session = Session.getDefaultInstance(props, null);
            Store store = session.getStore("imaps");
            store.connect("imap.gmail.com", "bbmitestuser",
                    "bbmitest123");

            Folder folder = store.getFolder("INBOX");
            folder.open(Folder.READ_WRITE);

            System.out.println("Total Message:" + folder.getMessageCount());
            System.out.println("Unread Message:"
                    + folder.getUnreadMessageCount());
            
            Message[] messages = null;
            boolean isMailFound = false;
            Message mailFromGod= null;

            //Search for mail from God
            for (int i = 0; i < 5; i++) {
                messages = folder.search(new SubjectTerm(
                        "Notification of new Direct email message"),
                        folder.getMessages());
                //Wait for 10 seconds
                if (messages.length == 0) {
                    Thread.sleep(10000);
                }
            }

            //Search for unread mail from God
            //This is to avoid using the mail for which 
            //Registration is already done
            for (Message mail : messages) {
                if (!mail.isSet(Flags.Flag.SEEN)) {
                    mailFromGod = mail;
                    //System.out.println("Message Count is: "+ mailFromGod.getMessageNumber());
                    isMailFound = true;
                }
            }

            //Test fails if no unread mail was found from God
            if (!isMailFound) {
                throw new Exception(
                        "Could not find new mail from God :-(");
            
            //Read the content of mail and launch registration URL                
            } else {
                String line;
                StringBuffer buffer = new StringBuffer();
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(mailFromGod
                                .getInputStream()));
                while ((line = reader.readLine()) != null) {
                    buffer.append(line);
                }
                System.out.println(buffer.toString());

                //Your logic to split the message and get the Registration URL goes here
//                String registrationURL = buffer.toString().split("https://158.147.211.124/<wbr>JavaBridge/mail/src/login.php")[0].split("href=")[1];
                String registrationURL	=	buffer.toString().substring(buffer.toString().indexOf("https://"));
                System.out.println("registrationURL--->"+registrationURL);                            
            }
    }
}
