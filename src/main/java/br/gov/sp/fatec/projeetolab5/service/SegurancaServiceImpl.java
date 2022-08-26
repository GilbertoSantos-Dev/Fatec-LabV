package br.gov.sp.fatec.projeetolab5.service;

import java.security.InvalidParameterException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.projeetolab5.entity.Usuario;
import br.gov.sp.fatec.projeetolab5.repository.UsusarioRepository;

@Service
public class SegurancaServiceImpl implements SegurancaService {

    @Autowired
    private UsusarioRepository usuarioRepo;

    @Override
    public Usuario novoUsuario(Usuario usuario) {
        if(usuario.getNome() == null || 
            usuario.getNome().isEmpty() ||
            usuario.getSenha() == null){
                throw new InvalidParameterException(msg:"Usuario Invalido")
            }
        
        return usuarioRepo.save(usuario);
    }

    @Override
    public Usuario novoUsuario(String nome, String senha) {
        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setSenha(senha);
        return novoUsuario(usuario);
    }

    @Override
    public List<Usuario> todosUsuarios() {
        return usuarioRepo.findAll();
    }

    @Override
    public Usuario buscarUsuarioPorId(Long id) {
        Optional<Usuario> optionalUsuario = usuarioRepo.findById(id);
        if(optionalUsuario.isEmpty){
            throw new IllegalArgumentException(s="Id nao existe")
        }
        return optionalUsuario.get();
    }
    
}
