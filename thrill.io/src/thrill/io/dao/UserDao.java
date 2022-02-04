package thrill.io.dao;

import thrill.io.DataStore;
import thrill.io.entities.User;

public class UserDao {

	public User[] getUsers() {
		return DataStore.getUsers();
	}

}
