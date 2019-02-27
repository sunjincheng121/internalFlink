package org.apache.flink.streaming.api.operators;

import org.apache.flink.api.common.functions.AggregateFunction;

import java.util.List;

public class SplitEnumeratorAggFunction<SplitT> implements AggregateFunction<List<SplitT>, SplitEnumeratorAccumulator<SplitT>, List<SplitT>> {
	@Override
	public SplitEnumeratorAccumulator<SplitT> createAccumulator() {
		return new SplitEnumeratorAccumulator<SplitT>();
	}

	@Override
	public SplitEnumeratorAccumulator<SplitT> add(List<SplitT> value, SplitEnumeratorAccumulator<SplitT> accumulator) {
		return null;
	}

	@Override
	public List<SplitT> getResult(SplitEnumeratorAccumulator<SplitT> accumulator) {
		return null;
	}

	@Override
	public SplitEnumeratorAccumulator<SplitT> merge(SplitEnumeratorAccumulator<SplitT> a, SplitEnumeratorAccumulator<SplitT> b) {
		return null;
	}
}
