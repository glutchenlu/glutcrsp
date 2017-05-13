import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import com.xnzygxpt.xuser.dao.vo.XUser;

public class TestMain {

	public static void main(String[] args) {
		XUser xuser = new XUser();
		try {
			// BeanUtils.setProperty(xuser, "userid", "admin");
			// BeanUtils.setProperty(xuser, "password", "111111");
			xuser.setUserid("admin1");
			xuser.setPassword("2222");
			System.out.println("userid:"
					+ BeanUtils.getProperty(xuser, "userid"));
			System.out.println("password:"
					+ BeanUtils.getProperty(xuser, "password"));
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
	}

}
