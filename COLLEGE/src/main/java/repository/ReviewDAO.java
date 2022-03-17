package repository;

import java.util.List;

import domain.ReviewVO;

public interface ReviewDAO {
	public int insert(ReviewVO rvvo);
	public List<ReviewVO> selectList(long sno);
	public int update(ReviewVO rvvo);
	public int delete(long rvno);
	public int deleteAll(long rvno);
}
