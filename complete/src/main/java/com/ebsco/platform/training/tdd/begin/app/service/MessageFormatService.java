package com.ebsco.platform.training.tdd.begin.app.service;

import com.ebsco.platform.training.tdd.begin.app.dto.FormattedGreetingDTO;
import com.ebsco.platform.training.tdd.begin.app.dto.GreetingDTO;

public interface MessageFormatService {
    public FormattedGreetingDTO formatGreetingMessage(GreetingDTO greeting);
}
