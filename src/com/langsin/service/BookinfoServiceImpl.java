package com.langsin.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.langsin.mapper.BookinfoMapper;
import com.langsin.mapper.UserMapper;
import com.langsin.pojo.Bookinfo;
import com.langsin.pojo.EasyUIDataGridResult;
import com.langsin.pojo.User;

@Service("bookinfoService")
public class BookinfoServiceImpl implements BookinfoService {

	@Autowired
	private BookinfoMapper bookinfoMapper = null;

	@Override
	public Bookinfo queryBookinfo() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertBookinfo(Bookinfo bookinfo) throws Exception {
		// TODO Auto-generated method stub

	}
	
	@Override
	public EasyUIDataGridResult queryBookinfoList(int page, int rows) throws Exception {
		//��ҳ����
		PageHelper.startPage(page, rows);
		//ִ�в�ѯ
		List<Bookinfo> list = bookinfoMapper.queryListBookinfo();

		//ȡ��ҳ��Ϣ
		PageInfo<Bookinfo> pageInfo = new PageInfo<>(list);
		//���ش�����
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setTotal(pageInfo.getTotal());
		result.setRows(list);
		
		return result;
	}

}
