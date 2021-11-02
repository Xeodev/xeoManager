package dev.xeo.srrtplanner.invoicepackage;


import dev.xeo.srrtplanner.dao.InvoiceRepository;
import dev.xeo.srrtplanner.entity.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceServiceImpl implements InvoiceService {


    private final InvoiceRepository invoiceRepository;

    @Autowired
    public InvoiceServiceImpl(InvoiceRepository theInvoiceRepository) {
        invoiceRepository = theInvoiceRepository;
    }

    @Override
    public List<Invoice> findAll() {
        return invoiceRepository.findAllByOrderByCustomerNameAsc();
    }

    @Override
    public Invoice findById(int theId) {
        Optional<Invoice> result = invoiceRepository.findById(theId);

        Invoice theInvoice;

        if (result.isPresent()) {
            theInvoice = result.get();
        } else {
            // we didn't find the invoice
            throw new RuntimeException("Did not find invoice id - " + theId);
        }

        return theInvoice;
    }

    @Override
    public void save(Invoice theInvoice) {
        invoiceRepository.save(theInvoice);
    }

    @Override
    public void deleteById(int theId) {
        invoiceRepository.deleteById(theId);
    }

    @Override
    public List<Invoice> searchBy(String theName) {

        List<Invoice> results = null;

        if (theName != null && (theName.trim().length() > 0)) {
            results = invoiceRepository.findByCustomerNameContainsOrReferenceContainsAllIgnoreCase((theName), theName);
        } else {
            results = findAll();
        }

        return results;
    }

}
