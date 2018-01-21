package lyons.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import lyons.db.DbAccess;
import lyons.user.entity.User;

/**
 * vip用户维护类
 * <p>
 * orderForm.sql
 */
public class UserDaoImpl implements UserDao {
    static SqlSession sqlSession;
    static DbAccess dbAccess = new DbAccess();

    /**
     * 根据用户名查询用户信息
     *
     * @param map
     * @return
     */
    @Override
    public List<User> queryByuserNamepassWord(Map<String, Object> map) {
        try {
            sqlSession = dbAccess.getSqlSession();
            return sqlSession.getMapper(UserDao.class).queryByuserNamepassWord(map);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sqlSessionClose();
        }

        return new ArrayList<>();
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
        } catch (IOException e) {
            e.printStackTrace();
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
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
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
