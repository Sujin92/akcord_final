package com.akcord.in.service;

import java.util.List;

import com.akcord.in.model.InDto;

public interface InService {
	public int inroom(InDto inDto);
	public List<InDto> inlist(); 
}
