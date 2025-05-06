package rca.restapi.yeartwo.year2ADemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {
    @Autowired
    private final SupplierRepository repository;

    public SupplierService(SupplierRepository repository) {
        this.repository = repository;
    }

    public List<Supplier> getAllSuppliers() {
        return repository.findAll();
    }
    public Optional<Supplier> getSupplier(Long id) {
        return repository.findById(id);
    }


    public void createSupplier(Supplier supplier) {
        repository.save(supplier);
    }

    public void deleteSupplier(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Supplier not found");
        }
        repository.deleteById(id);
    }

    public Supplier updateSupplier(Long id, Supplier updatedSupplier) {
        return repository.findById(id).map(existingSupplier -> {
            existingSupplier.setSupplierName(updatedSupplier.getSupplierName());
            existingSupplier.SetAddress(updatedSupplier.getAddress());
            // Set other fields as needed
            return repository.save(existingSupplier);
        }).orElseThrow(() -> new RuntimeException("Supplier not found"));
    }
}

