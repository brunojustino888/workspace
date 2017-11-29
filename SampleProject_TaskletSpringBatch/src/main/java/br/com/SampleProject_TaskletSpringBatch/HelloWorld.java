package br.com.SampleProject_TaskletSpringBatch;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class HelloWorld implements Tasklet{

	@Override
	public RepeatStatus execute(StepContribution arg0, ChunkContext arg1) throws Exception {
		System.out.println("\n\n********------------------- Tasklet HelloWorld SpringBatch -------------------*********\n\n");
		return RepeatStatus.FINISHED;
	}
	
}