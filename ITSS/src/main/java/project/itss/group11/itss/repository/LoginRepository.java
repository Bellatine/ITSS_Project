package project.itss.group11.itss.repository;

import project.itss.group11.itss.model.Account;

public interface LoginRepository {
    Account Login(String username);
}
