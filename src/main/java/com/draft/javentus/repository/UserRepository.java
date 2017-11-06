package com.draft.javentus.repository;

import com.draft.javentus.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author lucas
 */

@Repository("userRepository")
public interface UserRepository extends JpaRepository<Usuario, Long> {
	 Usuario findByEmail(String email);
}
