package com.graduationdesign.service.impl;

import java.util.List;

import com.graduationdesign.dao.ISelectCommentsDao;
import com.graduationdesign.entity.ShopOrder;
import com.graduationdesign.service.ISelectCommentsService;

public class SelectCommentsServiceImpl implements ISelectCommentsService {
	/**
	 * 注入
	 */
	private ISelectCommentsDao selectCommentsDao;

	public ISelectCommentsDao getSelectCommentsDao() {
		return selectCommentsDao;
	}

	public void setSelectCommentsDao(ISelectCommentsDao selectCommentsDao) {
		this.selectCommentsDao = selectCommentsDao;
	}

	@Override
	public List<ShopOrder> getAllComments(Integer id) {
		return selectCommentsDao.getAllComments(id);
	}

	@Override
	public List<ShopOrder> getGoodComments(Integer id) {
		return selectCommentsDao.getGoodComments(id);
	}

	@Override
	public List<ShopOrder> getMiddleComments(Integer id) {
		return selectCommentsDao.getMiddleComments(id);
	}

	@Override
	public List<ShopOrder> getLowComments(Integer id) {
		return selectCommentsDao.getLowComments(id);
	}

	@Override
	public List<ShopOrder> getCommentsList(Integer userid) {
		return selectCommentsDao.getCommentsList(userid);
	}

}
