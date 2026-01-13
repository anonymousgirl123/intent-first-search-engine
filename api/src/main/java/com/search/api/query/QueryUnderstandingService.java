package com.search.api.query;
import com.search.api.model.BoostedTerm;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class QueryUnderstandingService{
 public List<BoostedTerm> process(String q){
  List<BoostedTerm> r=new ArrayList<>();
  for(String t:q.toLowerCase().split("\\s+")){
   float b=t.matches("jacket|charger|shoes")?3f:t.matches("leather|fast")?2f:1f;
   r.add(new BoostedTerm(t,b));
  }
  return r;
 }
}