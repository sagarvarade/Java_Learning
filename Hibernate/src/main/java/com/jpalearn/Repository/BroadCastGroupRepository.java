package com.jpalearn.Repository;

import com.jpalearn.Beans.BroadCastGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BroadCastGroupRepository extends JpaRepository<BroadCastGroup,Long> {
}
