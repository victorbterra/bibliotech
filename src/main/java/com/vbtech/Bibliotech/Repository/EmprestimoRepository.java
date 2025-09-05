package com.vbtech.Bibliotech.Repository;

import com.vbtech.Bibliotech.Entity.EmprestimoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmprestimoRepository extends JpaRepository<EmprestimoEntity, Long> {
}
