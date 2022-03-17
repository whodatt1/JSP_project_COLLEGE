package repository;

import java.util.List;

import domain.CourseVO;

public interface CourseDAO {
	public int insert(CourseVO csvo);
	public List<CourseVO> selectListStu(String email);
	public List<CourseVO> selectListPro(String professorId);
	public int delete(long csno);
	public int deleteAll(long sno);
	public CourseVO selectOne(CourseVO csvo);
	
}
