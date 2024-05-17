/**
 * The Seq<T> class for CS2030S 
 *
 * @author QIU JINHANG
 * @version CS2030S AY23/24 Semester 2
 */
class Seq<T extends Comparable<T>> {
  private T[] seq;

  Seq(int size) {
    // it is safe to cast `Comparable[]` to `T[]`.
    @SuppressWarnings({ "unchecked", "rawtypes" })
    T[] tmp = (T[]) new Comparable[size];
    this.seq = tmp;
  }

  public void set(int index, T item) {
    this.seq[index] = item;
  }

  public T get(int index) {
    return this.seq[index];
  }

  public T min() {
    int minIndex = 0;
    for (int i = 0; i < this.seq.length; i++) {
      if (this.seq[i].compareTo(this.seq[minIndex]) < 0) {
        minIndex = i;
      }
    }
    return this.seq[minIndex];
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder("[ ");
    for (int i = 0; i < this.seq.length; i++) {
      s.append(i + ":" + this.seq[i]);
      if (i != this.seq.length - 1) {
        s.append(", ");
      }
    }
    return s.append(" ]").toString();
  }
}
