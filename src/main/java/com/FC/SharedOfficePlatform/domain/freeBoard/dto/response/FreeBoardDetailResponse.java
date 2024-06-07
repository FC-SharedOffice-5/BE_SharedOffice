package com.FC.SharedOfficePlatform.domain.freeBoard.dto.response;

import com.FC.SharedOfficePlatform.domain.comment.dto.response.CommentListResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Getter
@RequiredArgsConstructor
public class FreeBoardDetailResponse{
    Long boardId;
    long memberId;
    long officeId;
    String boardTitle;
    String boardContents;
    Long likesCount;
    Integer memberLike;
    List<CommentListResponse> comments;

    // 기존 생성자
    public FreeBoardDetailResponse(Long boardId, long memberId, long officeId, String boardTitle, String boardContents, Long likesCount, Integer memberLike) {
        this.boardId = boardId;
        this.memberId = memberId;
        this.officeId = officeId;
        this.boardTitle = boardTitle;
        this.boardContents = boardContents;
        this.likesCount = likesCount;
        this.memberLike = memberLike;
        this.comments = new ArrayList<>(); // 또는 null 처리
    }

    // comments를 포함한 모든 필드를 초기화하는 새로운 생성자 추가
    public FreeBoardDetailResponse(Long boardId, long memberId, long officeId, String boardTitle, String boardContents, Long likesCount, Integer memberLike, List<CommentListResponse> comments) {
        this.boardId = boardId;
        this.memberId = memberId;
        this.officeId = officeId;
        this.boardTitle = boardTitle;
        this.boardContents = boardContents;
        this.likesCount = likesCount;
        this.memberLike = memberLike;
        this.comments = comments; // comments도 초기화
    }
}


