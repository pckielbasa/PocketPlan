package com.pkielbasa.pocketplan.application.service;

import com.pkielbasa.pocketplan.api.mapper.TransactionMapper;
import com.pkielbasa.pocketplan.application.dto.CreateTransactionRequest;
import com.pkielbasa.pocketplan.domain.model.Transaction;
import com.pkielbasa.pocketplan.domain.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public Long createTransaction(CreateTransactionRequest request) {
        Transaction savedTransaction = transactionRepository.createTransaction(TransactionMapper.mapToEntity(request));
        return savedTransaction.getId();
    }
}
