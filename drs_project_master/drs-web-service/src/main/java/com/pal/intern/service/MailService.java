package com.pal.intern.service;

import java.util.Map;

public interface MailService {

    /**
     * send email with option data
     *
     * @param dataSend key: subject (subject of email) key: body (body of email)
     * key: to (List EmailAddress ) key: cc (List EmailAddress )
     * @throws Exception
     */
    public void sendMail(Map<String, Object> dataSend) throws Exception;

    public Map<String, Object> getAllContactFromServerMail(int pageSize,int offSet) throws Exception;

}
