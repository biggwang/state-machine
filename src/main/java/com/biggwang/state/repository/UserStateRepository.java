package com.biggwang.state.repository;

import com.biggwang.state.enity.UserStateEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserStateRepository extends CrudRepository<UserStateEntity, Long> {
}
