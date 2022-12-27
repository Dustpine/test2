package kr.co.mindoll.board.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.co.mindoll.board.vo.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO{
	
	@Autowired
	JdbcTemplate jdbcTemplate; //고정
	 
	RowMapper<BoardVO> rowMapper = (rs, rowNum)-> {
			BoardVO vo = new BoardVO();
			vo.setBoardContent(rs.getString("boardContent"));
			vo.setBoardNum(rs.getLong("boardNum"));
			vo.setBoardPwd(rs.getString("boardPwd"));
			vo.setBoardTitle(rs.getString("boardTitle"));
			vo.setIrum(rs.getString("irum"));
			vo.setResidate(rs.getString("residate"));
			
			
			return vo;
		};
	
	
	@Override
	public int addBoard(BoardVO sampleData) {

		// TODO Auto-generated method stub
		return jdbcTemplate.update("insert into board values (board_seq.nextval, ?, ?, ?, ?, sysdate)",
				sampleData.getBoardTitle(),
				sampleData.getIrum(),
				sampleData.getBoardPwd(),
				sampleData.getBoardContent()
				);
	}
	
	@Override
	public int delBoard(int boardNum) {
		System.out.println(boardNum + "======================");
		return jdbcTemplate.update( "   delete from board where boardNum =  ? ", boardNum );
				 
	}

	@Override
	public BoardVO getBoard(long i) {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject(
				"select * from board where boardNum = ?", 
				new Object[] {i}, 
				rowMapper
				);
	
	
	}
		
	@Override
	public List<BoardVO>  getBoardList() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select * from board", rowMapper);
	}

	@Override //시퀀스의 현재 값을 반환하는 메소드 자료처리와 무관. 테스트목적
	public Long getCurrentNum() {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject("select board_seq.currval from dual", Long.class) ;
	}
}
