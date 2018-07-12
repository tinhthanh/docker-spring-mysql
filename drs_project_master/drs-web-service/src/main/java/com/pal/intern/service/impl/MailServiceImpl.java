package com.pal.intern.service.impl;

import com.pal.intern.config.app.ConfigVariable;
import com.pal.intern.config.app.ParamConfig;
import com.pal.intern.service.MailService;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import microsoft.exchange.webservices.data.core.ExchangeService;
import microsoft.exchange.webservices.data.core.enumeration.misc.ExchangeVersion;
import microsoft.exchange.webservices.data.core.enumeration.property.EmailAddressKey;
import microsoft.exchange.webservices.data.core.enumeration.property.WellKnownFolderName;
import microsoft.exchange.webservices.data.core.service.folder.Folder;
import microsoft.exchange.webservices.data.core.service.item.Contact;
import microsoft.exchange.webservices.data.core.service.item.EmailMessage;
import microsoft.exchange.webservices.data.core.service.item.Item;
import microsoft.exchange.webservices.data.credential.ExchangeCredentials;
import microsoft.exchange.webservices.data.credential.WebCredentials;
import microsoft.exchange.webservices.data.misc.NameResolutionCollection;
import microsoft.exchange.webservices.data.property.complex.EmailAddress;
import microsoft.exchange.webservices.data.property.complex.MessageBody;
import microsoft.exchange.webservices.data.search.FindItemsResults;
import microsoft.exchange.webservices.data.search.ItemView;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {

    public static final ExchangeVersion EXCHANGE_VERSION = ExchangeVersion.Exchange2010_SP2;

    private final Log LOGGER = LogFactory.getLog(this.getClass().getName());
    @Autowired
    private ParamConfig paramConfig;

    public ExchangeService getExchangeService() {
        ExchangeService exchangeService = new ExchangeService();
        try {

            String mailServerUserName = paramConfig.getParamConfig(ConfigVariable.SERVER_MAIL_USERNAME);
            String mailServerPassword = paramConfig.getMailServerPassword();
            String mailExchaneURL = paramConfig.getParamConfig(ConfigVariable.MAIL_EXCHANGE_SERVICE_URL);
            ExchangeCredentials credentials = new WebCredentials(mailServerUserName, mailServerPassword);
            exchangeService.setUrl(new URI(mailExchaneURL));
            exchangeService.setCredentials(credentials);
        } catch (URISyntaxException e) {
             LOGGER.error("Error when call method getExchangeService()", e);
        }
        return exchangeService;

    }

    @Override
    public void sendMail(Map<String, Object> dataSend) {
        try {

            EmailMessage emailMessage = new EmailMessage(this.getExchangeService());

            emailMessage.setSubject(dataSend.get("subject").toString());
            emailMessage.setBody(MessageBody.getMessageBodyFromText(dataSend.get("body").toString()));
            List<EmailAddress> listRecipients = (List<EmailAddress>) dataSend.get("to");
            emailMessage.getToRecipients().addEmailRange(listRecipients.stream().iterator());
            List<EmailAddress> listCCs = (List<EmailAddress>) dataSend.get("cc");
            if (listCCs != null) {
                emailMessage.getCcRecipients().addEmailRange(listCCs.stream().iterator());
            }
            emailMessage.sendAndSaveCopy();
        } catch (Exception e) {
           LOGGER.error("Error when call method sendMail() with param " + Arrays.asList(dataSend), e);
        }
    }

    @Override
    public Map<String, Object> getAllContactFromServerMail(int pageSize, int offSet) {
        Map<String, Object> result = new HashMap<>();
        try {
            ExchangeService service = this.getExchangeService();
            Folder folder = Folder.bind(service, WellKnownFolderName.Contacts);
            ItemView view = new ItemView(pageSize, offSet);
            FindItemsResults<Item> findResult = service.findItems(folder.getId(), view);
            Map<String, String> listMailAddress = new HashMap<>();
            for (Item item : findResult) {
                Contact c = (Contact) item;
                NameResolutionCollection nameResolution = service.resolveName(c.getEmailAddresses().getEmailAddress(EmailAddressKey.EmailAddress1).getAddress());
                nameResolution.forEach(e -> {
                    listMailAddress.put(e.getMailbox().getAddress(), e.getMailbox().getName());
                });
            }
            result.put("totalCount", folder.getTotalCount());
            result.put("listOfMails", listMailAddress);
        } catch (Exception e) {
           LOGGER.error("Error when call method getAllContactFromServerMail() with param " + Arrays.asList(pageSize, offSet), e);
        }
        return result;
    }

}
