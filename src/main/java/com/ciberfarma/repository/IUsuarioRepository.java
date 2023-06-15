package com.ciberfarma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ciberfarma.model.Usuario;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer>{
	//la entidad usuario y el id que es integer
	//Metodo que busque x usuario y clave
	//selecr * froom tb_usua where usua_usua = ? and cla_usua = ?
	//elmetodo es tal como esta por que es de un springio
	public Usuario findByCorreoAndClave(String correo,String clave);
}
