package segmenttree;

public class SegmentTreeSum implements STreeI {

	@Override
	public int type(int l, int r) {
		return l + r;
	}

	@Override
	public int defaultValue() {
		return 0;
	}

}