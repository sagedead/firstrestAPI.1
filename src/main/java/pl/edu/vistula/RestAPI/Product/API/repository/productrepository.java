package pl.edu.vistula.RestAPI.Product.API.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.vistula.RestAPI.Product.API.domain.Product;

@Repository
public interface productrepository extends JpaRepository<Product, Long> {}
