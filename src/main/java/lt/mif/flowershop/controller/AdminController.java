package lt.mif.flowershop.controller;

import lt.mif.flowershop.domain.entity.Flower;
import lt.mif.flowershop.service.FlowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final FlowerService flowerService;

    @Autowired
    public AdminController(FlowerService flowerService) {
        this.flowerService = flowerService;
    }

    @ModelAttribute("flowers")
    public List<Flower> flowers() {
        return this.flowerService.getAllFlowers();
    }

    @ModelAttribute("newFlower")
    public Flower newFlower() {
        return new Flower();
    }


    @RequestMapping()
    public String adminPage() {
        return "admin/admin";
    }

    @RequestMapping("/update/{id}")
    public ModelAndView updatePage(@PathVariable("id") long id) {
        ModelAndView mav = new ModelAndView("admin/admin-update");
        mav.addObject("flower", flowerService.getFlower(id));

        return mav;
    }

    @RequestMapping("/create")
    public String createPage() {
        return "admin/admin-create";
    }

    @PostMapping
    public String createFlower(Flower newFlower) {
        flowerService.createFlower(newFlower);
        return "redirect:/admin";
    }

    @PostMapping("/update")
    public String updateFlower(Flower flower) {
        flowerService.updateFlower(flower);
        return "redirect:/admin";
    }
}
