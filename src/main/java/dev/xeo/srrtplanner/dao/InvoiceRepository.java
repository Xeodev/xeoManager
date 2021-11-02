package dev.xeo.srrtplanner.dao;


import dev.xeo.srrtplanner.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {



    // add a method to sort by last name
    List<Invoice> findAllByOrderByCustomerNameAsc();

    // search by name
    List<Invoice> findByCustomerNameContainsOrReferenceContainsAllIgnoreCase(String name, String lName);

}
