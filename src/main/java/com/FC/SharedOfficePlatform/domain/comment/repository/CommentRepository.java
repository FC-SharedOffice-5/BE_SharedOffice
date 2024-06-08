package com.FC.SharedOfficePlatform.domain.comment.repository;

import com.FC.SharedOfficePlatform.domain.comment.dto.response.CommentListResponse;
import com.FC.SharedOfficePlatform.domain.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByMemberId(Long memberId);

    @Query("SELECT new com.FC.SharedOfficePlatform.domain.comment.dto.response.CommentListResponse(c.commentId, c.memberId, c.linkId, c.linkCategory, c.commentWrite, " +
            "COUNT(ml.likeId), MAX(CASE WHEN ml.memberId = :memberId THEN 1 ELSE 0 END), " + // 'AS' 키워드 제거 및 memberLike 추가
            "c.createdAt, c.updatedAt) " +
            "FROM Comment c " +
            "LEFT JOIN MemberLike ml ON ml.linkCode = c.commentId AND ml.linkCategory = 2 " +
            "WHERE c.linkId = :linkId AND c.linkCategory = :linkCategory " + // 매개변수로 받은 linkId와 linkCategory를 처리하는 부분 추가
            "GROUP BY c.commentId")
    List<CommentListResponse> findByLinkIdAndLinkCategory(long linkId, int linkCategory, long memberId);
}
