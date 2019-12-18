package hu.flowacademy.demo.repository;

import hu.flowacademy.demo.persistence.entity.DomesticTransaction;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class DomesticTransactionRepository {

    private static Map<UUID, DomesticTransaction> transactionList = new HashMap<>();


    //READ
    public DomesticTransaction findById(UUID id) {
        return transactionList.get(id);
    }

    //READ
    public List<DomesticTransaction> findAll() {
        return new ArrayList<>(transactionList.values());
    }

    //CREATE
    public DomesticTransaction save(DomesticTransaction domesticTransaction) {
        UUID id = UUID.randomUUID();
        domesticTransaction.setTransactionId(id);
        transactionList.put(id, domesticTransaction);
        return domesticTransaction;
    }

    //UPDATE
    public DomesticTransaction update(DomesticTransaction domesticTransaction) {
        transactionList.put(domesticTransaction.getTransactionId(), domesticTransaction);
        return domesticTransaction;
    }

    //DELETE
    public void delete(String id) {transactionList.remove(UUID.fromString(id));}

}
