package kz.dar.university.company.api.model.task;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TaskDTO {

    private String taskId;
    private String initiatorId;
    private String executorId;
    private String description;

}
