package com.jpalearn.Repository;

import com.jpalearn.Beans.BroadCastGroup;
import com.jpalearn.Beans.BroadUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BroadCastGroupRepositoryTest {

    @Autowired
    private BroadUserRepository broadUserRepository;

    @Autowired
    private BroadCastGroupRepository broadCastGroupRepository;
    @Test
    public void saveGroup(){
        BroadCastGroup brGroup=BroadCastGroup.builder().groupName("Broup_1").broadUsersIdList(List.of(1,2,3)).build();
        broadCastGroupRepository.save(brGroup);
    }
}