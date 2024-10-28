package com.vkstech.URLShortner.repository;

import com.vkstech.URLShortner.entity.UrlDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UrlDetailsRepository extends JpaRepository<UrlDetails, UUID> {

    UrlDetails findByShortUrlKey(String shortUrlKey);
}
