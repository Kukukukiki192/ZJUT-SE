package com.filter;
import javax.servlet.http.*;
public class NonCachingRequestWrapper extends HttpServletRequestWrapper{
   public NonCachingRequestWrapper(HttpServletRequest request){
      super(request);
   }
   @Override
   public String getHeader(String name){
     // 隐藏If-Modified-Since头值
     if(name.equals("If-Modified-Since")){
          return null;
     }else{
         return super.getHeader(name);
     }
  }
}

