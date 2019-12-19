package zjsebase.proxy.main;

import zjsebase.proxy.domain.UserDao;
import zjsebase.proxy.domainimpl.UserDaoImpl;
import zjsebase.proxy.factory.ProxyFactory;

public class MainDemo {
	public static void main(String[] args) {
		// 创建工厂对象
		ProxyFactory factory = new ProxyFactory();
		// 设置代理对象
		factory.setTarget(new UserDaoImpl());
		// 设置前置增强
		factory.setBeforeAdvice(() -> System.out.println("这里是前置增强"));
		// 设置后置增强
		factory.setAfterAdvice(() -> System.out.println("这里是后置增强"));
		// 创建代理对象
		UserDao user = (UserDao) factory.createProxy();
		user.insert();
		user.delete();
		user.update();
		user.select();
	}
}
