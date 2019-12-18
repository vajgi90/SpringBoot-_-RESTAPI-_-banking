package hu.flowacademy.demo.service;

import hu.flowacademy.demo.persistence.entity.DomesticTransaction;
import hu.flowacademy.demo.repository.DomesticTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class DomesticTransactionService {

    List<DomesticTransaction> domesticTransactionList = new ArrayList<>();

    @Autowired
    private DomesticTransactionRepository dtRepository;

    public DomesticTransaction findById(UUID id) {
        return dtRepository.findById(id);
    }

    public List<DomesticTransaction> findAll() {
        return domesticTransactionList;
    }

    public Boolean addDomesticTransaction(DomesticTransaction data) throws Throwable {
        DomesticValidationService.createValidator(data);
        domesticTransactionList.add(data);
        if (domesticTransactionList.contains(data)) {
            return true;
        }
        return false;
    }

    public Boolean updateDomesticTransaction(DomesticTransaction data) throws Throwable {
        if (data.getTransactionId() == null) {
            return addDomesticTransaction(data);
        }
        DomesticValidationService.createValidator(data);

        dtRepository.update(data);
        return true;
    }

    public Boolean deleteDomesticTransaction(String id) {
        dtRepository.delete(id);
        return true;
    }
}
