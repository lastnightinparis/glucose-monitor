package forkjoin.glucosemonitor.controller;

import forkjoin.glucosemonitor.service.PlotService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/api/plot")
@AllArgsConstructor
public class CanvasController {

    private PlotService plotService;

    @GetMapping("/draw")
    public String linePlot(Model model,
                           @RequestParam(name = "from") @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") Date from,
                           @RequestParam(name = "to") @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") Date to) {
        List<List<Object>> chartData = plotService.prepareData(from, to);
        model.addAttribute("chartData", chartData);
        return "google-charts";
    }


}
