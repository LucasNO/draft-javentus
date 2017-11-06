package com.draft.javentus.service;

import com.draft.javentus.model.Usuario;

/**
 *
 * @author lucas
 */

public interface UserService {
	public Usuario findUserByEmail(String email);
	public void saveUser(Usuario user);
        public Usuario findOne(Integer id);
}
