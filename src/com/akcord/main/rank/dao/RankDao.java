package com.akcord.main.rank.dao;

import java.util.List;

import com.akcord.main.rank.model.RankDto;

public interface RankDao {
	
	List<RankDto> getQna();	// 
	List<RankDto> getQnaComment();	// 
	
	List<RankDto> getGroup();	//
	String getGroupname(String id);	// �׷��̸� ���ؿ���
	List<RankDto> getMyroom();	//

}
