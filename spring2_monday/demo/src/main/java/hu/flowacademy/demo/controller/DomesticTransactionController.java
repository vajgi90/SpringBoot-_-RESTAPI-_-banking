package hu.flowacademy.demo.controller;


import hu.flowacademy.demo.persistence.entity.DomesticTransaction;
import hu.flowacademy.demo.service.DomesticTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/")
public class DomesticTransactionController {

    @Autowired
    private DomesticTransactionService domesticTransactionService;

    @GetMapping("domestic-transaction/{id}")
    public DomesticTransaction findById(@PathVariable UUID id) {
        return domesticTransactionService.findById(id);
    }

    @GetMapping("domestic-transactions")
    public List<DomesticTransaction> findAll() {
        return domesticTransactionService.findAll();
    }

    @PostMapping("post")
    public Boolean addDomesticTransaction(@RequestBody  DomesticTransaction data) throws Throwable {
        data.setTransactionId(UUID.randomUUID());
        return domesticTransactionService.addDomesticTransaction(data);
    }

    @DeleteMapping("/{id")
    public Boolean deleteDomesticTransaction(@PathVariable UUID id) {
        return domesticTransactionService.deleteDomesticTransaction(id);
    }


}
