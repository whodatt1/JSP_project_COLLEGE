package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.SubjectVO;
import orm.DataBaseBuilder;

public class SubjectDAOImple implements SubjectDAO {
	private static Logger log = LoggerFactory.getLogger(SubjectDAOImple.class);
	private SqlSession sql;
	private String ns = "SubjectMapper.";
	private int isUp;
	
	public SubjectDAOImple() {
		new DataBaseBuilder();
		sql = DataBaseBuilder.getFactory().openSession();
	}

	@Override
	public int insert(SubjectVO svo) {
		isUp = sql.insert(ns+"reg", svo);
		if (isUp > 0) {
			sql.commit();
		}
		return isUp;
	}

	@Override
	public List<SubjectVO> selectList() {
		return sql.selectList(ns+"list");
	}

	@Override
	public SubjectVO selectOne(long sno) {
		return sql.selectOne(ns+"detail", sno);
	}

	@Override
	public int update(SubjectVO svo) {
		isUp = sql.update(ns+"mod", svo);
		if (isUp > 0) {
			sql.commit();
		}
		return isUp;
	}

	@Override
	public int delete(long sno) {
		isUp = sql.delete(ns+"del", sno);
		if (isUp > 0) {
			sql.commit();
		}
		return isUp;
	}

	@Override
	public int plusAttends(SubjectVO svo) {
		isUp = sql.update(ns+"pAt", svo);
		if (isUp > 0) {
			sql.commit();
		}
		return isUp;
	}
	
	@Override
	public int minusAttends(SubjectVO svo) {
		isUp = sql.update(ns+"mAt", svo);
		if (isUp > 0) {
			sql.commit();
		}
		return isUp;
	}

	@Override
	public List<SubjectVO> selectList(long sno) {
		return sql.selectList(ns+"listCs", sno);
	}
	
	
}
