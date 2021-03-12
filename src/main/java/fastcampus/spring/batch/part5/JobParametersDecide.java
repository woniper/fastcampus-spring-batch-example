package fastcampus.spring.batch.part5;

import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.job.flow.FlowExecutionStatus;
import org.springframework.batch.core.job.flow.JobExecutionDecider;

public class JobParametersDecide implements JobExecutionDecider {

    public static final FlowExecutionStatus CONTINUE = new FlowExecutionStatus("CONTINUE");

    private final String key;

    public JobParametersDecide(String key) {
        this.key = key;
    }

    @Override
    public FlowExecutionStatus decide(JobExecution jobExecution, StepExecution stepExecution) {
        String value = jobExecution.getJobParameters().getString(key);

        if (StringUtils.isEmpty(value)) {
            return FlowExecutionStatus.COMPLETED;
        }

        return CONTINUE;
    }
}
