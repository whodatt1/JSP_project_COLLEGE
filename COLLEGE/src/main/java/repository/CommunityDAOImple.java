package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.CommunityVO;
import orm.DataBaseBuilder;

public class CommunityDAOImple implements CommunityDAO {
	private static Logger log = LoggerFactory.getLogger(CommunityDAOImple.class);
	private SqlSession sql;
	private String ns = "CommunityMapper.";
	private int isUp;
	
	public CommunityDAOImple() {
		new DataBaseBuilder();
		sql = DataBaseBuilder.getFactory().openSession();
	}

	@Override
	public int insert(CommunityVO cvo) {
		isUp = sql.insert(ns+"reg", cvo);
		if (isUp > 0) {
			sql.commit();
		}
		return isUp;
	}

	@Override
	public List<CommunityVO> selectList() {
		return sql.selectList(ns+"list");
	}

	@Override
	public CommunityVO selectOne(long cno) {
		return sql.selectOne(ns+"detail", cno);
	}

	@Override
	public int update(CommunityVO cvo) {
		isUp = sql.update(ns+"mod", cvo);
		if (isUp > 0) {
			sql.commit();
		}
		return isUp;
	}

	@Override
	public int delete(long cno) {
		isUp = sql.delete(ns+"del", cno);
		if (isUp > 0) {
			sql.commit();
		}
		return isUp;
	}

	@Override
	public int updateRC(long cno) {
		isUp = sql.update(ns+"rc", cno);
		if (isUp > 0) {
			sql.commit();
		}
		return isUp;
	}

}
