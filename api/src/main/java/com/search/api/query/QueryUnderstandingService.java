package com.search.api.query;

import org.springframework.stereotype.Service;

@Service
public class QueryUnderstandingService {

    public void process(String query) {
        // Tokenize, normalize, generate boosts (to be implemented next)
        System.out.println("Processing query: " + query);
    }
}
