package org.soulcodeacademy.helpr.controllers;

import org.soulcodeacademy.helpr.domain.Funcionario;
import org.soulcodeacademy.helpr.domain.dto.FuncionarioDTO;
import org.soulcodeacademy.helpr.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping("/funcionarios")
    public List<Funcionario> listar() {

        return this.funcionarioService.listar();
    }

    // @RequestParam = Captura os valores de parâmetro após? ex:/funcionarios/salario?valor1=1000&valor2=2000
    @GetMapping("/funcionarios/salario")
    public List<Funcionario> listarPorFaixaSalarial(@RequestParam Double valor1, @RequestParam Double valor2){
      return this.funcionarioService.listarPorFaixaSalarial(valor1,valor2);
    }



    @GetMapping("/funcionarios/{idFuncionario}")
    public Funcionario getFuncionario(@PathVariable Integer idFuncionario) {
        return this.funcionarioService.getFuncionario(idFuncionario);
    }

    //inserção de dados
    @PostMapping("/funcionarios")
    public Funcionario salvar(@Valid @RequestBody FuncionarioDTO dto) {
        Funcionario funcionario = this.funcionarioService.salvar(dto);
        return funcionario;
    }


    @PutMapping("/funcionarios/{idFuncionario}") //substituir uma informação
    public Funcionario atualizar(@PathVariable Integer idFuncionario,@Valid @RequestBody FuncionarioDTO dto) {
        Funcionario atualizado = this.funcionarioService.atualizar(idFuncionario,dto);
       return atualizado;
    }


   @DeleteMapping("/funcionarios/{idFuncionarios}")
    public void deletar(@PathVariable Integer idFuncionario) {
       this.funcionarioService.deletar(idFuncionario);
    }
}