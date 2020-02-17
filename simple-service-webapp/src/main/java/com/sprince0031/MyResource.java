package com.sprince0031;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myres")
public class MyResource {

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getItInHTML() {
        return "<html><body><h1>Got it in HTML!</h1></body></html>";
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getItInPlainText() {
        return "Got it in plain text!";
    }

    @GET
    @Path("{param}")
    @Produces(MediaType.TEXT_HTML)
    public Response getMessage(@PathParam("param") String message) {
        String output = "Note: Change the end of the URI to change the displayed message.<br><h1>Jersey says: " + message + "</h1>";
        return Response.status(200).entity(output).build();
    }

    @GET  
    @Path("{year}/{month}/{day}")  
    public Response getDate(  
            @PathParam("year") int year,  
            @PathParam("month") int month,   
            @PathParam("day") int day) {  
   
       String date = year + "/" + month + "/" + day;  
   
       return Response.status(200).entity("getDate is called, year/month/day : " + date).build();  
    }  

}
