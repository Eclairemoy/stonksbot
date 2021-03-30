package com.whatsappstonksbot.bot;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@RestController
public class MessagingController {
    private final Set<String> repeatCallers = Collections.synchronizedSet(new HashSet<>());

    @PostMapping(path="/messages", produces = "text/plain")
    public String service(@RequestParam("From") String fromNumber,
                          @RequestParam("Body") String symbol) {

        if (!repeatCallers.contains((fromNumber))) {
            repeatCallers.add(fromNumber);
            return "Welcome to stonksbot \uD83D\uDCC8. Text me a valid ticker symbol and I'll give you quote data.";
        }
        return "We've heard from you.";
    }
}