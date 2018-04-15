package com.security.wiremock;

import com.github.tomakehurst.wiremock.client.WireMock;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

/**
 * Created by Chris on 2018/4/15.
 */
public class WireMockServer {
    public static void main(String[] args) {
        WireMock.configureFor(3001);
        WireMock.removeAllMappings();
        stubFor(get(urlEqualTo("/my/resource"))
                .withHeader("Accept", equalTo("text/xml"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "text/xml")
                        .withBody("<response>Some content</response>")));

    }
}
