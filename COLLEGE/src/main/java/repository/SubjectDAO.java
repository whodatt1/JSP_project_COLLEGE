package repository;

import java.util.List;

import domain.SubjectVO;

public interface SubjectDAO {
	public int insert(SubjectVO svo);
	public SubjectVO selectOne(long sno);
	public List<SubjectVO> selectList();
	public int update(SubjectVO svo);
	public int delete(long sno);
	public int plusAttends(SubjectVO svo);
	public int minusAttends(SubjectVO svo);
	public List<SubjectVO> selectList(long sno);
}
