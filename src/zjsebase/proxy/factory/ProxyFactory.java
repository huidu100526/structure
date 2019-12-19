package zjsebase.proxy.factory;

import zjsebase.proxy.advice.AfterAdvice;
import zjsebase.proxy.advice.BeforeAdvice;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyFactory {
	private Object target;// 代理对象
	private BeforeAdvice beforeAdvice;// 前置增强
	private AfterAdvice afterAdvice;// 后置增强

	/*
	 * 创建代理对象方法
	 */
	public Object createProxy() {
		// 三大参数
		ClassLoader loader = this.getClass().getClassLoader();
		Class[] interfaces = target.getClass().getInterfaces();
		InvocationHandler handler = (proxy, method, args) -> {
			// 执行前置增强
			if (beforeAdvice != null) {
				beforeAdvice.before();
			}

			// 执行目标对象的目标方法
			Object result = method.invoke(target, args);

			// 执行后置增强
			if (afterAdvice != null) {
				afterAdvice.after();
			}

			return result;
		};

		// 得到代理对象
		Object proxy = Proxy.newProxyInstance(loader, interfaces, handler);
		return proxy;
	}

	public void setTarget(Object target) {
		this.target = target;
	}

	public void setBeforeAdvice(BeforeAdvice beforeAdvice) {
		this.beforeAdvice = beforeAdvice;
	}

	public void setAfterAdvice(AfterAdvice afterAdvice) {
		this.afterAdvice = afterAdvice;
	}
}
