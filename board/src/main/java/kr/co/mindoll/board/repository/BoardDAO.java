package kr.co.mindoll.board.repository;

import java.util.List;

import kr.co.mindoll.board.vo.BoardVO;

public interface BoardDAO {

	int addBoard(BoardVO sampleData);

	int delBoard(int boardNum);

	BoardVO getBoard(long i);

	List<BoardVO> getBoardList();

	Long getCurrentNum();

}
