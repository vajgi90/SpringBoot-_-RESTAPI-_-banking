package hu.flowacademy.demo.persistence.entity;

import java.util.UUID;

public class DomesticTransaction {
    private UUID transactionId;
    private String senderName;
    private String hostName;
    private String hostAccountNumber;
    private long amount;

    public DomesticTransaction() {}

    public DomesticTransaction(String senderName, String hostName, String hostAccountNumber, long amount) {
        this.transactionId = UUID.randomUUID();
        this.senderName = senderName;
        this.hostName = hostName;
        this.hostAccountNumber = hostAccountNumber;
        this.amount = amount;
    }



    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public UUID getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(UUID transactionId) {
        this.transactionId = UUID.randomUUID();
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getHostAccountNumber() {
        return hostAccountNumber;
    }

    public void setHostAccountNumber(String hostAccountNumber) {
        this.hostAccountNumber = hostAccountNumber;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

}

//1.2.	Készíts egy DomesticTransaction osztályt, ami egy belföldi banki átualás alap adatait tartalmazza, ezek rendre:
//	transactionId(UUID), senderName(String), hostName(String), hostAccountNumber(String), amount(Long).