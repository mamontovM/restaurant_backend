package ru.relex.restaurant.web.api;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.relex.restaurant.service.DTO.HistoryDto;
import ru.relex.restaurant.service.DTO.StatisticDto;
import ru.relex.restaurant.service.IHistoryService;

import javax.annotation.security.RolesAllowed;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "/history",
    consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
    produces = MediaType.APPLICATION_JSON_UTF8_VALUE
)
public class HistoryController {
  private final IHistoryService historyService;

  public HistoryController(IHistoryService historyService) {
    this.historyService = historyService;
  }

  @GetMapping
  @RolesAllowed({"ADMIN"})
  public StatisticDto statistic(@RequestParam(name = "from") String from, @RequestParam(name = "to") String to) {
    return historyService.getStatistic(new Date(Long.parseLong(from)), new Date(Long.parseLong(to)));
  }

  @PostMapping()
  public HistoryDto nextStatus(@RequestBody HistoryDto history){
    return historyService.nextStatus(history);
  }
}
