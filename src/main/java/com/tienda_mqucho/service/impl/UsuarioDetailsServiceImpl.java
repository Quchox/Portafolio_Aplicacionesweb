/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda_mqucho.service.impl;

import com.tienda_mqucho.dao.UsuarioDao;
import com.tienda_mqucho.domain.Rol;
import com.tienda_mqucho.domain.Usuario;
import com.tienda_mqucho.service.UsuarioDetailsService;
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
import org.springframework.transaction.annotation.Transactional;



@Service("userDetailsService")
public class UsuarioDetailsServiceImpl implements UsuarioDetailsService,UserDetailsService{

    @Autowired
    private UsuarioDao usuarioDao;
    
    @Autowired
    private HttpSession session;
    
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) 
            throws UsernameNotFoundException {
         
        
        Usuario usuario = usuarioDao.findByUsername(username);
        
        if(usuario==null){
        //no lo encontro...
        throw new UsernameNotFoundException(username);
        }
        
        session.removeAttribute("usuarioImagen");
        session.setAttribute("usuarioImagen", usuario.getRutaImagen());
        
        //Si se encontro el usuario 
        //Se recuperan los roles del usuario y se tranforman en roles de seguridad del sistema
        var roles=new ArrayList<GrantedAuthority>();
        for (Rol r : usuario.getRoles()){
            //se agregan los roles ya como permisos... o roles reales...
            roles.add(new SimpleGrantedAuthority(r.getNombre()));
        }
        return new User(usuario.getUsername(), usuario.getPassword(),roles);
    }
    
    
}
