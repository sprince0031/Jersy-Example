package com.sprince0031;

import java.util.ArrayList;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

@Path("product")
public class ProductAPI {

    static ArrayList<Product> productList = new ArrayList<>();

    @GET
    @Path("get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProductDetails() {
        ArrayList<String> gsonProductList = new ArrayList<>();
        for (Product prod: productList) {
            gsonProductList.add(new Gson().toJson(prod));
        }

        return Response.status(200).entity(new Gson().toJson(gsonProductList)).build();
    }

    @POST
    @Path("add")
    public Response addProduct(
        @FormParam("id") int id,
        @FormParam("name") String prodName,
        @FormParam("price") double price) {
            productList.add(new Product(id, prodName, price));
            String output = "Product added successfully!<br>Product id: " + id + "<br>Product name: " + prodName + "<br>Price: " + price;
            return Response.status(201).entity(output).build();
    }
}