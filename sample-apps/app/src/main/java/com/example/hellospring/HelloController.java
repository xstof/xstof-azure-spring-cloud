package com.example.hellospring;

import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

	@RequestMapping("/")
	public String index() {
		return "Greetings from Azure Spring Cloud!";
	}

	@GetMapping("/hello")
    public String hello(@RequestHeader Map<String, String> headers, HttpServletRequest request) {
        String output = "<h1>" + "Inspector Java" + "</h1>\n";

        output += "<h2>Request</h2>\n";
        output += "<ul>\n";
        output += "<li>URL: " + request.getRequestURL() + "</li>\n";
        output += "<li>HTTP Method: " + request.getMethod() + "</li>\n";
        output += "<li>Is HTTPS: " + request.isSecure() + "</li>\n";
        output += "<li>Remote Address: " + request.getRemoteAddr() + "</li>\n";
        output += "<li>Remote Host: " + request.getRemoteHost() + "</li>\n";
        output += "<li>Remote Port: " + request.getRemotePort() + "</li>\n";
        output += "</ul>\n";

        output += "<h2>HTTP Headers</h2>\n";
        output += "<ul>\n";
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            output += "<li>" + entry.getKey() + ": " + entry.getValue() + "</li>\n";
        }
        output += "</ul>\n";

        output += "<h2>Environment Variables</h2>\n";
        output += "<ul>\n";
        Map<String, String> map = System.getenv();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            output += "<li>" + entry.getKey() + ": " + entry.getValue() + "</li>\n";
        }
        output += "</ul>\n";

        return output;
    }

}