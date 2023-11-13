package com.App.MessageAPI.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Entity
@Data
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;


	@NotBlank(message = "commentFrom(name) is mandatory")
	@Pattern(regexp = "^(\\w+){1,999}",message = "special character not allowed")
	private String commentFrom;


	@NotBlank(message = "commentTo(name) is mandatory")
	@Pattern(regexp = "^(\\w+){1,999}",message = "special character not allowed")
	private String commentTo;
	
	@OneToMany(mappedBy = "users")
	private List<Comment>   comment=new ArrayList<>();



}
