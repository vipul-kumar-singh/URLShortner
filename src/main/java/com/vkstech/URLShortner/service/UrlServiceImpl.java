package com.vkstech.URLShortner.service;

import com.vkstech.URLShortner.dto.UrlDetailsResponseDto;
import com.vkstech.URLShortner.entity.UrlDetails;
import com.vkstech.URLShortner.repository.UrlDetailsRepository;
import com.vkstech.URLShortner.utils.ShortUrlKeyGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.vkstech.URLShortner.constant.UrlConstants.BASE_URL;

@Slf4j
@Service
public class UrlServiceImpl implements UrlService {

    private final UrlDetailsRepository urlDetailsRepository;

    @Autowired
    public UrlServiceImpl(UrlDetailsRepository urlDetailsRepository) {
        this.urlDetailsRepository = urlDetailsRepository;
    }

    @Override
    public UrlDetailsResponseDto createShortUrl(String url) {
        log.info("UrlServiceImpl::createShortUrl");
        String shortUrlKey = ShortUrlKeyGenerator.getShortUrlKey();

        UrlDetails urlDetails = new UrlDetails();
        urlDetails.setUrl(url);
        urlDetails.setShortUrlKey(shortUrlKey);
        urlDetailsRepository.save(urlDetails);

        return getUrlDetailsResponseDto(urlDetails);
    }

    @Override
    public String getRedirectUrl(String shortUrlKey) {
        log.info("UrlServiceImpl::getRedirectUrl");
        UrlDetails urlDetails = urlDetailsRepository.findByShortUrlKey(shortUrlKey);
        return urlDetails.getUrl();
    }

    private UrlDetailsResponseDto getUrlDetailsResponseDto(UrlDetails urlDetails) {
        log.info("UrlServiceImpl::getUrlDetailsResponseDto");

        UrlDetailsResponseDto urlDetailsResponseDto = new UrlDetailsResponseDto();
        urlDetailsResponseDto.setShortUrl(BASE_URL + urlDetails.getShortUrlKey());
        urlDetailsResponseDto.setUrl(urlDetails.getUrl());
        return urlDetailsResponseDto;
    }
}
