package com.daiane.pix.gateway.database.repository;

import com.daiane.pix.gateway.database.entity.chavepix.ChavePix;
import com.daiane.pix.gateway.database.entity.codigovalidacao.CodigoValidacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChavePixRepository extends JpaRepository<ChavePix, Integer> {

    Optional<ChavePix> findByContaId(Integer id);

    Optional<ChavePix> findByValorChave(String valorChave);
}
