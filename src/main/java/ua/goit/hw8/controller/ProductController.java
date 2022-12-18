package ua.goit.hw8.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import ua.goit.hw8.model.dto.ProducerDto;
import ua.goit.hw8.model.dto.ProductDto;
import ua.goit.hw8.service.ProducerService;
import ua.goit.hw8.service.ProductService;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;
    private final ProducerService producerService;

    @GetMapping("/findById")
    private ModelAndView findById(@RequestParam(name="productId", required = false,
            defaultValue = "123e4567-e89b-12d3-a456-426614174000")String id){
        ModelAndView result = new ModelAndView("products/findById");
        ProductDto product = productService.findById(UUID.fromString(id));
        result.addObject("product", product);
        if(product != null) {
            result.addObject("producerName", product.getProducerDto().getName());
        }
        return result;

    }

    @GetMapping("/findAll")
    private ModelAndView findAll(){
        ModelAndView result = new ModelAndView("/products/findAll");
        List<ProducerDto> producers = producerService.findAll();
        List<ProductDto> products = productService.findAll();
        result.addObject("producers", producers);
        result.addObject("products", products);
        return result;
    }

    @GetMapping("/create")
    private ModelAndView getCreateForm() {
        ModelAndView result = new ModelAndView("/products/createForm");
        ProductDto productDto = new ProductDto();
        result.addObject("productDto", productDto);
        result.addObject("producers", producerService.findAll());
        return result;
    }

    @GetMapping("/update")
    private ModelAndView getUpdateForm() {
        ModelAndView result = new ModelAndView("/products/updateForm");
        ProductDto productDto = new ProductDto();
        result.addObject("productDto", productDto);
        result.addObject("producers", producerService.findAll());
        return result;
    }

    @PostMapping("/save")
    private ModelAndView save(@Validated @ModelAttribute("product") ProductDto product){
        product.setProducerDto(producerService.findById(product.getProducerId()));
        productService.save(product);
        return findAll();
    }

    @GetMapping("/delete")
    private RedirectView delete(@RequestParam("id") String id) {
        productService.deleteById(UUID.fromString(id));
        return new RedirectView("/product/findAll");
    }



}
