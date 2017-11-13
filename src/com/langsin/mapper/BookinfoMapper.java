package com.langsin.mapper;

import java.util.List;
import java.util.Map;

import com.langsin.pojo.Bookinfo;
import com.langsin.pojo.User;

public interface BookinfoMapper {
	

	public List<Bookinfo> queryListBookinfo() throws Exception;
}
