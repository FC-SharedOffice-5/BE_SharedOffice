package com.FC.SharedOfficePlatform.domain.freeBoard.service;

import com.FC.SharedOfficePlatform.domain.comment.dto.response.CommentListResponse;
import com.FC.SharedOfficePlatform.domain.comment.repository.CommentRepository;
import com.FC.SharedOfficePlatform.domain.freeBoard.dto.request.FreeBoardRequest;
import com.FC.SharedOfficePlatform.domain.freeBoard.dto.response.FreeBoardDetailResponse;
import com.FC.SharedOfficePlatform.domain.freeBoard.dto.response.FreeBoardListResponse;
import com.FC.SharedOfficePlatform.domain.freeBoard.dto.response.FreeBoardResponse;
import com.FC.SharedOfficePlatform.domain.freeBoard.entity.FreeBoard;
import com.FC.SharedOfficePlatform.domain.freeBoard.exception.FreeBoardNotFoundException;
import com.FC.SharedOfficePlatform.domain.freeBoard.repository.FreeBoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class FreeBoardService {

    private final FreeBoardRepository freeBoardRepository;
    private final CommentRepository commentRepository;

    @Transactional
    public FreeBoardResponse insertFreeBoard(FreeBoardRequest request) {
        FreeBoard freeBoard = request.toEntity();
        FreeBoard savedFreeBoard = freeBoardRepository.save(freeBoard);
        return FreeBoardResponse.from(savedFreeBoard);
    }

    @Transactional(readOnly = true)
    public List<FreeBoardListResponse> getAllFreeBoard() {
        return freeBoardRepository.findAllWithLikesCount();
    }

    @Transactional(readOnly = true)
    public FreeBoardDetailResponse getFreeBoard(Long boardId, Long memberId) {
        FreeBoardDetailResponse freeBoardDetailResponse = freeBoardRepository.findByBoardIdWithLikesCount(boardId, memberId)
                .orElseThrow(() -> new FreeBoardNotFoundException("Document with ID " + boardId + " not found"));

        List<CommentListResponse> comments = commentRepository.findByLinkIdAndLinkCategory(boardId, 0, memberId);

        return new FreeBoardDetailResponse(
                freeBoardDetailResponse.getBoardId(),
                freeBoardDetailResponse.getMemberId(),
                freeBoardDetailResponse.getOfficeId(),
                freeBoardDetailResponse.getBoardTitle(),
                freeBoardDetailResponse.getBoardContents(),
                freeBoardDetailResponse.getLikesCount(),
                freeBoardDetailResponse.getMemberLike(),
                freeBoardDetailResponse.getMemberNickname(),
                freeBoardDetailResponse.getOfficeName(),
                comments
        );
    }
}
