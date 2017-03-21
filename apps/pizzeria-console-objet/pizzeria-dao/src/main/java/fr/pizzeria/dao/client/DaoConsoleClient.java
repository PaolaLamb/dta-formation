package fr.pizzeria.dao.client;

import fr.pizzeria.model.Client;

public interface DaoConsoleClient {
	void enregistrementCoordonnees(Client client);

	void connexionClient();

	void commanderPizzas();

	void listerCommandes();

}
