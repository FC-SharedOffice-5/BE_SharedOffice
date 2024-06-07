package com.FC.SharedOfficePlatform.domain.image.dto;
import com.FC.SharedOfficePlatform.domain.image.entity.ImageData;

public record ImageDataResponse(
    Long imageId,
    String fileName,
    String url
) {
    public static ImageDataResponse from(ImageData imageData) {
        return new ImageDataResponse(
            imageData.getId(),
            imageData.getName(),
            imageData.getUrl()
        );
    }
}
