package com.FC.SharedOfficePlatform.domain.place.controller;

import com.FC.SharedOfficePlatform.domain.place.service.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class PlaceController {

    private final PlaceService placeService;

}
