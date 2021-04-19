package com.thuso.shoppe.rest;

import com.thuso.shoppe.dto.CustomerDto;
import com.thuso.shoppe.dto.ProductDto;
import com.thuso.shoppe.entity.Order;
import com.thuso.shoppe.services.ProcessorService;
import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Metered;
import org.eclipse.microprofile.metrics.annotation.Timed;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/shop")
@Tag(ref = "Thuso's Momentum Active Shoppe Services")
public class ShopperResource {

    @Inject
    ProcessorService processorService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/products")
    @Counted(name = "getProductList",
            description = "How many product list calls have been performed.")
    @Timed(name = "getProductListTimer",
            description = "A measure of how long it takes to perform a product list request.",
            unit = MetricUnits.MILLISECONDS)
    @APIResponse(responseCode = "200",
            description = "Fetches a list of all available Products.",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(type = SchemaType.ARRAY, implementation = ProductDto.class)))
    @APIResponse(responseCode = "500", description = "Unable to fetch Products.")
    @Operation(summary = "Lists all relevant Products a customer can purchase.",
            description = "Fetches all available Products from the shop that " +
                    "a customer can view and decide on which to purchase.")
    public Response products() {
        return Response.ok(processorService.getProducts()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/customers")
    @Counted(name = "getCustomerList",
            description = "How many customer list calls have been performed.")
    @Timed(name = "getCustomerListTimer",
            description = "A measure of how long it takes to perform a customer list request.",
            unit = MetricUnits.MILLISECONDS)
    @APIResponse(responseCode = "200",
            description = "Fetches a list of all available Customers.",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(type = SchemaType.ARRAY, implementation = CustomerDto.class)))
    @APIResponse(responseCode = "500", description = "Unable to fetch Products.")
    @Operation(summary = "Lists all relevant Customers.",
            description = "Fetches all available Customers from the shop.")
    public Response customers() {
        return Response.ok(processorService.getCustomers()).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/buy")
    @Counted(name = "purchaseOrderCounter",
            description = "How many purchase order calls have been performed.")
    @Timed(name = "purchaseOrderTimer",
            description = "A measure of how long it takes to purchase a product.", unit = MetricUnits.MILLISECONDS)
    @Metered(name = "purchase-order",
            unit = MetricUnits.MILLISECONDS,
            description = "Monitor the rate purchase events occurred",
            absolute = true)
    @APIResponse(responseCode = "200",
            description = "Processes the supplied order.",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(type = SchemaType.ARRAY, implementation = ProductDto.class)))
    @APIResponse(responseCode = "500", description = "Unable to process Order.")
    @APIResponse(responseCode = "401", description = "Not authorized to access this resource.")
    @APIResponse(responseCode = "403", description = "Customer doesn't exist.")
    @APIResponse(responseCode = "404", description = "No data found.")
    @APIResponse(responseCode = "400", description = "Data not provided.")
    @Operation(summary = "Processes the supplied order by the customer.",
            description = "Processes the supplied order by the customer and facilitates " +
                    "business process for finalising the order.")
    public Response purchase(@Valid @RequestBody(description = "Order Details", required = true,
            content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(type = SchemaType.OBJECT,
                    implementation = Order.class))) Order order) {
        return processorService.processOrder(order).build();
    }
}
