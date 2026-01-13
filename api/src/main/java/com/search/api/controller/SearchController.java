package com.search.api.controller;
import com.search.api.model.*;import com.search.api.orchestrator.*;
import org.springframework.web.bind.annotation.*;import java.util.*;
@RestController @RequestMapping("/search")
public class SearchController{
 private final SearchOrchestrator o;
 public SearchController(SearchOrchestrator o){this.o=o;}
 @PostMapping public List<SearchResult> search(@RequestBody SearchRequest r)throws Exception{return o.search(r);}
}