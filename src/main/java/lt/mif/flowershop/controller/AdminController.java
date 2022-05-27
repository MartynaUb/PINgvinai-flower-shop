package lt.mif.flowershop.controller;

import lt.mif.flowershop.domain.entity.Flower;
import lt.mif.flowershop.service.FlowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
        mav.addObject("failedUpdate", false);

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
    public ModelAndView updateFlower(Flower flower) {
        try {
            flowerService.updateFlower(flower);
        } catch (ObjectOptimisticLockingFailureException e) {
            ModelAndView mav = new ModelAndView("admin/admin-update");
            var currentFlower = flowerService.getFlower(flower.getId());
            flower.setVersion(currentFlower.getVersion());
            mav.addObject("flower", flower);
            mav.addObject("failedUpdate", true);
            return mav;
        }
        return new ModelAndView("redirect:/admin");
    }
}
