package com.ebsco.platform.training.tdd.begin.app.controller;

import java.net.MalformedURLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ebsco.platform.training.tdd.begin.app.dto.FormattedGreetingDTO;
import com.ebsco.platform.training.tdd.begin.app.dto.GreetingDTO;
import com.ebsco.platform.training.tdd.begin.app.service.MessageFormatService;
import com.ebsco.platform.training.tdd.begin.app.service.impl.MessageFormatServiceImpl;

@RestController
public class MessageFormatController {

    @Autowired
    MessageFormatService messageFormatService;
    
    public MessageFormatController(MessageFormatService messageFormatService) {
    		this.messageFormatService = messageFormatService;
    }
    
    @RequestMapping(method = RequestMethod.POST,
            value = "/formatgreeting",
            consumes = "application/json",
            produces = "application/json;charset=UTF-8")
    public ResponseEntity<FormattedGreetingDTO> formatGreeting(@RequestBody GreetingDTO greetingDTO) throws MalformedURLException {
        return new ResponseEntity<FormattedGreetingDTO>(messageFormatService.formatGreetingMessage(greetingDTO), HttpStatus.OK);
    }

}
