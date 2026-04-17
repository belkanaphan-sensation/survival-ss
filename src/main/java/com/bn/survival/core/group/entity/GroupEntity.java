package com.bn.survival.core.group.entity;

import com.bn.survival.core.commot.entity.BaseEntity;
import com.bn.survival.core.user.entity.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "group")
@Getter
@Setter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class GroupEntity extends BaseEntity {

    private String name;

    private GroupEntity parentGroup;

    private UUID organizationUUID;

    @ManyToMany
    @JoinTable(
            name = "group_user_association",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<UserEntity> users = new HashSet<>();


}
