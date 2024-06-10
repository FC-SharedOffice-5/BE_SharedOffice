package com.FC.SharedOfficePlatform.domain.image.controller;

import com.FC.SharedOfficePlatform.domain.image.dto.ImageDataResponse;
import com.FC.SharedOfficePlatform.domain.image.entity.ImageData;
import com.FC.SharedOfficePlatform.domain.image.service.ImageDataService;
import com.FC.SharedOfficePlatform.global.util.ResponseDTO;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/images")
@RequiredArgsConstructor
public class ImageDataController {

    private final ImageDataService imageDataService;

    @PostMapping
    public ResponseEntity<ResponseDTO<ImageDataResponse>> uploadImage(
        @RequestParam("images") MultipartFile file,
        @RequestParam("entityType") String entityType,
        @RequestParam("entityId") Long entityId,
        HttpServletRequest request
    ) throws IOException, NoSuchAlgorithmException {
        ImageDataResponse response = imageDataService.uploadImage(file, entityType, entityId, request);
        return ResponseEntity.ok(ResponseDTO.okWithData(response));
    }

    // ->return image itself in the browser, with this, we can download images in the browser through Url.
    @GetMapping("/{fileName}")
    public ResponseEntity<?> downloadImage(@PathVariable String fileName) {
        byte[] imageData = imageDataService.downloadImage(fileName);

        // Determine the MIME type based on the file extension (Multipurpose Internet Mail Extensions)
        String contentType;
        if (fileName.endsWith(".png")) {
            contentType = "image/png";
        } else if (fileName.endsWith(".jpg") || fileName.endsWith(".jpeg")) {
            contentType = "image/jpeg";
        } else if (fileName.endsWith(".gif")) {
            contentType = "image/gif";
        } else if (fileName.endsWith(".bmp")) {
            contentType = "image/bmp";
        } else if (fileName.endsWith(".tiff")) {
            contentType = "image/tiff";
        } else {
            contentType = "application/octet-stream"; // Default to binary stream if unknown type
        }
        return ResponseEntity
            .status(HttpStatus.OK)
            .contentType(MediaType.valueOf(contentType))
            .body(imageData);
    }

    @GetMapping("/url/{imageId}")
    public ResponseEntity<ResponseDTO<ImageDataResponse>> getImageUrl(
        @PathVariable Long imageId
    ) {
        ImageDataResponse imageUrl = imageDataService.getImageUrl(imageId);
        return ResponseEntity.ok(ResponseDTO.okWithData(imageUrl));
    }

    @GetMapping("/urls")
    public ResponseEntity<ResponseDTO<List<ImageDataResponse>>> getAllImageUrls() {
        List<ImageDataResponse> allImageUrls = imageDataService.getAllImageUrls();
        return ResponseEntity.ok(ResponseDTO.okWithData(allImageUrls));
    }

    @DeleteMapping("/{imageId}")
    public ResponseEntity<ResponseDTO<Void>> deleteImage(@PathVariable Long imageId) {
        imageDataService.deleteImage(imageId);
        return ResponseEntity.ok(ResponseDTO.ok());
    }

    @GetMapping("/member/{memberId}")
    public ResponseEntity<ResponseDTO<List<ImageDataResponse>>> getImagesByMember(@PathVariable Long memberId) {
        List<ImageData> imagesByMember = imageDataService.getImagesByMember(memberId);
        List<ImageDataResponse> responses = imagesByMember.stream()
            .map(ImageDataResponse::from)
            .collect(Collectors.toList());
        return ResponseEntity.ok(ResponseDTO.okWithData(responses));
    }

    @GetMapping("/freeBoard/{boardId}")
    public ResponseEntity<ResponseDTO<List<ImageDataResponse>>> getImagesByFreeBoard(@PathVariable Long boardId) {
        List<ImageData> imagesByFreeBoard = imageDataService.getImagesByFreeBoard(boardId);
        List<ImageDataResponse> responses = imagesByFreeBoard.stream()
            .map(ImageDataResponse::from)
            .collect(Collectors.toList());
        return ResponseEntity.ok(ResponseDTO.okWithData(responses));
    }

}


