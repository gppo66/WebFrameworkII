package kr.ac.hansung.cse.model;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {
	
	private long id;
	private String name;
	private int age;
	private double salary;
	
}
