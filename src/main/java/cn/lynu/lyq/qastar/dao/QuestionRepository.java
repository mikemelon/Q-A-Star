package cn.lynu.lyq.qastar.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.lynu.lyq.qastar.entity.Question;

public interface QuestionRepository extends JpaRepository<Question,Integer>{
}
