package org.soulcodeacademy.helpr.services;


import org.soulcodeacademy.helpr.domain.Cliente;
import org.soulcodeacademy.helpr.domain.dto.ClienteDTO;
import org.soulcodeacademy.helpr.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service // torna o objeto da classe injetavel
public class ClienteService {

        @Autowired // injeção do repository
        private ClienteRepository clienteRepository;


        public List<Cliente> listar() {
            return this.clienteRepository.findAll();
        }

        public Cliente getCliente(Integer idCliente) {
            //Optional = pode existir ou não SELECT * FROM usuarios WHERE id=?
            Optional<Cliente> cliente = this.clienteRepository.findById(idCliente);

            if (cliente.isEmpty()) {
                //lançar exceção
                throw new RuntimeException("O cliente não foi encontrado!");
            } else {
                return cliente.get(); // pega o valor da entidade encontrada
            }
        }

        public Cliente salvar(ClienteDTO dto) { // salvar no banco de dados
            Cliente cliente = new Cliente(null, dto.getNome(), dto.getEmail(), dto.getCpf(), dto.getSenha(), dto.getTelefone());
            Cliente salvo = this.clienteRepository.save(cliente);
            return salvo;
        }

        public Cliente atualizar(Integer idCliente, @Valid ClienteDTO dto) {
            //Busca o funcionario com o idFuncionario
            Cliente clienteAtual = this.getCliente(idCliente);



            clienteAtual.setNome(dto.getNome());
            clienteAtual.setEmail(dto.getEmail());
            clienteAtual.setCpf(dto.getCpf());
            clienteAtual.setSenha(dto.getSenha());
            clienteAtual.setTelefone(dto.getTelefone());


            Cliente atualizado = this.clienteRepository.save(clienteAtual);
            return  atualizado;
        }


   public void deletar(Integer idCliente){
            Cliente cliente = this.getCliente(idCliente);
            this.clienteRepository.delete(cliente);
   }
        }

// Quando usar entidade e dto?
// Entidade = retorno dos dados
// DTO= entrada de dados // novos dados