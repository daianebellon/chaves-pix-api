package com.daiane.pix.http;

import com.daiane.pix.domain.chavepix.ChavePixInput;
import com.daiane.pix.domain.chavepix.ChavePixOutput;
import com.daiane.pix.usecase.chavepix.BuscarChavePixPeloId;
import com.daiane.pix.usecase.chavepix.BuscarTodasAsChavesPix;
import com.daiane.pix.usecase.chavepix.CadastrarChavePix;
import com.daiane.pix.usecase.chavepix.ExcluirChavePix;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chavepix")
@RequiredArgsConstructor
public class ChavePixWS {

    private final CadastrarChavePix cadastrarChavePix;
    private final ExcluirChavePix excluirChavePix;
    private final BuscarChavePixPeloId buscarChavePixPeloId;
    private final BuscarTodasAsChavesPix buscarChavesPix;

    @PostMapping
    public ChavePixOutput cadastrar(@RequestBody ChavePixInput chavePixInput) {
        return cadastrarChavePix.executar(chavePixInput);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Integer id) {
        excluirChavePix.executar(id);
    }

    @GetMapping("/{id}")
    public ChavePixOutput buscarPeloId(@PathVariable Integer id) {
        return buscarChavePixPeloId.executar(id);
    }

    @GetMapping
    public Page<ChavePixOutput> buscarTodos(@RequestParam int pagina, @RequestParam int quantidade) {
        return buscarChavesPix.executar(pagina, quantidade);
    }

}
