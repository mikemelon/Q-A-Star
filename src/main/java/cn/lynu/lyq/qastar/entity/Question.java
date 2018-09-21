package cn.lynu.lyq.qastar.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Question implements Serializable{
	private static final long serialVersionUID = -9193368612504634143L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String title;
	
	private String content;
	
	private Date updateTime;
	
//	@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })   for @ManyToOne with fetch=FetchType.LAZY
	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name="u_id")
	private User user;
}
