class LucasNumber {
    private int index;
    private long value;

    public LucasNumber(int index) {
        this.index = index;
        this.value = calculateLucasNumber(index);
    }

    private long calculateLucasNumber(int n) {
        if (n == 0) return 2;
        if (n == 1) return 1;

        long prev = 2, curr = 1;
        for (int i = 2; i <= n; i++) {
            long next = prev + curr;
            prev = curr;
            curr = next;
        }
        return curr;
    }

    public long getValue() {
        return this.value;
    }

    public int getIndex() {
        return this.index;
    }

    public boolean checkInequality() {
        LucasNumber nextLucasNumber = new LucasNumber(this.index + 1);
        long LnPlus1 = nextLucasNumber.getValue();
        return this.index * LnPlus1 > (this.index + 1) * this.value;
    }
}
