package com.dataJpa.Task;

import com.dataJpa.Task.Dto.UserDto;
import com.dataJpa.Task.Entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TaskApplication {
	@Bean
	public ModelMapper modelMapper(){
//		ModelMapper modelMapper = new ModelMapper();
//		modelMapper.createTypeMap(UserDto.class, User.class)
//				.addMapping(UserDto::getId,User::setId);
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(TaskApplication.class, args);
	}

}
