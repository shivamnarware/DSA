package segmenttree;

public class SegmentTreeMax implements STreeI {

	@Override
	public int type(int l, int r) {
		return Math.max(l, r);
	}

	@Override
	public int defaultValue() {
		return Integer.MIN_VALUE;
	}

}
