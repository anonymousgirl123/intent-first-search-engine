package com.search.api.orchestrator;
import com.search.api.query.*;import com.search.api.es.*;import com.search.api.model.*;
import org.springframework.stereotype.Service;import java.util.*;
@Service
public class SearchOrchestrator{
 private final QueryUnderstandingService q; private final ElasticSearchService e;
 public SearchOrchestrator(QueryUnderstandingService q,ElasticSearchService e){this.q=q;this.e=e;}
 public List<SearchResult> search(SearchRequest r)throws Exception{return e.search(q.process(r.query));}
}