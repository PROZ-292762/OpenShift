package proz.dockercalc.rest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;

import proz.dockercalc.model.ArgumentPair;


@Path("/add")
public class Hello {
	
	@GET
	public String calcAdd(@DefaultValue("0") @QueryParam("arg1") String arg1, @QueryParam("arg2") String arg2){
		return "arg1 = " + arg1 + "\narg2 = " + arg2;
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postArgumentPair(ArgumentPair x){
		double result = x.getArg1() + x.getArg2();
		return Response.status(201).entity(result).build();
	}
}
