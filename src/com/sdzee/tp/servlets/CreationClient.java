package com.sdzee.tp.servlets;

import javax.servlet.http.HttpServlet;
import com.sdzee.tp.beans.Client;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;

public class CreationClient extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("nomClient");
		String prenom = request.getParameter("prenomClient");
		String adresse = request.getParameter("adresseClient");
		String telephone = request.getParameter("telephoneClient");
		String email = request.getParameter("emailClient");
		
		String message;
		if(nom.trim().isEmpty() || adresse.trim().isEmpty() || telephone.trim().isEmpty()) {
			message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires. <br> <a href=\"creerClient.jsp\">Cliquez ici</a> pour accéder au formulaire de création d'un client.";
		}
		else {
			message = "Client crée avec succès !";
		}
		Client client = new Client();
		client.setNom(nom);
		client.setPrenom(prenom);
		client.setAdresse(adresse);
		client.setTelephone(telephone);
		client.setEmail(email);
		
		request.setAttribute("client", client);
		request.setAttribute("message", message);
		
		this.getServletContext().getRequestDispatcher("/afficherClient.jsp").forward(request, response);
	}
	

}
