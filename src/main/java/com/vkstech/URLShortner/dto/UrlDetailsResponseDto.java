package com.vkstech.URLShortner.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UrlDetailsResponseDto {

    private String url;
    private String shortUrl;
}
