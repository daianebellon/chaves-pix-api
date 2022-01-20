package com.daiane.pix.gateway.database.repository;

import com.daiane.pix.gateway.database.entity.chavepix.TipoChave;
import com.daiane.pix.gateway.database.entity.codigovalidacao.CodigoValidacao;
import com.daiane.pix.gateway.database.entity.codigovalidacao.CodigoValidacaoId;
import com.daiane.pix.gateway.database.entity.codigovalidacao.TipoStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CodigoValidacaoRepository extends JpaRepository<CodigoValidacao, CodigoValidacaoId> {

    @Query("update CodigoValidacao cv set cv.tipoStatus = :status where" +
            " cv.codigoOtp = :codigo and " +
            "cv.codigoValidacaoId.conta.id = :contaid and " +
            "cv.codigoValidacaoId.tipoChave = :tipochave and" +
            " cv.codigoValidacaoId.valorChave = :valorchave")
    @Modifying
    void updateStatusCodigoValidacao(@Param("codigo") Integer codigoValidacao,
                                     @Param("contaid") Integer contaId,
                                     @Param("tipochave") TipoChave tipoChave,
                                     @Param("valorchave") String valorChave,
                                     @Param("status") TipoStatus tipoStatus);

    Optional<CodigoValidacao> findByCodigoOtpAndCodigoValidacaoIdContaIdAndCodigoValidacaoIdTipoChaveAndCodigoValidacaoIdValorChaveAndTipoStatus(Integer codigoValidacao, Integer contaId, TipoChave tipoChave, String valorChave, TipoStatus tipoStatus);

}
