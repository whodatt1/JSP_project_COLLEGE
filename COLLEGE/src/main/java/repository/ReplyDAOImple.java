package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.ReplyVO;
import orm.DataBaseBuilder;

public class ReplyDAOImple implements ReplyDAO {
	private static Logger log = LoggerFactory.getLogger(ReplyDAOImple.class);
	private SqlSession sql;
	private String ns = "ReplyMapper.";
	private int isUp;
	
	public ReplyDAOImple() {
		new DataBaseBuilder();
		sql = DataBaseBuilder.getFactory().openSession();
	}
	
	@Override
	public int insert(ReplyVO rpvo) {
		isUp = sql.insert(ns+"reg", rpvo);
		if (isUp > 0) {
			sql.commit();
		}
		return isUp;
	}

	@Override
	public List<ReplyVO> selectList(long cno) {
		return sql.selectList(ns+"list", cno);
	}

	@Override
	public int update(ReplyVO rpvo) {
		isUp = sql.update(ns+"mod", rpvo);
		if (isUp > 0) {
			sql.commit();
		}
		return isUp;
	}

	@Override
	public int delete(long rpno) {
		isUp = sql.delete(ns+"del", rpno);
		if (isUp > 0) {
			sql.commit();
		}
		return 0;
	}

	@Override
	public int deleteAll(long rpno) {
		isUp = sql.delete(ns+"delAll", rpno);
		if (isUp > 0) {
			sql.commit();
		}
		return isUp;
	}

}
