package kr.co.mindoll.board.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class BoardVO {
    private long boardNum; // 필수입력이긴 하지만 사용자가 입력하는 것이 아니므로 nonnull 어노테이션 삽입 x =>dbms의 시퀀스가 입력
	@NonNull
    private String boardTitle;
	@NonNull
    private String irum;
	@NonNull
    private String boardPwd;
    private String boardContent;
    private String residate;

}
