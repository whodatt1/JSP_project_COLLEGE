package service;

import java.util.List;

import domain.CourseVO;

public interface CourseService {
	public int register(CourseVO csvo);
	public List<CourseVO> getListStu(String email);
	public List<CourseVO> getListPro(String professorId);
	public int remove(long csno);
	public CourseVO getDetail(CourseVO csvo);
}
