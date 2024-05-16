package com.FC.SharedOfficePlatform.domain.attendees.controller;

import com.FC.SharedOfficePlatform.domain.attendees.service.AttendeesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class AttendeesController {

    private final AttendeesService attendeesService;

}
