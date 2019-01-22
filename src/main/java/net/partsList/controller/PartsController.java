package net.partsList.controller;

import net.partsList.model.Parts;
import net.partsList.service.PartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PartsController {
    private PartsService partsService;

    @Autowired(required = true)
    @Qualifier(value ="partService")
    public void setPartsService(PartsService partsService) {
        this.partsService = partsService;
    }

    @RequestMapping(value = "parts", method = RequestMethod.GET)
    public String listParts(Model model){
        model.addAttribute("allList",this.partsService.getAllList());
        model.addAttribute("currentList",this.partsService.currentList());
        model.addAttribute("part", new Parts());
        model.addAttribute("listParts",this.partsService.listParts());
        model.addAttribute("quantityComputer",this.partsService.quantityComputer());
        return "parts";
    }

    @RequestMapping("redirect")
    public String init(){
        this.partsService.list();
        this.partsService.redirectFrom();
        return "redirect:/parts";
    }

    @RequestMapping(value = "/parts/add",method = RequestMethod.POST)
    public String addParts(@ModelAttribute("part") Parts parts){
        if(parts.getId()==0){
            this.partsService.addParts(parts);
        } else{
            this.partsService.updateParts(parts);
        }
        return "redirect:/redirect";
    }

    @RequestMapping(value = "/parts/update", method = RequestMethod.POST)
    public String updateParts(@ModelAttribute("part") Parts parts) {
        this.partsService.updateParts(parts);
        return "redirect:/redirect";
    }

    @RequestMapping(value = "/parts/search", method = RequestMethod.POST)
    public String getPartsByName(@ModelAttribute("part") Parts parts, Model model) {
        model.addAttribute("part", partsService.getPartByName(parts.getParts()));
        return "search";
    }

    @RequestMapping("/remove/{id}")
    public String removeParts(@PathVariable("id") int id){
        this.partsService.removeParts(id);
        return "redirect:/redirect";
    }

    @RequestMapping("edit/{id}")
    public String editParts(@PathVariable("id") int id, Model model){
        model.addAttribute("part", this.partsService.getPartsById(id));
        model.addAttribute("listParts", this.partsService.listParts());
        return "parts";
    }


    @RequestMapping("next")
    public String nextList() {
        return "redirect:/parts";
    }

    @RequestMapping("previous")
    public String previousList() {
        this.partsService.listPrevious();
        return "redirect:/parts";
    }

    @RequestMapping(value = "/parts/selectNeed", method = RequestMethod.GET)
    public String selectNeeded(Model model) {
        this.partsService.selectNeed();
        return "redirect:/parts";
    }

    @RequestMapping(value = "/parts/selectNoNeed", method = RequestMethod.GET)
    public String selectNoNeed(Model model) {
        this.partsService.selectNoNeed();
        return "redirect:/parts";
    }

}
