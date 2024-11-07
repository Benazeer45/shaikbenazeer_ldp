package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/logger")
public class LoggerController {

    private static final Logger logger = LoggerFactory.getLogger(LoggerController.class);

    @GetMapping("/log")
    public String logMessages() {
        logger.trace("Entering logMessages() method - TRACE level logging");
        logger.debug("Preparing to return log messages - DEBUG level logging");

        String responseMessage = "Logger messages have been generated!";
        logger.info("Response message generated: {}", responseMessage);

        try {
            boolean condition = true;
            if (condition) {
                logger.warn("Warning: This is a sample warning message from the logMessages() method");
            }

            int result = 10 / 0;
            logger.info("Calculation result: {}", result);
        } catch (ArithmeticException e) {
            logger.error("Error occurred while calculating: {}", e.getMessage());
        }

        logger.info("Exiting logMessages() method - INFO level logging");
        return responseMessage;
    }
}
