

// This is an interface for the iterators
// in this package to implement

 public interface NumberIterator{
        public abstract boolean hasNext();
        public abstract int next();
        public abstract void remove();
        public  int getNumOfItems();
 }