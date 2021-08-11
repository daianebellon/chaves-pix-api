package com.daiane.pix.gateway.database.repository;

import com.daiane.pix.gateway.database.entity.chavepix.ChavePix;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChavePixRepository extends JpaRepository<ChavePix, Integer> {
}
