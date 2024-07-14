package com.jpalearn.Beans;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class BroadCastGroup {
    @Id
    @SequenceGenerator(
            name="broadcast_group_sequence",
            sequenceName = "broadcast_group_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "broadcast_group_sequence"
    )
    @Column(name = "broad_cast_group_id")
    private Long broadCastGroupId;

    private String groupName;

    @ElementCollection
    private List<Integer> broadUsersIdList;
}
