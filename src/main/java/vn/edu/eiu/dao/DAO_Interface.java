package vn.edu.eiu.dao;

import java.util.ArrayList;

//Đọc lại khái niệm về Generic
public interface DAO_Interface<T> {
	
	public int insert (T t);
	
	public int update(T t);
	
	public int delete(T t);
	
	public ArrayList<T> selectAll();
	
	public T selectById(T t);
	
	public ArrayList<T> selectByCondition(String condition);
}
