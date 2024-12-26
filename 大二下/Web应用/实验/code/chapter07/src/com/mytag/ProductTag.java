package com.mytag;
import java.io.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.model.Product;

public class ProductTag extends SimpleTagSupport{
  private ArrayList<Product> productList;
  public void setProductList(ArrayList<Product> productList){
     this.productList = productList;
  }
  public void doTag() throws JspException, IOException{
     for(Product product:productList){
        getJspContext().setAttribute("product", product);
        getJspBody().invoke(null);
     }
  }
}

