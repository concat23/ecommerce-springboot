package dev.concat.vab.ecommerce.services;

import dev.concat.vab.ecommerce.domain.EcomAccount;

import java.util.List;

public interface IEcomAccountService {
    EcomAccount createAccount(EcomAccount account);
    EcomAccount findByUsername(String username);
    List<EcomAccount> getAccounts();
}
