package cn.lynu.lyq.qastar.service;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import cn.lynu.lyq.qastar.dao.QuestionRepository;
import cn.lynu.lyq.qastar.entity.Question;
import lombok.extern.slf4j.Slf4j;

@Transactional
@Service
@Slf4j
public class QuestionService {
	@Resource
	private QuestionRepository questionDao;
	
	public Question findById(Integer id){
		Optional<Question> questionById = questionDao.findById(id);
		if (questionById.isPresent()) {
	        return questionById.get();
	    } else {
	    	log.error("findById:查询问题(Question)无效：id={}",id);
	        return null;
	    }
	}
	
	public List<Question> findAll(){
		return questionDao.findAll();
	}	
	
	public void save(Question question){
		questionDao.save(question);
	}
	
	public void update(Question question){
		questionDao.save(question);
	}
	
	public void deleteById(Integer id){
		questionDao.deleteById(id);
	}
	
}
