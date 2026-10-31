package com.example.demo;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Sb5Q2Entity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Integer bbsId; // BBS ID
	
	// 投稿日時
	@Column(nullable = false)
	// 登録したときの日時を投稿日時とする
	private LocalDateTime date = LocalDateTime.now();
	
	@Column(length = 30,nullable = false)
	private String name; // 投稿者
	
	@Column(length = 400,nullable = true)
	private String message;  // メッセージ
	
	
    private String[] work;	//
	
    @Column(nullable = true)
	private String workString;
    
    private List<String> work2;	//
	
	
	
}
