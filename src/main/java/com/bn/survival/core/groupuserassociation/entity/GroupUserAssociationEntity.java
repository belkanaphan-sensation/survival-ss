package com.bn.survival.core.groupuserassociation.entity;

import com.bn.survival.core.commot.entity.BaseEntity;
import com.bn.survival.core.group.entity.GroupEntity;
import com.bn.survival.core.group.entity.GroupRole;
import com.bn.survival.core.user.entity.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "group_user_association")
@Getter
@Setter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class GroupUserAssociationEntity extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "group_id")
    private GroupEntity group;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ElementCollection
    @CollectionTable(name = "group_user_role", joinColumns = @JoinColumn(name = "group_user_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Set<GroupRole> roles = new HashSet<>();


}
