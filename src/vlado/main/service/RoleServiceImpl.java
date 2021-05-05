package vlado.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vlado.main.dao.RoleDAO;
import vlado.main.entity.Role;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDAO roleDAO;
	
	@Transactional
	@Override
	public List<Role> list() {
		
		return roleDAO.list();
	}

}
