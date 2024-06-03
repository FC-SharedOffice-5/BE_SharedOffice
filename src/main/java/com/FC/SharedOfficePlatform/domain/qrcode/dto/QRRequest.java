package com.FC.SharedOfficePlatform.domain.qrcode.dto;

public record QRRequest(
    String email,
    String memberName,
    String memberNickname
) {

}
