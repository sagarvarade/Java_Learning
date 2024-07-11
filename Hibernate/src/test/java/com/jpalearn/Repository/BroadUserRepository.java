package com.jpalearn.Repository;

import com.jpalearn.Beans.BroadUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BroadUserRepository extends JpaRepository<BroadUser,Long> {
}
