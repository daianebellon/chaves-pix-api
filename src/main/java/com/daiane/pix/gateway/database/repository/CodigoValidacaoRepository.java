package com.daiane.pix.gateway.database.repository;

import com.daiane.pix.gateway.database.entity.codigovalidacao.CodigoValidacao;
import com.daiane.pix.gateway.database.entity.codigovalidacao.CodigoValidacaoId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CodigoValidacaoRepository extends JpaRepository<CodigoValidacao, CodigoValidacaoId> {
}
