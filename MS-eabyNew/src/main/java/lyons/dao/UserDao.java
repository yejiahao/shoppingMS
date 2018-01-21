package lyons.dao;

import lyons.user.entity.User;

import java.util.List;
import java.util.Map;

/**
 * user.xml ��Ӧ�Ľӿ�
 *
 * @author lyons(zhanglei)
 */
public interface UserDao {
    /**
     * �����û�����ѯ��Ϣ
     **/
    List<User> queryByuserNamepassWord(Map<String, Object> map);

    /**
     * ע�����û�
     **/
    void insertUser(Map<String, String> registerMap);

    /**
     * ��֤�û��Ƿ����
     **/
    List<User> queryByuserName(String username);
}
