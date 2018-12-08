import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import com.baizhi.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author zzu
 * @date 2018/12/1 - 20:45
 */
public class Test {
    public static void main(String[] args) {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtil.getSqlSession();
            System.out.println(sqlSession);
            UserDao mapper = sqlSession.getMapper(UserDao.class);
            User user = mapper.queryUser("哈喽", 23);
            System.out.println(user);
            /*List<User> list= mapper.queryList();
            System.out.println(list);*/
            /*User user = new User();
            user.setId(7);
            user.setName("哈哈");
            user.setAge(23);
            mapper.insertUser(user);*/


//            mapper.updateUser(user);
            sqlSession.commit();
            System.out.println("插入成功");
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
            System.out.println("插入失败");
        } finally {
            sqlSession.close();
        }
    }
}
