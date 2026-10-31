package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Sb5Q2Repository extends JpaRepository<Sb5Q2Entity, Integer> {
	
	// 投稿日時の降順に全レコードを取得
	public List<Sb5Q2Entity> findAllByOrderByDateDesc();

}
