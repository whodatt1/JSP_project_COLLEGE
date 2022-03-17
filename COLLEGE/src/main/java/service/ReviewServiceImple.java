package service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.ReviewVO;
import repository.ReviewDAO;
import repository.ReviewDAOImple;

public class ReviewServiceImple implements ReviewService {
	private static Logger log = LoggerFactory.getLogger(ReviewServiceImple.class);
	private ReviewDAO rvdao;
	
	public ReviewServiceImple() {
		rvdao = new ReviewDAOImple();
	}

	@Override
	public int register(ReviewVO rvvo) {
		return rvdao.insert(rvvo);
	}

	@Override
	public List<ReviewVO> getList(long sno) {
		return rvdao.selectList(sno);
	}

	@Override
	public int modify(ReviewVO rvvo) {
		return rvdao.update(rvvo);
	}

	@Override
	public int remove(long rvno) {
		return rvdao.delete(rvno);
	}
	
	

}
