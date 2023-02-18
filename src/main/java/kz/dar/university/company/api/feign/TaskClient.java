package kz.dar.university.company.api.feign;

import kz.dar.university.company.api.model.task.TaskDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name ="data-store")
public interface TaskClient {

    @GetMapping("/task/all")
    List<TaskDTO> getAllTasks();

}
