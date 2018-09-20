package cn.lynu.lyq.qastar.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.lynu.lyq.qastar.entity.User;

public interface UserRepository extends JpaRepository<User,Integer>{
	List<User> findByNameAndPassword(String name, String password);
}
