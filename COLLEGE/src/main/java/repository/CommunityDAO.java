package repository;

import java.util.List;

import domain.CommunityVO;

public interface CommunityDAO {
	public int insert(CommunityVO cvo);
	public List<CommunityVO> selectList();
	public CommunityVO selectOne(long cno);
	public int update(CommunityVO cvo);
	public int delete(long cno);
	public int updateRC(long cno);
}
