package com.bnpp.epita.MQ.exposition;

import java.time.LocalDate;

public class DtoChatMessage {
    String sender;               //émetteur
    String recipient;             //destinataire
    String content;
    LocalDate timestamp;

    public DtoChatMessage(String sender, String recipient, String content, LocalDate timestamp) {
        this.sender = sender;
        this.recipient = recipient;
        this.content = content;
        this.timestamp = timestamp;
    }

    public DtoChatMessage() {
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDate timestamp) {
        this.timestamp = timestamp;
    }
}
