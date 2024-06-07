package com.FC.SharedOfficePlatform.domain.image.service;

import com.FC.SharedOfficePlatform.domain.image.dto.ImageDataResponse;
import com.FC.SharedOfficePlatform.domain.image.entity.ImageData;
import com.FC.SharedOfficePlatform.domain.image.exception.ImageFileAlreadyRegisteredException;
import com.FC.SharedOfficePlatform.domain.image.exception.ImageFileNotFoundException;
import com.FC.SharedOfficePlatform.domain.image.repository.ImageDataRepository;
import com.FC.SharedOfficePlatform.global.util.ImageUtils;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class ImageDataService {

    private final ImageDataRepository imageDataRepository;

    public ImageDataResponse uploadImage(MultipartFile multipartFile, HttpServletRequest httpServletRequest)
        throws IOException, NoSuchAlgorithmException
    {
        String imageHash = generateImageHash(multipartFile.getBytes());
        Optional<ImageData> existingImage = imageDataRepository.findByHash(imageHash);
        if (existingImage.isPresent()) {
            throw new ImageFileAlreadyRegisteredException();
        }
        // Construct the base URL dynamically (we don't need to configure specific Url explicitly)
        String baseUrl = String.format(
            "%s://%s:%d/images",
            httpServletRequest.getScheme(),
            httpServletRequest.getServerName(),
            httpServletRequest.getServerPort()
            );
        // save new image data to a database if it does not already exist.
        ImageData savedNewImageData = imageDataRepository.save(
            ImageData.builder()
            .name(multipartFile.getOriginalFilename())
            .type(multipartFile.getContentType())
            .hash(imageHash)
            .imageData(ImageUtils.compressImage(multipartFile.getBytes()))
            .url(baseUrl + "/" + multipartFile.getOriginalFilename())  // Construct the URL
            .build()
            );
        return ImageDataResponse.from(savedNewImageData);
    }

    // to prevent uploading duplicated file.
    private String generateImageHash(byte[] imageData) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hashBytes = digest.digest(imageData);
        StringBuilder sb = new StringBuilder();
        for (byte b : hashBytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    // With this method, We can download image on the browser.
    public byte[] downloadImage(String fileName) {
        ImageData dbImageData = imageDataRepository.findByName(fileName)
            .orElseThrow(() -> new ImageFileNotFoundException());
        byte[] images = ImageUtils.decompressImage(dbImageData.getImageData());
        return images;
    }

    public ImageDataResponse getImageUrl(Long imageId) {
        ImageData dbImageData = imageDataRepository.findById(imageId)
            .orElseThrow(() -> new ImageFileNotFoundException());
        return ImageDataResponse.from(dbImageData);
    }

    public List<ImageDataResponse> getAllImageUrls() {
        List<ImageData> allImages = imageDataRepository.findAll();
        return allImages.stream()
            .map(imageData -> new ImageDataResponse(
                imageData.getId(),
                imageData.getName(),
                imageData.getUrl())
                )
            //.map(ImageDataResponse::from)
            .collect(Collectors.toList());
    }

}
