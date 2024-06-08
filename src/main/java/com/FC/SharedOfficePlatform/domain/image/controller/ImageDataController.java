package com.FC.SharedOfficePlatform.domain.image.controller;

import com.FC.SharedOfficePlatform.domain.image.dto.ImageDataResponse;
import com.FC.SharedOfficePlatform.domain.image.service.ImageDataService;
import com.FC.SharedOfficePlatform.global.util.ResponseDTO;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
        @RequestParam("images") MultipartFile file, HttpServletRequest request
    ) throws IOException, NoSuchAlgorithmException {
        ImageDataResponse response = imageDataService.uploadImage(file, request);
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
}


