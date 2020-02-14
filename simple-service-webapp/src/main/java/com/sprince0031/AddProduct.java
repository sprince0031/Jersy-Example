package com.sprince0031;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("product")
public class AddProduct {

    @GET
    @Path("get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProductDetails() {
        // Object 
        Product product = new Product("Laptop", 60000.0);
        return Response.status(200).entity(product.toString()).build();
    }

    @POST
    @Path("/add")
    public Response addProduct(
        @FormParam("id") int id,
        @FormParam("name") String prodName,
        @FormParam("price") double price) {
            String output = "Product added successfully!<br>Product id: " + id + "<br>Product name: " + prodName + "<br>Price: " + price;
            return Response.status(200).entity(output).build();
    }
}