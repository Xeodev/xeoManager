package dev.xeo.srrtplanner.invoicepackage;


import dev.xeo.srrtplanner.entity.Invoice;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/invoices")
public class InvoiceController {


    private final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }


// add mapping for "/list"

    @GetMapping("/list")
    public String listInvoices(Model theModel) {

        // get boats from db
        List<Invoice> theInvoices = invoiceService.findAll();

        // add to the spring model
        theModel.addAttribute("invoices", theInvoices);

        return "invoices/list-invoices";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        // create model attribute to bind form data
        Invoice theInvoice = new Invoice();

        theModel.addAttribute("invoice", theInvoice);

        return "invoices/invoice-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("invoiceId") int theId,
                                    Model theModel) {

        // get the employee from the service
        Invoice theInvoice = invoiceService.findById(theId);

        // set employee as a model attribute to pre-populate the form
        theModel.addAttribute("invoice", theInvoice);

        // send over to our form
        return "invoices/invoice-form";
    }


    @PostMapping("/save")
    public String saveBoat(@ModelAttribute("invoice") Invoice theInvoice) {

        // save the invoice
        invoiceService.save(theInvoice);

        // use a redirect to prevent duplicate submissions
        return "redirect:/invoices/list";
    }


    @GetMapping("/delete")
    public String delete(@RequestParam("invoiceId") int theId) {

        // delete the bat
        invoiceService.deleteById(theId);

        // redirect to /boats/list
        return "redirect:/invoices/list";

    }

    @GetMapping("/search")
    public String delete(@RequestParam("customerName") String theName,
                         Model theModel) {

        // delete the boat instance
        List<Invoice> theInvoices = invoiceService.searchBy(theName);

        // add to the spring model
        theModel.addAttribute("invoices", theInvoices);

        // send to /boats/list
        return "invoices/list-invoices";

    }

}





