package com.Test_Market.Domain.repository;

import com.Test_Market.Domain.purchase;
import java.util.List;
import java.util.Optional;

public interface purchaseRepository {
    List<purchase> getAll();
    Optional<purchase> getByClient(int ClientId);
    purchase save (purchase prchse);

}
