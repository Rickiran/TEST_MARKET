package com.Test_Market.Web.Controller;
import com.Test_Market.Domain.ProductDom;
import com.Test_Market.Domain.service.ProductService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/products")
public class productController implements ErrorController {

    @Autowired
    public ProductService prodServ;

   public String getErrorPath() {
        return "/error";
    }

    @RequestMapping("/error")
    public String handleError() {
        return "An issue appears according to your requests!";
    }

    @GetMapping("/all")
    @ApiOperation("Get all supermarket products")
    @ApiResponse(code=200,message = "OK")
    public ResponseEntity<List<ProductDom>> getAll() {
        return new ResponseEntity<>(prodServ.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("Get a product by its Id")
    @ApiResponses({
            @ApiResponse(code=200,message = "OK"),
            @ApiResponse(code=404,message="Product Not found")
    })
    public ResponseEntity<ProductDom> getProduct(@ApiParam(value="Product Id",required = true,example = "7") @PathVariable ("id") int productId) {
        return prodServ.getProduct(productId)
                .map(product-> new ResponseEntity<>(product,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<ProductDom>> getByCategory(@PathVariable ("categoryId")int categoryId) {
        return prodServ.getByCategory(categoryId)
                .map(products->new ResponseEntity<>(products,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/ScarseProducts/{quantity}")
    public ResponseEntity<List<ProductDom>> getScarseProducts(@PathVariable ("quantity")int quantity) {
        return prodServ.getScarseProducts(quantity)
                .map(products->new ResponseEntity<>(products,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<ProductDom> save(@RequestBody ProductDom prod) {
        return new ResponseEntity<>(prodServ.save(prod), HttpStatus.CREATED) ;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ProductDom> delete(@PathVariable ("id") int productId) {
        if(prodServ.delete(productId)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}