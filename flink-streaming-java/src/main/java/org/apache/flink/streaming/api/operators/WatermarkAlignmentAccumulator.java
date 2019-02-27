package org.apache.flink.streaming.api.operators;

import java.io.Serializable;
import java.util.Map;

public class WatermarkAlignmentAccumulator<SplitT> implements Serializable {
	public WatermarkAlignmentAccumulator<SplitT> updateSplitWaterMark(Map<SplitT, Long> data) {
		return this;
	}

	public long getCurrentAdvisedWaterMark() {
		return 0L;
	}

	public Map<SplitT, Long> getCurrentData() {
		return null;
	}
}
