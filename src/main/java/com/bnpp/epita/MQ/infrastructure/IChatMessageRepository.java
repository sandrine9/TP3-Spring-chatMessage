package com.bnpp.epita.MQ.infrastructure;

import com.bnpp.epita.MQ.domaine.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IChatMessageRepository extends JpaRepository<ChatMessage, Long> {

}
