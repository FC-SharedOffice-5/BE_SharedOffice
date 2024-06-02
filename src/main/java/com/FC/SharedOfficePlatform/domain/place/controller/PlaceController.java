package com.FC.SharedOfficePlatform.domain.place.controller;

import com.FC.SharedOfficePlatform.domain.place.dto.PlaceFloorStats;
import com.FC.SharedOfficePlatform.domain.place.dto.request.PlaceRequest;
import com.FC.SharedOfficePlatform.domain.place.dto.response.PlaceDetailResponse;
import com.FC.SharedOfficePlatform.domain.place.dto.response.PlaceResponse;
import com.FC.SharedOfficePlatform.domain.place.service.PlaceService;
import com.FC.SharedOfficePlatform.global.util.ResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/offices/places")
public class PlaceController {

    private final PlaceService placeService;

    @PostMapping
    public ResponseEntity<PlaceResponse> insertPlace(@RequestBody PlaceRequest request) {
        PlaceResponse placeResponse = placeService.insertPlace(request);
        return new ResponseEntity<>(placeResponse, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<ResponseDTO<List<PlaceFloorStats>>> getAllPlaceFloorStats(@RequestParam long officeId) {
        List<PlaceFloorStats> groupedPlaces = placeService.getAllPlaceFloorStats(officeId);
        return ResponseEntity.ok(ResponseDTO.okWithData(groupedPlaces));
    }

    @GetMapping("/{placeId}")
    public ResponseEntity<ResponseDTO<PlaceDetailResponse>> getDetailPlace(@PathVariable Long placeId) {
        PlaceDetailResponse placeDetailResponse = placeService.getDetailPlace(placeId);
        return ResponseEntity.ok(ResponseDTO.okWithData(placeDetailResponse));
    }

}
