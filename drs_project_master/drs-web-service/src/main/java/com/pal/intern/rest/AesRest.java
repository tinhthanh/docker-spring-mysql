package com.pal.intern.rest;

import com.pal.intern.config.api.ApiError;
import com.pal.intern.service.AesService;
import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/aes_keys")
public class AesRest {

    @Autowired
    private AesService aesService;

    @RequestMapping(value = "/{rawKey}", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> getAesCode(@PathVariable("rawKey") String rawKey) {
        return ResponseEntity.ok(this.aesService.encrypt(rawKey));
    }

    @RequestMapping(value = "/decrypt/{encryptCode}", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> decryptAesCode(@PathVariable("encryptCode") String encryptCode, HttpServletRequest request) {
        String rawCode;
        try {
            rawCode = this.aesService.decrypt(encryptCode);
        } catch (Exception e) {
            ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(), ApiError.getFullURL(request), Arrays.asList("not valid aes code", e.getMessage()));
            return new ResponseEntity<>(apiError, apiError.getStatus());
        }
        return ResponseEntity.ok(rawCode);
    }

}
