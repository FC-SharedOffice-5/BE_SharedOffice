package com.FC.SharedOfficePlatform.domain.freeBoard.controller;

import com.FC.SharedOfficePlatform.domain.freeBoard.dto.request.FreeBoardRequest;
import com.FC.SharedOfficePlatform.domain.freeBoard.dto.response.FreeBoardDetailResponse;
import com.FC.SharedOfficePlatform.domain.freeBoard.dto.response.FreeBoardListResponse;
import com.FC.SharedOfficePlatform.domain.freeBoard.dto.response.FreeBoardResponse;
import com.FC.SharedOfficePlatform.domain.freeBoard.service.FreeBoardService;
import com.FC.SharedOfficePlatform.global.security.CustomMemberDetails;
import com.FC.SharedOfficePlatform.global.util.ResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/community/freeBoards")
@Slf4j
public class FreeBoardController {

    private final FreeBoardService freeBoardService;

    @PostMapping
    public ResponseEntity<FreeBoardResponse> insertFreeBoard(@RequestBody FreeBoardRequest request) {
        FreeBoardResponse freeBoardResponse = freeBoardService.insertFreeBoard(request);
        return new ResponseEntity<>(freeBoardResponse, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<ResponseDTO<List<FreeBoardListResponse>>> getAllFreeBoard() {
        List<FreeBoardListResponse> freeBoardListResponse = freeBoardService.getAllFreeBoard();
        return ResponseEntity.ok(ResponseDTO.okWithData(freeBoardListResponse));
    }

    @GetMapping("/{boardId}")
    public ResponseEntity<ResponseDTO<FreeBoardDetailResponse>> getFreeBoard(@PathVariable Long boardId, Authentication authentication) {
        CustomMemberDetails userDetails = (CustomMemberDetails) authentication.getPrincipal();
        Long memberId = userDetails.getId();

        FreeBoardDetailResponse freeBoardResponse = freeBoardService.getFreeBoard(boardId,memberId);
        return ResponseEntity.ok(ResponseDTO.okWithData(freeBoardResponse));
    }

}
