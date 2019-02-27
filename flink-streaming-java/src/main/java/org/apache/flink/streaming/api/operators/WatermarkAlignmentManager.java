package org.apache.flink.streaming.api.operators;

import org.apache.flink.runtime.taskexecutor.GlobalAggregateManager;

import java.io.IOException;
import java.util.Map;

public class WatermarkAlignmentManager<SplitT, T> {


	private GlobalAggregateManager aggregateManager;

	public void setAggregateManager(GlobalAggregateManager aggregateManager) {
		this.aggregateManager = aggregateManager;
	}

	public long reportWaterMark(Map<SplitT, Long> data) throws IOException {
		return aggregateManager.updateGlobalAggregate(
			"WatermarkAlignment_$taskID",
			data,
			new WatermarkAlignmentAggFunction<>());
	}
}
