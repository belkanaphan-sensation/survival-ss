package com.bn.survival.core.user.entity;

import com.bn.survival.core.commot.entity.BaseEntity;
import com.bn.survival.core.group.entity.GroupEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "user")
@Getter
@Setter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity extends BaseEntity {

    private UUID userUUID;

    @ManyToMany(mappedBy = "users")
    private Set<GroupEntity> groups = new HashSet<>();
}
