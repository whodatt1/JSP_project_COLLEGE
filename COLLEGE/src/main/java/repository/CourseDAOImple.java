package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.CourseVO;
import orm.DataBaseBuilder;

public class CourseDAOImple implements CourseDAO {
	private static Logger log = LoggerFactory.getLogger(CourseDAOImple.class);
	private SqlSession sql;
	private String ns = "CourseMapper.";
	private int isUp;
	
	public CourseDAOImple() {
		new DataBaseBuilder();
		sql = DataBaseBuilder.getFactory().openSession();
	}
	
	@Override
	public int insert(CourseVO csvo) {
		isUp = sql.insert(ns+"reg", csvo);
		if (isUp > 0) {
			sql.commit();
		}
		return isUp;
	}

	@Override
	public List<CourseVO> selectListStu(String email) {
		return sql.selectList(ns+"listStu", email);
	}
	@Override
	public List<CourseVO> selectListPro(String professorId) {
		return sql.selectList(ns+"listPro", professorId);
	}

	@Override
	public int delete(long csno) {
		isUp = sql.delete(ns+"del", csno);
		if (isUp > 0) {
			sql.commit();
		}
		return isUp;
	}

	@Override
	public CourseVO selectOne(CourseVO csvo) {
		return sql.selectOne(ns+"detail", csvo);
	}

	@Override
	public int deleteAll(long sno) {
		isUp = sql.delete(ns+"delAll", sno);
		if (isUp > 0) {
			sql.commit();
		}
		return isUp;
	}




}
