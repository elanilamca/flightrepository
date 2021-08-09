package com.elango.document.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elango.document.entities.Document;

public interface DocumentRepository extends JpaRepository<Document, Long>{

}
