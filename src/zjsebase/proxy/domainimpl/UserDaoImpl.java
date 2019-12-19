package zjsebase.proxy.domainimpl;

import zjsebase.proxy.domain.UserDao;

public class UserDaoImpl implements UserDao {

	@Override
	public void insert() {
		System.out.println("添加方法...");
	}

	@Override
	public void delete() {
		System.out.println("删除方法...");
	}

	@Override
	public void update() {
		System.out.println("修改方法...");
	}

	@Override
	public void select() {
		System.out.println("查询方法...");
	}
}
