package service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.SubjectVO;
import repository.CourseDAO;
import repository.CourseDAOImple;
import repository.ReviewDAO;
import repository.ReviewDAOImple;
import repository.SubjectDAO;
import repository.SubjectDAOImple;

public class SubjectServiceImple implements SubjectService {
	private static Logger log = LoggerFactory.getLogger(SubjectServiceImple.class);
	private SubjectDAO sdao;
	private ReviewDAO rdao;
	private CourseDAO csdao;
	
	public SubjectServiceImple() {
		sdao = new SubjectDAOImple();
		rdao = new ReviewDAOImple();
		csdao = new CourseDAOImple();
	}

	@Override
	public int register(SubjectVO svo) {
		return sdao.insert(svo);
	}

	@Override
	public List<SubjectVO> getList() {
		return sdao.selectList();
	}

	@Override
	public SubjectVO getDetail(long sno) {
		return sdao.selectOne(sno);
	}

	@Override
	public int modify(SubjectVO svo) {
		return sdao.update(svo);
	}

	@Override
	public int remove(long sno) {
		int isUp = sdao.delete(sno);
		if (isUp > 0) {
			isUp = rdao.deleteAll(sno);
		}
		if (isUp > 0) {
			isUp = csdao.deleteAll(sno);
		}
		return isUp;
	}

	@Override
	public int pAttends(SubjectVO svo) {
		return sdao.plusAttends(svo);
	}

	@Override
	public int mAttends(SubjectVO svo) {
		return sdao.minusAttends(svo);
	}

	@Override
	public List<SubjectVO> getList(long sno) {
		return sdao.selectList(sno);
	}

}
