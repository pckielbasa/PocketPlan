package com.pkielbasa.pocketplan.api.mapper;

import com.pkielbasa.pocketplan.application.dto.CreateTransactionRequest;
import com.pkielbasa.pocketplan.domain.model.Budget;
import com.pkielbasa.pocketplan.domain.model.Transaction;

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
}
