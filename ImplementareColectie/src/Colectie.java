import java.util.Iterator;

public interface Colectie<T> {
		
		public void adauga(T element);
		public void sterge(T element);
		public int dim();
		public boolean cauta(T element);
		Iterator<T> iterator();
}
