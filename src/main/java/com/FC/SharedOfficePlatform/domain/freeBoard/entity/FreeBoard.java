package com.FC.SharedOfficePlatform.domain.freeBoard.entity;

import com.FC.SharedOfficePlatform.global.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "free_board")
@NoArgsConstructor
@Getter
public class FreeBoard extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id", nullable = false)
    private Long boardId;

    @Column(name = "member_id", nullable = false)
    private long memberId;

    @Column(name = "office_id", nullable = false)
    private long officeId;

    @Column(name = "board_title", length = 50)
    private String boardTitle;

    @Column(name = "board_contents", length = 500)
    private String boardContents;


    @Builder
    public FreeBoard(
            long memberId,
            long officeId,
            String boardTitle,
            String boardContents
    ) {
        this.memberId = memberId;
        this.officeId = officeId;
        this.boardTitle = boardTitle;
        this.boardContents = boardContents;
    }

}
