package com.FC.SharedOfficePlatform.domain.image.service;

import com.FC.SharedOfficePlatform.domain.auth.exception.MemberNotFoundException;
import com.FC.SharedOfficePlatform.domain.freeBoard.entity.FreeBoard;
import com.FC.SharedOfficePlatform.domain.freeBoard.repository.FreeBoardRepository;
import com.FC.SharedOfficePlatform.domain.image.dto.ImageDataResponse;
import com.FC.SharedOfficePlatform.domain.image.entity.ImageData;
import com.FC.SharedOfficePlatform.domain.image.exception.FreeBoardNotFoundException;
import com.FC.SharedOfficePlatform.domain.image.exception.ImageFileAlreadyRegisteredException;
import com.FC.SharedOfficePlatform.domain.image.exception.ImageFileNotFoundException;
import com.FC.SharedOfficePlatform.domain.image.exception.OfficeNotFoundException;
import com.FC.SharedOfficePlatform.domain.image.exception.PlaceNotFoundException;
import com.FC.SharedOfficePlatform.domain.image.repository.ImageDataRepository;
import com.FC.SharedOfficePlatform.domain.member.entity.Member;
import com.FC.SharedOfficePlatform.domain.member.repository.MemberRepository;
import com.FC.SharedOfficePlatform.domain.office.entity.Office;
import com.FC.SharedOfficePlatform.domain.office.repository.OfficeRepository;
import com.FC.SharedOfficePlatform.domain.place.entity.Place;
import com.FC.SharedOfficePlatform.domain.place.repository.PlaceRepository;
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
    private final MemberRepository memberRepository;
    private final FreeBoardRepository freeBoardRepository;
    private final OfficeRepository officeRepository;
    private final PlaceRepository placeRepository;

    public ImageDataResponse uploadImage(MultipartFile multipartFile, String entityType, Long entityId, HttpServletRequest httpServletRequest)
        throws IOException, NoSuchAlgorithmException {
        String imageHash = generateImageHash(multipartFile.getBytes());
        Optional<ImageData> existingImage = imageDataRepository.findByHash(imageHash);
        if (existingImage.isPresent()) {
            throw new ImageFileAlreadyRegisteredException();
        }

        String baseUrl = String.format(
            "%s://%s:%d/images",
            httpServletRequest.getScheme(),
            httpServletRequest.getServerName(),
            httpServletRequest.getServerPort()
        );

        Member member = null;
        FreeBoard freeBoard = null;
        Office office = null;
        Place place = null;

        // Determine the entity type and retrieve the corresponding entity
        if ("member".equalsIgnoreCase(entityType)) {
            member = memberRepository.findById(entityId)
                .orElseThrow(() -> new MemberNotFoundException());
        } else if ("freeBoard".equalsIgnoreCase(entityType)) {
            freeBoard = freeBoardRepository.findById(entityId)
                .orElseThrow(() -> new FreeBoardNotFoundException());
        } else if ("office".equalsIgnoreCase(entityType)) {
            office = officeRepository.findById(entityId)
                .orElseThrow(() -> new OfficeNotFoundException());
        } else if ("place".equalsIgnoreCase(entityType)) {
            place = placeRepository.findById(entityId)
                .orElseThrow(() -> new PlaceNotFoundException());
        }

        // Save new image data to the database if it does not already exist
        ImageData savedNewImageData = imageDataRepository.save(
            ImageData.builder()
                .name(multipartFile.getOriginalFilename())
                .type(multipartFile.getContentType())
                .hash(imageHash)
                .imageData(ImageUtils.compressImage(multipartFile.getBytes()))
                .url(baseUrl + "/" + multipartFile.getOriginalFilename())  // Construct the URL
                .member(member)
                .freeBoard(freeBoard)
                .office(office)
                .place(place)
                .build()
        );

        if (member != null) {
            member.getImages().add(savedNewImageData);
        }
        if (freeBoard != null) {
            freeBoard.getImages().add(savedNewImageData);
        }
        if (office != null) {
            office.getImages().add(savedNewImageData);
        }
        if (place != null) {
            place.getImages().add(savedNewImageData);
        }

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
            .map(ImageDataResponse::from)
            .collect(Collectors.toList());
    }

    public void deleteImage(Long imageId) {
        ImageData existingImageData = imageDataRepository.findById(imageId)
            .orElseThrow(() -> new ImageFileNotFoundException());
        imageDataRepository.delete(existingImageData);
    }

    public List<ImageData> getImagesByMember(Long memberId) {
        Member member = memberRepository.findById(memberId)
            .orElseThrow(() -> new MemberNotFoundException());
        return imageDataRepository.findByMember(member);
    }

    public List<ImageData> getImagesByFreeBoard(Long boardId) {
        FreeBoard freeBoard = freeBoardRepository.findById(boardId)
            .orElseThrow(() -> new FreeBoardNotFoundException());
        return imageDataRepository.findByFreeBoard(freeBoard);
    }

    public List<ImageData> getImagesByOffice(Long officeId) {
        Office office = officeRepository.findById(officeId)
            .orElseThrow(() -> new OfficeNotFoundException());
        return imageDataRepository.findByOffice(office);
    }

    public List<ImageData> getImagesByPlace(Long placeId) {
        Place place = placeRepository.findById(placeId)
            .orElseThrow(() -> new PlaceNotFoundException());
        return imageDataRepository.findByPlace(place);
    }

}
