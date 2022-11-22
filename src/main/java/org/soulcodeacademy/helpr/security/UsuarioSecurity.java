package org.soulcodeacademy.helpr.security;

import org.soulcodeacademy.helpr.domain.enums.Perfil;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

// Esta classe serve de ponte para a comunicação entre
//a persistencia e o framework Spring Security
public class UsuarioSecurity implements UserDetails {//21/11
    //Dados de autenticaçao
    private String email;
    private String senha;

    //Dados de autorização
    private Perfil perfil;
    //Armazena as permissoes/autoridade do usuario
    private ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();

    public UsuarioSecurity(String email, String senha,Perfil perfil){
        this.email= email;
        this.senha= senha;
        this.perfil= perfil;
        //Adiciona a descricao do perfil como uma role do usuario
        this.authorities.add(new SimpleGrantedAuthority(perfil.getDescricao()));

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Indica para o Security as permissoes/papeis do meu usuario
        return this.authorities;
    }

    @Override
    public String getPassword() {
        //Indica para o  Security que nosso usuário possui a senha abaixo
        return this.senha;
    }

    @Override
    public String getUsername() { // pode ser :email / cpf / etc
        // Indica para o Security que nosso usuário possui o email abaixo
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        // Flag que indica se a conta está válida
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        //Flag que indica se a conta esta desbloqueada
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        //Flag que indica se as credenciais estão válidas
        return true;
    }

    @Override
    public boolean isEnabled() {
        // Flag que indica se o usuário está habilitado
        return true;
    }

    //Indicamos por meios dos getters o estado de autenticação/autorização
    // dos nossos usuarios salvos no banco de dados
}
