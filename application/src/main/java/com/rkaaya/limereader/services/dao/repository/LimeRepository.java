package com.rkaaya.limereader.services.dao.repository;

import com.rkaaya.limereader.services.dao.entity.LimeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LimeRepository extends JpaRepository<LimeEntity, Long> {

    List<LimeEntity> findTop10ByOrderByMessageCreatedDesc();
}
