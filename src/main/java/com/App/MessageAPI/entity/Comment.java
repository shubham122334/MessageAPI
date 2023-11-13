package com.App.MessageAPI.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
 	
	private String message;

	private String commentDate;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "posted_by_user_id")
	private Users users;

	public Comment() {}


}
