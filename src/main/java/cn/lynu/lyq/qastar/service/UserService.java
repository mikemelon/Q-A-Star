package cn.lynu.lyq.qastar.service;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import cn.lynu.lyq.qastar.dao.UserRepository;
import cn.lynu.lyq.qastar.entity.User;
import lombok.extern.slf4j.Slf4j;

@Transactional
@Service
@Slf4j
public class UserService {
	@Resource
	private UserRepository userDao;
	
	public User findById(Integer id){
		Optional<User> userById = userDao.findById(id);
		if (userById.isPresent()) {
	        return userById.get();
	    } else {
	    	log.error("findById:查询用户(User)无效：id={}",id);
	        return null;
	    }
	}
	
	public List<User> findAll(){
		return userDao.findAll();
	}	
	
	public void save(User user){
		userDao.save(user);
	}
	
	public void update(User user){
		userDao.save(user);
	}
	
	public void deleteById(Integer id){
		userDao.deleteById(id);
	}
	
	public User login(User user) {
		List<User> userList = userDao.findByNameAndPassword(user.getName(),user.getPassword());
		log.debug("userList={}",userList);
		log.debug("userList.size()={}",userList.size());
		if(userList.size()==1) 	
			return userList.get(0);  
		else
			return null;
	}
}
