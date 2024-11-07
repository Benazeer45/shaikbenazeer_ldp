package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExampleService {

    private static final Logger logger = LoggerFactory.getLogger(ExampleService.class);

    public void performAction() {
        logger.info("Starting action...");

        try {
            int result = process();
            logger.debug("Processing result: {}", result);
        } catch (Exception e) {
            logger.error("An error occurred during processing", e);
        } finally {
            logger.info("Action completed.");
        }
    }

    private int process() throws Exception {
        logger.debug("Executing process method...");
        // Simulating some processing
        if (Math.random() > 0.5) {
            throw new Exception("Simulated exception");
        }
        logger.info("Process completed successfully.");
        return 42; // Simulated successful processing result
    }

    public static void main(String[] args) {
        ExampleService service = new ExampleService();
        service.performAction();
    }
}
