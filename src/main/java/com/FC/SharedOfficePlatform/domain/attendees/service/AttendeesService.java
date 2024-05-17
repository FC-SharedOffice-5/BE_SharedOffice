package com.FC.SharedOfficePlatform.domain.attendees.service;

import com.FC.SharedOfficePlatform.domain.attendees.repository.AttendeesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AttendeesService {

    private final AttendeesRepository attendeesRepository;

}
