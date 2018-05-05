package com.controllers;

import com.dao.LotDao;
import com.models.Lot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin/lots/")
public class ParkingController {
    private  static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final LotDao lotDao;

    @Autowired
    public ParkingController(LotDao lotDao) {
        this.lotDao = lotDao;
    }


    @RequestMapping("/add")
    public ModelAndView showAddLot(){
        ModelAndView model = new ModelAndView("/admin/lots/add");
        return model;
    }

    @RequestMapping("/all")
    public ModelAndView showAllLots(){
        ModelAndView model = new ModelAndView("/admin/lots/lots");
        return model;
    }
    /**
     * show all users
     */
    @RequestMapping("/json")
    @Transactional
    public @ResponseBody
    List<Lot> getJson() {
        return  this.lotDao.get("");
    }



    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @Transactional
    public @ResponseBody
    AjaxResponse addLotWithSpots(@Valid @ModelAttribute("lot") Lot lot, BindingResult result) {
        AjaxResponse aj = new AjaxResponse();
        logger.info(lot.toString());
        if (result.hasErrors()) {
            aj.setStatus(false);
            aj.setMsg("Something is wrong with binding data to class");
        }
		if(this.lotDao.add(lot)) {
			aj.setStatus(true);
			aj.setMsg("You have successfully added the Parking lot");
		} else {
			aj.setStatus(false);
            aj.setMsg(" Something is wrong to inserting to database");
		}
        return aj;
    }
}
