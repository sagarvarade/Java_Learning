package com.jpalearn.Repository;

import com.jpalearn.Beans.Address;
import com.jpalearn.Beans.BroadUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AddressRepositoryTest {

    @Autowired
    private BroadUserRepository broadUserRepository;

    @Test
    public void testBroadSave(){
        Address address=Address.builder().city("Pune").state("MH").street("ABC").zipCode("1231").build();
        BroadUser user=BroadUser.builder().fbId("fb@Id").email("abc@gmail.com").name("userName").instagraid("insta@insta.com").phoneNumber("12423").telegramid("234@telegram.com").whatsappid("123323@whatsapp.com").address(address).build();
        broadUserRepository.save(user);
    }
}