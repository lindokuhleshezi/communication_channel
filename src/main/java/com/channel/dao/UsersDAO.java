package com.channel.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.channel.domain.Users;
import java.util.UUID;

@Repository
public interface UsersDAO extends JpaRepository<Users, String>{

}
