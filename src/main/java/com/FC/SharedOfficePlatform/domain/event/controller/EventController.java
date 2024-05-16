package com.FC.SharedOfficePlatform.domain.event.controller;

import com.FC.SharedOfficePlatform.domain.event.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class EventController {

    private final EventService eventService;

}
