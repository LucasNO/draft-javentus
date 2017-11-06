package com.draft.javentus.service;

import com.draft.javentus.model.Role;
import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.draft.javentus.model.Usuario;
import com.draft.javentus.repository.RoleRepository;
import com.draft.javentus.repository.UserRepository;

/**
 *
 * @author lucas
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Usuario findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void saveUser(Usuario user) {
        user.setSenha(bCryptPasswordEncoder.encode(user.getSenha()));
        user.setAtivo(1);
        Role userRole = roleRepository.findByRole("ADMIN");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userRepository.save(user);
    }

    @Override
    public Usuario findOne(Integer id) {
        return userRepository.findOne(Long.valueOf(id));
    }
}
