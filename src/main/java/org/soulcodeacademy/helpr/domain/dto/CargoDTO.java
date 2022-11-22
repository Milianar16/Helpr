package org.soulcodeacademy.helpr.domain.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

//DTO-Objeto de transferencia de dados
//É útil para validarmos as informações tranferidas pelo cliente
public class CargoDTO {

    //Impede que o valor de nome seja "", por exemplo
    //Message é o texto da validação
    @NotBlank(message = "Campo nome é obrigatório")
    private String nome;
    private String descricao;

    //Impede que o valor seja null
    @NotNull(message = "Campo salário é obrigatório")
    @Min(value = 500, message = "Campo salário deve ser maior que 500")
    @Max(value = 100000, message = "Campo salário inválio")
    private Double salario;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }
}
