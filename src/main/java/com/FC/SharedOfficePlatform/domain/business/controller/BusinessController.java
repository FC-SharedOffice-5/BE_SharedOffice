package com.FC.SharedOfficePlatform.domain.business.controller;

import com.FC.SharedOfficePlatform.domain.business.service.BusinessService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class BusinessController {

    private final BusinessService businessService;

}
