package org.soulcodeacademy.helpr.domain;

import org.soulcodeacademy.helpr.domain.enums.Perfil;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Cliente extends Usuario {

    private String telefone;
    //construtor vazio
    public Cliente(){}

    public Cliente(Integer id, String nome, String email, String cpf, String senha, String telefone) {
        super(id, nome, email, cpf, senha, Perfil.CLIENTE);
        this.telefone=telefone;

    }
       //get e setts
    @Column(length=25)
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}