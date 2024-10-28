package com.vkstech.URLShortner.service;

import com.vkstech.URLShortner.dto.UrlDetailsResponseDto;

public interface UrlService {

    UrlDetailsResponseDto createShortUrl(String url);

    String getRedirectUrl(String shortUrlKey);
}
