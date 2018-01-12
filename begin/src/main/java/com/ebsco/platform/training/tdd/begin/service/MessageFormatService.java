package com.ebsco.platform.training.tdd.begin.service;

import com.ebsco.platform.training.tdd.begin.model.FormattedGreetingDTO;
import com.ebsco.platform.training.tdd.begin.model.GreetingDTO;

public interface MessageFormatService {
    public FormattedGreetingDTO formatGreetingMessage(GreetingDTO greeting);
}
