package com.search.api.es;
import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.search.Hit;
import com.search.api.model.*;
import jakarta.json.JsonObject;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class ElasticSearchService{
 private final ElasticsearchClient c;
 public ElasticSearchService(ElasticsearchClient c){this.c=c;}
 public List<SearchResult> search(List<BoostedTerm> terms)throws Exception{
  var res=c.search(s->s.index("products").query(q->q.bool(b->{
   terms.forEach(t->b.should(sh->sh.match(m->m.field("title").query(t.token).boost(t.boost))));
   return b;})),JsonObject.class);
  List<SearchResult> out=new ArrayList<>();
  for(Hit<JsonObject> h:res.hits().hits())
   out.add(new SearchResult(h.id(),h.source().getString("title"),h.score()));
  return out;
 }
}