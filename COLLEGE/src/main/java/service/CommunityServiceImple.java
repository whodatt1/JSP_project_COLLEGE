package service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.CommunityVO;
import repository.CommunityDAO;
import repository.CommunityDAOImple;
import repository.ReplyDAO;
import repository.ReplyDAOImple;

public class CommunityServiceImple implements CommunityService {
	private static Logger log = LoggerFactory.getLogger(CommunityServiceImple.class);
	private CommunityDAO cdao;
	private ReplyDAO rpdao;
	
	public CommunityServiceImple() {
		cdao = new CommunityDAOImple();
		rpdao = new ReplyDAOImple();
	}

	@Override
	public int register(CommunityVO cvo) {
		return cdao.insert(cvo);
	}

	@Override
	public List<CommunityVO> getList() {
		return cdao.selectList();
	}

	@Override
	public CommunityVO getDetail(long cno) {
		CommunityVO cvo = cdao.selectOne(cno);
		int isUp = cdao.updateRC(cno);
		cvo.setReadCount(cvo.getReadCount() + isUp);
		return cvo;
	}

	@Override
	public int modify(CommunityVO cvo) {
		return cdao.update(cvo);
	}

	@Override
	public int remove(long cno) {
		int isUp = cdao.delete(cno);
		if (isUp > 0) {
			isUp = rpdao.deleteAll(cno);
		}
		return isUp;
	}

}
