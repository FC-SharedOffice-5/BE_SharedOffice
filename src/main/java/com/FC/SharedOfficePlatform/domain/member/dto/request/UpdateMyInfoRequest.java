package com.FC.SharedOfficePlatform.domain.member.dto.request;

import java.time.LocalDate;

public record UpdateMyInfoRequest(
    String memberName,
    String memberNickname,
    LocalDate memberBirth
) {

}
