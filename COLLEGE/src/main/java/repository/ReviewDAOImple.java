package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.ReviewVO;
import orm.DataBaseBuilder;

public class ReviewDAOImple implements ReviewDAO {
	private static Logger log = LoggerFactory.getLogger(ReviewDAOImple.class);
	private SqlSession sql;
	private String ns = "ReviewMapper.";
	private int isUp;
	
	public ReviewDAOImple() {
		new DataBaseBuilder();
		sql = DataBaseBuilder.getFactory().openSession();
	}
	
	@Override
	public int insert(ReviewVO rvvo) {
		isUp = sql.insert(ns+"reg", rvvo);
		if (isUp > 0) {
			sql.commit();
		}
		return isUp;
	}

	@Override
	public List<ReviewVO> selectList(long sno) {
		return sql.selectList(ns+"list", sno);
	}

	@Override
	public int update(ReviewVO rvvo) {
		isUp = sql.update(ns+"mod", rvvo);
		if (isUp > 0) {
			sql.commit();
		}
		return isUp;
	}

	@Override
	public int delete(long rvno) {
		isUp = sql.delete(ns+"del", rvno);
		if (isUp > 0) {
			sql.commit();
		}
		return 0;
	}

	@Override
	public int deleteAll(long rvno) {
		isUp = sql.delete(ns+"delAll", rvno);
		if (isUp > 0) {
			sql.commit();
		}
		return isUp;
	}

}
