package com.daiane.pix.gateway.database.repository;

import com.daiane.pix.gateway.database.entity.codigovalidacao.CodigoValidacao;
import com.daiane.pix.gateway.database.entity.codigovalidacao.CodigoValidacaoId;
import com.daiane.pix.gateway.database.entity.codigovalidacao.TipoStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CodigoValidacaoRepository extends JpaRepository<CodigoValidacao, CodigoValidacaoId> {
    Optional<CodigoValidacao> findByCodigoOtpAndTipoStatus(Integer codigoValidacao, TipoStatus tipoStatus);
}
