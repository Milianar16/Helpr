package org.soulcodeacademy.helpr.controllers;
import org.soulcodeacademy.helpr.domain.Cliente;
import org.soulcodeacademy.helpr.domain.dto.ClienteDTO;
import org.soulcodeacademy.helpr.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController // Controller coletar as requisiçoes
public class ClienteController{

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/clientes")
    public  List<Cliente> listar() {

        return this.clienteService.listar();
    }

    @GetMapping("/clientes/{idCliente}")
    public Cliente getCliente(@PathVariable Integer idCliente) {
        return this.clienteService.getCliente(idCliente);
    }

    //inserção de dados
    @PostMapping("/clientes")
    public Cliente salvar(@Valid @RequestBody ClienteDTO dto) {
        Cliente cliente = this.clienteService.salvar(dto);
        return cliente;
    }


    @PutMapping("/clientes/{idCliente}") //substituir uma informação
    public Cliente atualizar(@PathVariable Integer idCliente, @Valid @RequestBody ClienteDTO dto) {
        Cliente atualizado = this.clienteService.atualizar(idCliente,dto);
        return atualizado; // Corpo da resposta em Json!
    }


    @DeleteMapping("/clientes/{idCliente}")
    public void deletar(@PathVariable Integer idCliente) {
        this.clienteService.deletar(idCliente);
    }
}
