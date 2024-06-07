package com.FC.SharedOfficePlatform.domain.freeBoard.service;

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
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class FreeBoardService {

    private final FreeBoardRepository freeBoardRepository;

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
        return freeBoardRepository.findByBoardIdWithLikesCount(boardId, memberId)
                .orElseThrow(() -> {
                    log.error("Document with ID {} not found", boardId); // 로그 추가
                    return new FreeBoardNotFoundException("Document with ID " + boardId + " not found");
                });
    }

}
