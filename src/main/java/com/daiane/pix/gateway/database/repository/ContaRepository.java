package com.daiane.pix.gateway.database.repository;

import com.daiane.pix.gateway.database.entity.conta.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Optional;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Integer> {

    Optional<Conta> findByNumeroAgenciaAndNumeroConta(Integer numeroAgencia, BigInteger numeroConta);
}
