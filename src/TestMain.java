import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
		String nowTime = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date now = new Date();
		nowTime = sdf.format(now);
		System.out.println(nowTime);
	}

}
