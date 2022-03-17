package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.UserVO;
import orm.DataBaseBuilder;

public class UserDAOImple implements UserDAO {
	private static Logger log = LoggerFactory.getLogger(UserDAOImple.class);
	private SqlSession sql;
	private String ns = "UserMapper.";
	private int isUp;
	
	public UserDAOImple() {
		new DataBaseBuilder();
		sql = DataBaseBuilder.getFactory().openSession();
	}

	@Override
	public int insert(UserVO uvo) {
		isUp = sql.insert(ns+"reg", uvo);
		if (isUp > 0) {
			sql.commit();
		}
		return isUp;
	}

	@Override
	public List<UserVO> selectList() {
		return sql.selectList(ns+"list");
	}

	@Override
	public UserVO selectOne(String email) {
		return sql.selectOne(ns+"detail", email);
	}

	@Override
	public int update(UserVO uvo) {
		isUp = sql.update(ns+"mod", uvo);
		if (isUp > 0) {
			sql.commit();
		}
		return isUp;
	}
	@Override
	public int update2(UserVO uvo) {
		isUp = sql.update(ns+"mod2", uvo);
		if (isUp > 0) {
			sql.commit();
		}
		return isUp;
	}

	@Override
	public int delete(String email) {
		isUp = sql.delete(ns+"del", email);
		if (isUp > 0) {
			sql.commit();
		}
		return isUp;
	}

	@Override
	public UserVO selectOne(UserVO uvo) {
		return sql.selectOne(ns+"login", uvo);
	}

	@Override
	public int update(String email) {
		isUp = sql.update(ns+"lastLogin", email);
		if (isUp > 0) {
			sql.commit();
		}
		return isUp;
	}

	@Override
	public List<String> selectEmailList() {
		return sql.selectList(ns+"listEmail");
	}

	@Override
	public String selectMatchPwd(String email) {
		return sql.selectOne(ns+"mathPwd", email);
	}
	
}
