package service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.ReplyVO;
import repository.ReplyDAO;
import repository.ReplyDAOImple;

public class ReplyServiceImple implements ReplyService {
	private static Logger log = LoggerFactory.getLogger(ReplyServiceImple.class);
	private ReplyDAO rpdao;
	
	public ReplyServiceImple() {
		rpdao = new ReplyDAOImple();
	}

	@Override
	public int register(ReplyVO rpvo) {
		return rpdao.insert(rpvo);
	}

	@Override
	public List<ReplyVO> getList(long cno) {
		return rpdao.selectList(cno);
	}

	@Override
	public int modify(ReplyVO rpvo) {
		return rpdao.update(rpvo);
	}

	@Override
	public int remove(long rpno) {
		return rpdao.delete(rpno);
	}

}
