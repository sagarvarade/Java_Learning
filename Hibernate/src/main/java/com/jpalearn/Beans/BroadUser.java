package com.jpalearn.Beans;

import jakarta.persistence.*;

import java.util.Date;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

import lombok.*;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BroadUser {
    @Id
    @SequenceGenerator(
            name="broad_user_sequence",
            sequenceName = "broad_user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "broad_user_sequence"
    )
    private Long broadUserId;
    private String name;
    private String email;
    private String phoneNumber;
    private String fbId;
    private String instagraid;
    private String linkedinid;
    private String telegramid;
    private String whatsappid;
    private String gender;
    private Date dateOfBirth;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_add_id")
    private Address address;
}
