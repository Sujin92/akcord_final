package com.akcord.main.poll.dao;

import java.util.List;
import java.util.Map;

import com.akcord.main.poll.model.PollDto;

public interface PollDao {
	
	public int getNextPollSeq();
	
	// << task for poll for admin >>
	public int pollmake(PollDto pollDto);	// insert poll data into database
	public int pollmakeContent(String Content);	// insert poll data into database
	
	public List<PollDto> polllist(Map<String,String> query);	// pull list of polls
	public PollDto pollmodify(int poll_id); // modify poll data
	public int pollmodifydate(Map<String,String> map); // modify poll data
	public List<String> pollgetContent(int poll_id); // modify poll data
	public int pollclose(int poll_id);  // close poll
	public List<PollDto> pollresult(int poll_id);
	public List<PollDto> mainpollget();
	// << poll function for users >>
	public void pollshow();	// shows poll form for users
	public void pollvote();	// insert user's choice data
	public void pollchart();// shows chart of poll result;
	public List<PollDto> removeBtn();
	public void pollavailable();	// check availability for vote 
	public void pollupdate(Map<String,String> query);
	public void pollYN(Map<String,String> query);
}
