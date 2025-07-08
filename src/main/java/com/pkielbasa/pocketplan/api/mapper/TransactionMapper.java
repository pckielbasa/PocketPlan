package com.pkielbasa.pocketplan.api.mapper;

import com.pkielbasa.pocketplan.api.dto.transaction.CreateTransactionRequest;
import com.pkielbasa.pocketplan.api.dto.transaction.TransactionResponse;
import com.pkielbasa.pocketplan.api.dto.transaction.UpdateTransactionRequest;
import com.pkielbasa.pocketplan.domain.model.Budget;
import com.pkielbasa.pocketplan.domain.model.Transaction;

import java.util.Optional;

public class TransactionMapper {

    public static Transaction mapToEntity(CreateTransactionRequest request, Budget budget) {
        return Transaction.builder()
                .budget(budget)
                .name(request.name())
                .description(request.description())
                .type(request.type())
                .fee(request.fee())
                .date(request.date())
                .build();
    }

    public static TransactionResponse mapToResponse(Transaction transaction) {
        return new TransactionResponse(
                transaction.getId(),
                transaction.getBudget().getId(),
                transaction.getName(),
                transaction.getDescription(),
                transaction.getType(),
                transaction.getFee(),
                transaction.getDate()
        );
    }

    public static void updateEntity(Transaction existingTransaction, UpdateTransactionRequest request) {
        existingTransaction.setName(request.name());
        Optional.ofNullable(request.description()).ifPresent(existingTransaction::setDescription);
        existingTransaction.setType(request.type());
        existingTransaction.setFee(request.fee());
        existingTransaction.setDate(request.date());
    }
}
