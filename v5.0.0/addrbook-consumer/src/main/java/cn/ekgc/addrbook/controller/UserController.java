package cn.ekgc.addrbook.controller;

import cn.ekgc.addrbook.controller.base.BaseController;
import cn.ekgc.addrbook.pojo.entity.User;
import cn.ekgc.addrbook.pojo.vo.PageVO;
import cn.ekgc.addrbook.transport.UserTransport;
import cn.ekgc.addrbook.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <b>用户功能控制层类</b>
 * @author Arthur
 * @version 5.0.0
 */
@RestController("userController")
@RequestMapping("/user")
public class UserController extends BaseController {
	@Autowired
	private UserTransport userTransport;

	/**
	 * <b>根据查询对象查询列表</b>
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/list")
	public List<User> queryListByQuery(User user) throws Exception {
		return userTransport.getListByQuery(user);
	}

	/**
	 * <b>保存用户信息</b>
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/save")
	public boolean saveUser(User user) throws Exception {
		return userTransport.saveUser(user);
	}

	/**
	 * <b>用户登录</b>
	 * @param cellphone
	 * @param password
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/login")
	public boolean loginUser(String cellphone, String password) throws Exception {
		// 封装查询对象
		User user = new User();
		user.setCellphone(cellphone);
		user.setPassword(MD5Util.encrypt(password));
		List<User> list = userTransport.getListByQuery(user);
		if (list != null && !list.isEmpty()) {
			return true;
		}
		return false;
	}

	/**
	 * <b>分页查询用户信息列表</b>
	 * @param pageNum
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/page/{pageNum}/{pageSize}")
	public PageVO<User> queryByPage(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize)
			throws Exception {
		PageVO<User> pageVO = new PageVO<User>(pageNum, pageSize);
		return userTransport.getPage(pageVO);
	}

	/**
	 * <b>根据主键查询对象</b>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/{id}")
	public User queryById(@PathVariable("id") Long id) throws Exception {
		return userTransport.getById(id);
	}

	/**
	 * <b>修改用户信息</b>
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/update")
	public boolean updateUser(User user) throws Exception {
		return userTransport.updateUser(user);
	}

	@GetMapping("/delete/{id}")
	public boolean deleteById(@PathVariable("id") Long id) throws Exception {
		return userTransport.deleteById(id);
	}
}
