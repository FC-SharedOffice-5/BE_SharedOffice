package com.FC.SharedOfficePlatform.domain.community.repository;

import com.FC.SharedOfficePlatform.domain.community.dto.response.CommunityListResponse;
import com.FC.SharedOfficePlatform.domain.freeBoard.entity.FreeBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommunityRepository extends JpaRepository<FreeBoard, Long> {

    @Query("SELECT new com.FC.SharedOfficePlatform.domain.community.dto.response.CommunityListResponse(" +
            "fb.boardId, fb.memberId, fb.officeId, fb.boardTitle, " +
            "COUNT(ml.likeId) as likesCount, " +
            "COUNT(cm.commentId) as commentCount, " +
            "m.memberNickname, o.officeName, " +
            "fb.createdAt, fb.updatedAt) " +
            "FROM FreeBoard fb " +
            "LEFT JOIN MemberLike ml ON ml.linkCode = fb.boardId AND ml.linkCategory = 1 " +
            "LEFT JOIN Comment cm ON cm.linkId = fb.boardId AND cm.linkCategory = 0 " +
            "LEFT JOIN Member m ON m.id = fb.memberId " +
            "LEFT JOIN Office o ON o.officeId = fb.officeId " +
            "WHERE fb.boardTitle LIKE %:boardTitle% " +
            "GROUP BY fb.boardId")
    List<CommunityListResponse> findAllWithLikesCountAndName(@Param("boardTitle") String boardTitle);
}
