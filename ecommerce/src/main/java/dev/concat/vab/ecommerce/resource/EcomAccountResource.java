package dev.concat.vab.ecommerce.resource;

import dev.concat.vab.ecommerce.domain.EcomAccount;
import dev.concat.vab.ecommerce.services.IEcomAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static dev.concat.vab.ecommerce.resource.EcomEmployeeResource.getLocation;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/accounts")
public class EcomAccountResource {
    private final IEcomAccountService iEcomAccountService;

    @PostMapping
    public ResponseEntity<EcomAccount> addAccount(@RequestBody EcomAccount account){
        EcomAccount newAccount = iEcomAccountService.createAccount(account);
        return ResponseEntity.created(getLocation(newAccount.getId().intValue())).body(iEcomAccountService.createAccount(account));
    }

    @GetMapping
    public ResponseEntity<List<EcomAccount>> getAccounts(){
        return ResponseEntity.ok(iEcomAccountService.getAccounts());
    }
}
