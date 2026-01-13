package com.search.api.orchestrator;

import com.search.api.model.SearchRequest;
import com.search.api.model.SearchResult;
import com.search.api.query.QueryUnderstandingService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class SearchOrchestrator {

    private final QueryUnderstandingService queryUnderstandingService;

    public SearchOrchestrator(QueryUnderstandingService queryUnderstandingService) {
        this.queryUnderstandingService = queryUnderstandingService;
    }

    public List<SearchResult> search(SearchRequest request) {
        // Step 1: Understand query and generate boosts
        queryUnderstandingService.process(request.getQuery());

        // Step 2: (Next step) Build ES query and execute
        return Collections.emptyList();
    }
}
