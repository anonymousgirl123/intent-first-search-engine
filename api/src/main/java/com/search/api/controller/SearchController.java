package com.search.api.controller;

import com.search.api.model.SearchRequest;
import com.search.api.model.SearchResult;
import com.search.api.orchestrator.SearchOrchestrator;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {

    private final SearchOrchestrator orchestrator;

    public SearchController(SearchOrchestrator orchestrator) {
        this.orchestrator = orchestrator;
    }

    @PostMapping
    public List<SearchResult> search(@RequestBody SearchRequest request) {
        return orchestrator.search(request);
    }
}
