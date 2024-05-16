package com.FC.SharedOfficePlatform.domain.office.controller;

import com.FC.SharedOfficePlatform.domain.office.service.OfficeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class OfficeController {

    private final OfficeService officeService;

}
