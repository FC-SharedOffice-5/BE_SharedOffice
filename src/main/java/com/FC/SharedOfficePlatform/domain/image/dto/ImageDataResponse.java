package com.FC.SharedOfficePlatform.domain.image.dto;
import com.FC.SharedOfficePlatform.domain.image.entity.ImageData;

public record ImageDataResponse(
    Long imageId,
    String fileName,
    String url,
    Long memberId
) {
    public static ImageDataResponse from(ImageData imageData) {
        Long memberId = (imageData.getMember() != null) ? imageData.getMember().getId() : null;
        return new ImageDataResponse(
            imageData.getId(),
            imageData.getName(),
            imageData.getUrl(),
            memberId
        );
    }
}
