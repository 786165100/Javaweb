package com.langsin.service;

import java.util.List;

import com.langsin.pojo.Bookinfo;
import com.langsin.pojo.EasyUIDataGridResult;

public interface BookinfoService {
	public Bookinfo queryBookinfo() throws Exception;
	
	public void insertBookinfo(Bookinfo bookinfo) throws Exception;
	
//	public List<Bookinfo> queryBookinfoList(Integer page, Integer rows) throws Exception;

	public EasyUIDataGridResult queryBookinfoList(int page, int rows) throws Exception;
}
