package com.FC.SharedOfficePlatform.domain.schedule.service;

import com.FC.SharedOfficePlatform.domain.attendees.dto.request.AttendeesRequest;
import com.FC.SharedOfficePlatform.domain.attendees.dto.response.AttendeesResponse;
import com.FC.SharedOfficePlatform.domain.attendees.entity.Attendees;
import com.FC.SharedOfficePlatform.domain.attendees.repository.AttendeesRepository;
import com.FC.SharedOfficePlatform.domain.schedule.dto.request.ScheduleRequest;
import com.FC.SharedOfficePlatform.domain.schedule.dto.request.ScheduleUpdateRequest;
import com.FC.SharedOfficePlatform.domain.schedule.dto.response.ScheduleListResponse;
import com.FC.SharedOfficePlatform.domain.schedule.dto.response.ScheduleResponse;
import com.FC.SharedOfficePlatform.domain.schedule.entity.Schedule;
import com.FC.SharedOfficePlatform.domain.schedule.exception.ScheduleNotFoundException;
import com.FC.SharedOfficePlatform.domain.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final AttendeesRepository attendeesRepository;

    @Transactional
    public ScheduleResponse insertSchedule(ScheduleRequest request) {
        Schedule schedule = request.toEntity();
        log.info("Saving schedule: {}", schedule);
        Schedule savedSchedule = scheduleRepository.save(schedule);

        // 참석자 정보 저장
        List<Attendees> saveAttendees = request.attendeesList().stream()
                .map(ar -> {
                    Attendees attendee = ar.toEntity(savedSchedule);
                    return attendee;
                })
                .collect(Collectors.toList());
        attendeesRepository.saveAll(saveAttendees); // 참석자 목록 저장

        // 저장된 스케줄 정보를 기반으로 응답 생성
        return ScheduleResponse.from(savedSchedule);
    }

    @Transactional(readOnly = true)
    public List<ScheduleListResponse> getAllSchedule(Long memberId, int year, int month) {

        // 해당 년월의 시작일과 종료일 계산
        LocalDate startDate = LocalDate.of(year, month, 1);
        LocalDate endDate = startDate.plusMonths(1).minusDays(1);

        // LocalDate를 LocalDateTime으로 변환 (시작 시간과 종료 시간을 정의하기 위해)
        LocalDateTime startDateTime = startDate.atStartOfDay();
        LocalDateTime endDateTime = endDate.atTime(23, 59, 59);

        return scheduleRepository.findByMemberIdAndEventStartDateBetween(memberId, startDateTime, endDateTime).stream()
                .map(ScheduleListResponse::from)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ScheduleResponse getSchedule(Long eventId) {
        Schedule schedule = scheduleRepository.findById(eventId)
                .orElseThrow(() -> {
                    log.error("Schedule with ID {} not found", eventId); // 로그 추가
                    return new ScheduleNotFoundException("Schedule with ID " + eventId + " not found");
                });
        return ScheduleResponse.from(schedule);
    }

    @Transactional
    public ScheduleResponse updateSchedule(Long eventId, ScheduleUpdateRequest request) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // 기존 일정 찾기
        Schedule schedule = scheduleRepository.findById(eventId)
                .orElseThrow(() -> new ScheduleNotFoundException("Schedule with ID " + eventId + " not found"));

        // 일정 정보 업데이트
        schedule.setResId(request.getResId());
        schedule.setEventColor(request.getEventColor());
        schedule.setEventTitle(request.getEventTitle());
        schedule.setEventStartDate(LocalDateTime.parse(request.getEventStartDate(), formatter));
        schedule.setEventEndDate(LocalDateTime.parse(request.getEventEndDate(), formatter));
        schedule.setEventLocation(request.getEventLocation());
        schedule.setEventMemo(request.getEventMemo());

        // 기존 참석자 정보 삭제
        List<Attendees> attendees = attendeesRepository.findBySchedule(schedule);
        if (!attendees.isEmpty()) {
            attendeesRepository.deleteAllInBatch(attendees);
        }

        // 참석자 목록 저장
        List<Attendees> saveAttendees = request.getAttendeesList().stream()
                .map(ar -> {
                    Attendees attendee = ar.toEntity(schedule);
                    return attendeesRepository.save(attendee);
                })
                .collect(Collectors.toList());

        // 변경 사항을 데이터베이스에 반영
        Schedule updatedSchedule = scheduleRepository.save(schedule);

        return ScheduleResponse.from(updatedSchedule);
    }

}
