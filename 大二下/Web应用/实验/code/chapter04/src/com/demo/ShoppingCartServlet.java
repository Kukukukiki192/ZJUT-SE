package com.demo;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletContext;
import javax.servlet.http.*;
import com.model.*;
@WebServlet(name = "ShoppingCartServlet", urlPatterns = {
		   "/addToCart","/viewProductDetails", "/deleteItem"  })
public class ShoppingCartServlet extends HttpServlet {
	ServletContext context;
	
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
              throws ServletException, IOException {
        String uri = request.getRequestURI();    
        if (uri.endsWith("/viewProductDetails")) {
            showProductDetails(request, response);
        } else if (uri.endsWith("deleteItem")) {
            deleteItem(request, response);
        }
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) 
                      throws ServletException, IOException {
        // 将一件商品放入购物车
        int productId = 0;
        int quantity = 0;
        try {
            productId = Integer.parseInt(request.getParameter("id"));
            quantity = Integer.parseInt(request.getParameter("quantity"));
        } catch (NumberFormatException e) {
        	System.out.println(e);	
        }
        Product product = getProduct(productId);       
        if (product != null && quantity >= 0) {
            GoodsItem goodsItem = new GoodsItem(product,quantity);
        	  HttpSession session = request.getSession();
            ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
            if (cart == null) {
                cart = new ShoppingCart();
                session.setAttribute("cart", cart);
            }
            cart.add(goodsItem);
        }
        // 显示购物车信息
        response.sendRedirect("showCart.jsp");
    }
    // 显示商品细节并可添加到购物车
    private void showProductDetails(HttpServletRequest request,
            HttpServletResponse response) throws IOException,ServletException {
      int productId = 0;
      try {
          productId = Integer.parseInt(request.getParameter("id"));
      } catch (NumberFormatException e) {
    	      System.out.println(productId);
    	      System.out.println(e);
      }
      // 根据商品号返回商品对象
      Product product = getProduct(productId);
      if (product != null) {
    	     HttpSession session = request.getSession();
    	     session.setAttribute("product", product);
    	     response.sendRedirect("showProduct.jsp");
      }else {
          //out.println("No product found");
       }
    }  
    // 从购物车中删除一件商品
    private void deleteItem(HttpServletRequest request, HttpServletResponse response) 
                    throws IOException {
    	  HttpSession session = request.getSession();
       ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");      	
    	  try{
    	     int id = Integer.parseInt(request.getParameter("id"));
    	     GoodsItem item=null;
    	     for(GoodsItem shopItem: cart.getItems()){
        	    if(shopItem.getProduct().getId()==id){
        		 item = shopItem;
        		 break;
        	    }
           }
    	     cart.remove(item.getProduct().getId());
       }catch(NumberFormatException e){
        	  System.out.println("发生异常："+e.getMessage());
     }
        session.setAttribute("cart", cart);
        response.sendRedirect("showCart.jsp");
     } 
     // 根据给定的商品号返回商品对象
     private Product getProduct(int productId) {
        context = getServletContext();
        ArrayList<Product>  products = 
                 (ArrayList<Product>)context.getAttribute("productList");
    	   for (Product product : products) {
            if (product.getId() == productId) {
                return product;
            }
        }
        return null;
    }
}

