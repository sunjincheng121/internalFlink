package org.apache.flink.streaming.api.operators;

import org.apache.flink.api.common.functions.AggregateFunction;

import java.util.Map;

public class WatermarkAlignmentAggFunction<SplitT> implements
	AggregateFunction<Map<SplitT, Long>, WatermarkAlignmentAccumulator<SplitT>, Long> {

	@Override
	public WatermarkAlignmentAccumulator<SplitT> createAccumulator() {
		return new WatermarkAlignmentAccumulator<SplitT>();
	}

	@Override
	public WatermarkAlignmentAccumulator<SplitT> add(Map<SplitT, Long> value, WatermarkAlignmentAccumulator<SplitT> accumulator) {
		return accumulator.updateSplitWaterMark(value);
	}

	@Override
	public Long getResult(WatermarkAlignmentAccumulator<SplitT> accumulator) {
		return accumulator.getCurrentAdvisedWaterMark();
	}

	@Override
	public WatermarkAlignmentAccumulator<SplitT> merge(WatermarkAlignmentAccumulator<SplitT> a, WatermarkAlignmentAccumulator<SplitT> b) {
		return a.updateSplitWaterMark(b.getCurrentData());
	}
}
