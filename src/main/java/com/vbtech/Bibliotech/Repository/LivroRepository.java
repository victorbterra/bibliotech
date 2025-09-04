package com.vbtech.Bibliotech.Repository;

import com.vbtech.Bibliotech.Entity.LivroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<LivroEntity, Long> {

    List <LivroEntity> findByTituloContainingIgnoreCase(String titulo);
    List <LivroEntity> findByAutorContainingIgnoreCase(String autor);
}
