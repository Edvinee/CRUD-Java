package rca.restapi.yeartwo.year2ADemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/Suppliers")

public class SuppplierController {
    @Autowired
    private SupplierService service;
    @GetMapping("/all")
    public List<Supplier> getAllSupplier(){
        return  service.getAllSuppliers();
    }
    @PostMapping()
    public Supplier createSupplier(@RequestBody Supplier supplier){
        service.createSupplier(supplier);
        return supplier;
    }
    @GetMapping("/{supplierId}")
    public Supplier getSupplier(@PathVariable Long supplierId){
       Optional<Supplier> supplier = (Optional<Supplier>) service.getSupplier(supplierId);
       if(supplier.isPresent()){
           return supplier.get();
       }else {
           throw new RuntimeException("Supplier not found");
       }
    }

    @DeleteMapping("/{supplierId}")
public void deleteSupplier(@PathVariable Long supplierId){
    service.deleteSupplier(supplierId);}

    @PutMapping("/{id}")
    public Supplier updateSupplier(@PathVariable Long id, @RequestBody Supplier supplier) {
        return service.updateSupplier(id, supplier);
    }
}

