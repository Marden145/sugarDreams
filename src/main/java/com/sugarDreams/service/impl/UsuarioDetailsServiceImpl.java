/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sugarDreams.service.impl;


import com.sugarDreams.dao.UsuarioDao;
import com.sugarDreams.domain.Rol;
import com.sugarDreams.domain.Usuario;
import com.sugarDreams.service.UsuarioDetailsService;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.*;

@Service("userDetailsService")
public class UsuarioDetailsServiceImpl
    implements UsuarioDetailsService,
        UserDetailsService {

    
    @Autowired
    private UsuarioDao usuarioDao;
    
    
     @Autowired HttpSession session;
   
    
    
    @Override
    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       
    //Se busca el Usuario en la tabla usuarios
    
    Usuario usuario = usuarioDao.findByUsername(username);
    
    if (usuario==null){
        throw new UsernameNotFoundException(username);
   
    }
    // si estamos aca... es que si se encontro el username
    
    session.removeAttribute("usuarioImagen");
    session.setAttribute("usuarioImagen", usuario.getRutaImagen());
    
    // AHORA SE CARGAN LOS ROLES DEL USUARIO COMO ROLES
    
   var roles = new ArrayList<GrantedAuthority>();
        for (Rol r:usuario.getRoles()) {
            roles.add(new SimpleGrantedAuthority(r.getNombre()));
            
        }
        
        return new User(usuario.getUsername(),usuario.getPassword(),roles);
    }
}
