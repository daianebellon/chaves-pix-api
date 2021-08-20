package com.daiane.pix.http;

import com.daiane.pix.domain.chavepix.ChavePixInput;
import com.daiane.pix.domain.chavepix.ChavePixOutput;
import com.daiane.pix.usecase.chavepix.BuscarChavePix;
import com.daiane.pix.usecase.chavepix.CadastrarChavePix;
import com.daiane.pix.usecase.chavepix.ExcluirChavePix;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chavepix")
@RequiredArgsConstructor
public class ChavePixWS {

    private final CadastrarChavePix cadastrarChavePix;
    private final ExcluirChavePix excluirChavePix;
    private final BuscarChavePix buscarChavePix;

    @PostMapping
    public ChavePixOutput cadastrar(@RequestBody ChavePixInput chavePixInput) {
        return cadastrarChavePix.executar(chavePixInput);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Integer id) {
        excluirChavePix.excluir(id);
    }

    @GetMapping("/buscar/{id}")
    public void buscarPeloId(@PathVariable Integer id) {
        buscarChavePix.buscarPeloId(id);
    }
}
