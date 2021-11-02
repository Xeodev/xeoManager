package dev.xeo.srrtplanner.invoicepackage;


import dev.xeo.srrtplanner.entity.Invoice;

import java.util.List;



public interface InvoiceService {


    List<Invoice> findAll();

    Invoice findById(int theId);

    void save(Invoice theInvoice);

    void deleteById(int theId);

    List<Invoice> searchBy(String theName);

}

