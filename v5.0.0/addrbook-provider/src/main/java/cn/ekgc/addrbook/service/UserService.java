package cn.ekgc.addrbook.service;

import cn.ekgc.addrbook.pojo.entity.User;
import cn.ekgc.addrbook.pojo.vo.PageVO;

import java.util.List;

/**
 * <b>用户功能业务层接口</b>
 * @author Arthur
 * @version 5.0.0
 */
public interface UserService {
	/**
	 * <b>根据查询对象查询列表</b>
	 * @param query
	 * @return
	 * @throws Exception
	 */
	List<User> getListByQuery(User query) throws Exception;

	/**
	 * <b>分页查询</b>
	 * @param pageVO
	 * @return
	 * @throws Exception
	 */
	PageVO<User> getPage(PageVO<User> pageVO) throws Exception;

	/**
	 * <b>保存用户信息</b>
	 * @param user
	 * @return
	 * @throws Exception
	 */
	boolean saveUser(User user) throws Exception;

	/**
	 * <b>修改用户信息</b>
	 * @param user
	 * @return
	 * @throws Exception
	 */
	boolean updateUser(User user) throws Exception;

	/**
	 * <b>根据主键删除用户信息</b>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	boolean deleteById(Long id) throws Exception;

	/**
	 * <b>根据主键查询用户信息</b>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	User getById(Long id) throws Exception;
}
