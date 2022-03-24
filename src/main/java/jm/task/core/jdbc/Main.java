package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

public class Main {
    public static void main(String[] args) {
            UserServiceImpl userService = new UserServiceImpl();
            userService.createUsersTable();
            userService.saveUser("Alex", "Bekker", (byte) 25);
            userService.saveUser("Sonya", "Bekker", (byte) 19);
            userService.saveUser("Veronika", "Bekker", (byte) 20);
            userService.saveUser("Andrew", "Bekker", (byte) 20);
            userService.getAllUsers().forEach(System.out::println);
            userService.cleanUsersTable();
            userService.dropUsersTable();
            Util.closeConnection();
    }
}
