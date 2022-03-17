package repository;

import java.util.List;

import domain.ReplyVO;

public interface ReplyDAO {
	public int insert(ReplyVO rpvo);
	public List<ReplyVO> selectList(long cno);
	public int update(ReplyVO rpvo);
	public int delete(long rpno);
	public int deleteAll(long rpno);
}
