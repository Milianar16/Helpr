package org.soulcodeacademy.helpr.services;

import org.soulcodeacademy.helpr.domain.Cargo;
import org.soulcodeacademy.helpr.domain.Chamado;
import org.soulcodeacademy.helpr.domain.Cliente;
import org.soulcodeacademy.helpr.domain.Funcionario;
import org.soulcodeacademy.helpr.domain.enums.StatusChamado;
import org.soulcodeacademy.helpr.repositories.CargoRepository;
import org.soulcodeacademy.helpr.repositories.ChamadoRepository;
import org.soulcodeacademy.helpr.repositories.ClienteRepository;
import org.soulcodeacademy.helpr.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Torna o objeto de PopulateService disponível para toda a aplicação (global)
@Service // indica para o Spring que esta classe será gerenciada por ele
public class PopulateService {
    @Autowired // injetar o objeto direto na classe
    private CargoRepository cargoRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository; // injetor o repository

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ChamadoRepository chamadoRepository;


    public void populate() {
        // Integer idCargo, String nome, String descricao, Double salario
        Cargo c1 = new Cargo(null, "Diretor Geral", "Gerencia a empresa", 30000.0);
        Cargo c2 = new Cargo(null, "Diretor de Setor", "Gerencia um setor da empresa", 18000.0);
        Cargo c3 = new Cargo(null, "Técnico geral", "Resolve os chamados urgentes", 12000.0);

        Funcionario f1 = new Funcionario(null, "Renato Pereira", "renato.pereira@gmail.com", "68258098144", "12345", null, c1);

        Funcionario f2 = new Funcionario(null, "Victor Icoma", "victor.icoma@gmail.com", "51127383671", "12345", null, c2);

        Cliente a1= new Cliente(null,"Marcos Lima","marquinmoreira@gmail.com","37651860314","404040","11456987");

        Cliente a2= new Cliente(null,"Carola Pontes","carola12@gmail.com","21934433608","444444","78962589");

        Cliente a3= new Cliente(null,"Maria Gaze","gaga@gmail.com","16334192744","778899","45189623");

        Chamado ch1 = new Chamado(null,"Primeiro chamado do sistema","Revisar as entidades criadas");
        ch1.setCliente(a1);

        Chamado ch2 = new Chamado(null,"Ativar VPN do sistema","Conectar aos servidores remotos");
        ch2.setFuncionario(f1);
        ch2.setStatus(StatusChamado.ATRIBUIDO);


        // vamos persistir as entidades = salvar no banco
        this.cargoRepository.saveAll(List.of(c1, c2, c3));
        this.funcionarioRepository.saveAll(List.of(f1, f2));
        this.clienteRepository.saveAll(List.of(a1, a2));
        this.chamadoRepository.saveAll(List.of(ch1, ch2));


    }


}
