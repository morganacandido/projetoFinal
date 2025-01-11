package br.com.papelaria.projetoFinal.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import br.com.papelaria.projetoFinal.model.Usuario;
import br.com.papelaria.projetoFinal.repository.UsuarioRepository;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> findAll() {
        return this.usuarioRepository.findAll();
    }
 
    public Usuario findById(String id) {
        return this.usuarioRepository.findById(id).orElseThrow(()  -> new RuntimeException("Usuario não encontrado"));
    }

    public Usuario save(Usuario usuario) {
        return this.usuarioRepository.save(usuario);
    }

    public Usuario update(Usuario usuario){
        var usuarioEntity = this.findById(usuario.getId());
        BeanUtils.copyProperties(usuario, usuarioEntity);
        return this.usuarioRepository.save(usuarioEntity);
    }

    public void delete(String id) {
        this.usuarioRepository.deleteById(id);
    }
}
