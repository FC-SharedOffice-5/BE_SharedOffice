package com.FC.SharedOfficePlatform.domain.freeBoard.repository;

import com.FC.SharedOfficePlatform.domain.freeBoard.dto.response.FreeBoardDetailResponse;
import com.FC.SharedOfficePlatform.domain.freeBoard.dto.response.FreeBoardListResponse;
import com.FC.SharedOfficePlatform.domain.freeBoard.dto.response.FreeBoardResponse;
import com.FC.SharedOfficePlatform.domain.freeBoard.entity.FreeBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FreeBoardRepository extends JpaRepository<FreeBoard, Long> {
    List<FreeBoard> findByMemberId(Long memberId);

    @Query("SELECT new com.FC.SharedOfficePlatform.domain.freeBoard.dto.response.FreeBoardListResponse(fb.boardId, fb.memberId, fb.officeId, fb.boardTitle, COUNT(ml.likeId) as likesCount, fb.createdAt, fb.updatedAt) " +
            "FROM FreeBoard fb " +
            "LEFT JOIN MemberLike ml ON ml.linkCode = fb.boardId AND ml.linkCategory = 1 " +
            "GROUP BY fb.boardId")
    List<FreeBoardListResponse> findAllWithLikesCount();

    @Query("SELECT new com.FC.SharedOfficePlatform.domain.freeBoard.dto.response.FreeBoardDetailResponse(fb.boardId, fb.memberId, fb.officeId, fb.boardTitle, fb.boardContents, " +
            "COUNT(ml.likeId) as likesCount, MAX(CASE WHEN ml.memberId = :memberId THEN 1 ELSE 0 END) AS memberLike) " +
            "FROM FreeBoard fb " +
            "LEFT JOIN MemberLike ml ON ml.linkCode = fb.boardId AND ml.linkCategory = 1 " +
            "WHERE fb.boardId = :boardId " +
            "GROUP BY fb.boardId")
    Optional<FreeBoardDetailResponse> findByBoardIdWithLikesCount(Long boardId, long memberId);
}
