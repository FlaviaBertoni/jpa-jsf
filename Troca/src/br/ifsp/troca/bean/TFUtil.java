package br.ifsp.troca.bean;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.annotation.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ManagedBean
public class TFUtil {
	
	//O EntityManagerFactory � criado a partir do modelo trocafigurinha.
	private static EntityManagerFactory factory;
	static {
		factory = Persistence.createEntityManagerFactory("trocafigurinha");
	}
	
	//Método: utilizado para criar uma sess�o a partir do modelo trocafigurinha.
	//Retorno: EntityManager
	public static EntityManager getManager(){
		EntityManager manager = factory.createEntityManager();
		return manager;
	}
	
	public static String md5(String senha) {
		String md5 = "";
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));
		md5 = hash.toString(16);
		return md5;
	}
	
}
