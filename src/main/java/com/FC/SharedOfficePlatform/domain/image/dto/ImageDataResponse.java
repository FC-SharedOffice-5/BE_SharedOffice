package com.FC.SharedOfficePlatform.domain.image.dto;
import com.FC.SharedOfficePlatform.domain.image.entity.ImageData;

public record ImageDataResponse(
    Long imageId,
    String fileName,
    String url,
    Long memberId,
    Long boardId
) {
    public static ImageDataResponse from(ImageData imageData) {
        Long memberId = (imageData.getMember() != null) ? imageData.getMember().getId() : null;
        Long boardId = (imageData.getFreeBoard() != null) ? imageData.getFreeBoard().getBoardId() : null;
        return new ImageDataResponse(
            imageData.getId(),
            imageData.getName(),
            imageData.getUrl(),
            memberId,
            boardId
        );
    }
}
