package lyons.dao;

import lyons.db.DbAccess;
import lyons.user.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * vip用户维护类
 * <p>
 */
public class UserDaoImpl implements UserDao {
    private static final Logger LOG = LoggerFactory.getLogger(UserDaoImpl.class);

    static SqlSession sqlSession;
    static DbAccess dbAccess = new DbAccess();

    /**
     * 根据用户名查询用户信息
     *
     * @param map
     * @return
     */
    @Override
    public List<User> findUser(Map<String, String> map) {
        try {
            sqlSession = dbAccess.getSqlSession();
            return sqlSession.getMapper(UserDao.class).findUser(map);
        } catch (Exception e) {
            LOG.error("queryByUsernamePassword: " + e.getMessage(), e);
        } finally {
            sqlSessionClose();
        }
        return null;
    }

    /**
     * 用户是否存在
     *
     * @param username
     */
    public List<User> queryByuserName(String username) {
        try {
            sqlSession = dbAccess.getSqlSession();
            return sqlSession.getMapper(UserDao.class).queryByuserName(username);
        } catch (Exception e) {
            LOG.error("queryByUsername: " + e.getMessage(), e);
        } finally {
            sqlSessionClose();
        }
        return new ArrayList<>();
    }

    /**
     * 新用户注册
     *
     * @param registerMap
     * @return
     */
    public void insertUser(Map<String, String> registerMap) {
        try {
            sqlSession = dbAccess.getSqlSession();
            sqlSession.getMapper(UserDao.class).insertUser(registerMap);
            sqlSession.commit();
        } catch (Exception e) {
            LOG.error("insertUser: " + e.getMessage(), e);
        } finally {
            sqlSessionClose();
        }
    }

    /*
     * 关闭数据库连接会话
     */
    private static void sqlSessionClose() {
        if (sqlSession != null) {
            sqlSession.close();
        }
    }

}
