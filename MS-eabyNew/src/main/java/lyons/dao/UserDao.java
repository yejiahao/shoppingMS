package lyons.dao;

import lyons.user.entity.User;

import java.util.List;
import java.util.Map;

/**
 * user.xml 对应的接口
 *
 * @author lyons(zhanglei)
 */
public interface UserDao {
    /**
     * 根据用户名查询信息
     **/
    List<User> findUser(Map<String, String> map);

    /**
     * 注册新用户
     **/
    void insertUser(Map<String, String> registerMap);

    /**
     * 验证用户是否存在
     **/
    List<User> queryByuserName(String username);
}
