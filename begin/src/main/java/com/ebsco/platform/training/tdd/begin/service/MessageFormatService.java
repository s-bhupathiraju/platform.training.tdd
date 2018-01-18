package com.ebsco.platform.training.tdd.begin.service;

import com.ebsco.platform.training.tdd.begin.dto.FormattedGreetingDTO;
import com.ebsco.platform.training.tdd.begin.dto.GreetingDTO;

public interface MessageFormatService {
    public FormattedGreetingDTO formatGreetingMessage(GreetingDTO greeting);
}
