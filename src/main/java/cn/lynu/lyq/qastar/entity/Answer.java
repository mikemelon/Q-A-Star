package cn.lynu.lyq.qastar.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Answer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String content;
	
	private Date updateTime;
	
	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name="u_id")
	private User user;
	
	
	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name="q_id")
	private Question question;
}
