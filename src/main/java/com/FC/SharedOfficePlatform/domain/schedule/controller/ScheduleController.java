package com.FC.SharedOfficePlatform.domain.schedule.controller;

import com.FC.SharedOfficePlatform.domain.schedule.dto.request.ScheduleRequest;
import com.FC.SharedOfficePlatform.domain.schedule.dto.request.ScheduleUpdateRequest;
import com.FC.SharedOfficePlatform.domain.schedule.dto.response.ScheduleListResponse;
import com.FC.SharedOfficePlatform.domain.schedule.dto.response.ScheduleResponse;
import com.FC.SharedOfficePlatform.domain.schedule.service.ScheduleService;
import com.FC.SharedOfficePlatform.global.util.ResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/schedules")
@Slf4j
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping
    public ResponseEntity<ScheduleResponse> insertSchedule(@RequestBody ScheduleRequest scheduleRequest) {
        ScheduleResponse scheduleResponse = scheduleService.insertSchedule(scheduleRequest);
        return new ResponseEntity<>(scheduleResponse, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<ResponseDTO<List<ScheduleListResponse>>> getAllSchedule(
            @RequestParam Long memberId,
            @RequestParam int year,
            @RequestParam int month
    ) {
        List<ScheduleListResponse> scheduleListResponse = scheduleService.getAllSchedule(memberId, year, month);
        return ResponseEntity.ok(ResponseDTO.okWithData(scheduleListResponse));
    }

    @GetMapping("/{eventId}")
    public ResponseEntity<ResponseDTO<ScheduleResponse>> getSchedule(@PathVariable Long eventId) {
        ScheduleResponse scheduleResponse = scheduleService.getSchedule(eventId);
        return ResponseEntity.ok(ResponseDTO.okWithData(scheduleResponse));
    }

    @PutMapping("/{eventId}")
    public ResponseEntity<ScheduleResponse> updateSchedule(@PathVariable Long eventId, @RequestBody ScheduleUpdateRequest request) {
        ScheduleResponse response = scheduleService.updateSchedule(eventId,request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
