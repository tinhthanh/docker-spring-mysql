package com.pal.intern.rest;

import com.pal.intern.service.MailService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping
public class MailRest {

    @Autowired
    private MailService mailService;

    @RequestMapping(value = "/mail-address",method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getAllEmailAddress(
            @RequestParam(value = "offset", required = true, defaultValue = "0") int offset,
            @RequestParam(value = "limit", required = true, defaultValue = "10") int limit) throws Exception {
        Map<String, Object> result = this.mailService.getAllContactFromServerMail(limit, offset);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
