package com.vkstech.URLShortner.controller;

import com.vkstech.URLShortner.dto.UrlDetailsRequestDto;
import com.vkstech.URLShortner.dto.UrlDetailsResponseDto;
import com.vkstech.URLShortner.service.UrlService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@Slf4j
@RestController
@RequestMapping("/url")
public class UrlController {

    private final UrlService urlService;

    @Autowired
    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }

    @PostMapping("/create")
    public ResponseEntity<UrlDetailsResponseDto> createShortURL(
            @RequestBody UrlDetailsRequestDto urlDetailsRequestDto) {
        log.info("UrlController::createShortURL");
        return ResponseEntity.ok(urlService.createShortUrl(urlDetailsRequestDto.getUrl()));
    }

    @GetMapping("/{shortUrlKey}")
    public ResponseEntity<Void> getRedirectURL(@PathVariable String shortUrlKey) {
        log.info("UrlController::getRedirectURL");
        String redirectUrl = urlService.getRedirectUrl(shortUrlKey);
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .location(URI.create(redirectUrl))
                .build();
    }
}
