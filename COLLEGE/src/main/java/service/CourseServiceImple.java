package service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.CourseVO;
import repository.CourseDAO;
import repository.CourseDAOImple;

public class CourseServiceImple implements CourseService {
	private static Logger log = LoggerFactory.getLogger(CourseServiceImple.class);
	private CourseDAO csdao;
	
	public CourseServiceImple() {
		csdao = new CourseDAOImple();
	}

	@Override
	public int register(CourseVO csvo) {
		return csdao.insert(csvo);
	}

	@Override
	public List<CourseVO> getListStu(String email) {
		return csdao.selectListStu(email);
	}
	
	@Override
	public List<CourseVO> getListPro(String professorId) {
		return csdao.selectListPro(professorId);
	}


	@Override
	public int remove(long csno) {
		return csdao.delete(csno);
	}

	@Override
	public CourseVO getDetail(CourseVO csvo) {
		return csdao.selectOne(csvo);
	}




}
