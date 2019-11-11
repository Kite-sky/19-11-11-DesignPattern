

// This is an interface for the iterators
// in this package to implement

 public interface TextFileIterator{
        public abstract boolean hasNext();
        public abstract SalesDataModel next();
        public abstract void remove();
        public abstract float getPriceTotal();
 }