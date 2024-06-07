package com.FC.SharedOfficePlatform.domain.comment.controller;

import com.FC.SharedOfficePlatform.domain.comment.dto.request.CommentRequest;
import com.FC.SharedOfficePlatform.domain.comment.dto.response.CommentResponse;
import com.FC.SharedOfficePlatform.domain.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/community/comments")
@Slf4j
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<CommentResponse> insertComment(@RequestBody CommentRequest request) {
        CommentResponse commentResponse = commentService.insertComment(request);
        return new ResponseEntity<>(commentResponse, HttpStatus.CREATED);
    }

}
