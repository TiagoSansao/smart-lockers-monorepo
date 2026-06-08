package com.smartlockers.LockerEmbeddedSystem.controller;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class Controller {

    private static final Logger logger = LoggerFactory.getLogger(Controller.class);

    @PostMapping(path = "/lockerShelf/{lockerShelfId}/open")
    public void openLockerShelf(@PathVariable Long lockerShelfId) {
        logger.info("Opened lockerShelfId %s.".formatted(lockerShelfId.toString()));
    }
}
