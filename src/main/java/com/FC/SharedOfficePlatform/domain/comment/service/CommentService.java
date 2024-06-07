package com.FC.SharedOfficePlatform.domain.comment.service;

import com.FC.SharedOfficePlatform.domain.comment.dto.request.CommentRequest;
import com.FC.SharedOfficePlatform.domain.comment.dto.response.CommentResponse;
import com.FC.SharedOfficePlatform.domain.comment.entity.Comment;
import com.FC.SharedOfficePlatform.domain.comment.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommentService {

    private final CommentRepository commentRepository;

    @Transactional
    public CommentResponse insertComment(CommentRequest request) {
        Comment comment = request.toEntity();
        Comment savedComment = commentRepository.save(comment);
        return CommentResponse.from(savedComment);
    }

}
