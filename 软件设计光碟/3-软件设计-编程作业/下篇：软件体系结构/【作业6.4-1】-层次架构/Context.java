



// Configured with a ConcreteStrategy object and maintains a reference to a Strategy object
class Context {

    SortAlgorithm alg;

    // Constructor
    public Context(SortAlgorithm alg) {
        this.alg = alg;
    }

    public int[] sortIntArray(int[] a) {
        return this.alg.sort(a);
    }

}