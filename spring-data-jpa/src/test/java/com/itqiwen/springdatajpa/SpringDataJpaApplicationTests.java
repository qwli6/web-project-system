package com.itqiwen.springdatajpa;

import com.itqiwen.springdatajpa.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringDataJpaApplicationTests {

	/**
	 * CrudRepository 提供了一些简单的方法，
	 * 例如常见的CRUD 以及对 实体类的一些批量操作
	 */

	@Resource
	private UserRepository userRepository;

	@Test
	public void contextLoads() {
		Iterable<User> users = userRepository.findAll();
		for (User user : users) {
			System.out.println(user);
		}
	}

	@Test
	public void saveUser(){
		User user = new User();
		user.setName("凤凰于飞");
		user.setSex("女");
		user.setAddress("王昭君");
		userRepository.save(user);
	}

	/**
	 * 批量保存用户
	 */
	@Test
	public void saveUser2(){
		User user = new User();
		user.setName("凤求凰1");
		user.setSex("男1");
		user.setAddress("李白1");
		User user2 = new User();
		user2.setName("凤求凰");
		user2.setSex("男");
		user2.setAddress("李白");
		List<User> list = new ArrayList<>();
		list.add(user);
		list.add(user2);
		userRepository.save(list);
	}

	/**
	 * 批量查询用户
	 */
	@Test
	public void findUserList(){

		List<Long> idList = new ArrayList<>();

		idList.add(18L);
		idList.add(17L);
		idList.add(16L);
		List<User> all = (List<User>) userRepository.findAll(idList);
		for (User user : all) {
			System.out.println(user);
		}
	}

	/**
	 * 查询单个用户
	 */
	@Test
	public void findUserById(){
		User one = userRepository.findOne(18L);
		System.out.println(one);
	}

	/**
	 * 自定义的查询方法
	 */
	@Test
	public void findAll(){
		List<User> userList = userRepository.findAll();
		for (User user : userList) {
			System.out.println(user);

		}
	}


	/**
	 * 根据用户名查找用户
	 */
	@Test
	public void findUserByName(){
		User user = userRepository.findUserByName3("凤凰于飞");
		System.out.println(user);
	}




	/**
	 * 分页方法
	 */
	@Test
	public void findUserByPage(){
		Page<User> all = userRepository.findAll(new PageRequest(1, 6));
		List<User> content = all.getContent();
		for (User user :
				content) {
			System.out.println(user);
		}
	}

	/**
	 * 模糊查询
	 * 默认提供的
	 */
	@Test
	public void findUserByName3(){
		List<User> userList = userRepository.findUserByNameLike("%凰%");
		for (User user :
				userList) {
			System.out.println(user);
		}
	}


	/**
	 * 修改
	 */
	@Test
	public void updateUser(){
		userRepository.updateUser("李太白",18L);
	}


	/**
	 * 删除用户
	 */
	@Test
	public void deleteUser(){
		userRepository.deleteUser(18L);
	}



}
