package segmenttree;

public class SegmentTreeMin implements STreeI {

	@Override
	public int type(int l, int r) {
		return Math.min(l, r);
	}

	@Override
	public int defaultValue() {
		return Integer.MAX_VALUE;
	}

}