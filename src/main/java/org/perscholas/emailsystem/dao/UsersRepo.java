package org.perscholas.emailsystem.dao;

import org.perscholas.emailsystem.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UsersRepo extends JpaRepository<Users, Long> {
    Users getByUserName(String name);
    List<Users> findByUserName(String name);
    Users findByUserNameAndPassword(String name, String password);
}
