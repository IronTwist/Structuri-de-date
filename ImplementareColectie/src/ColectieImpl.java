import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ColectieImpl<T> implements Colectie<T> {
	
	private List<T> elemente;
//	private T elemCurent;
	
	public ColectieImpl() {								//Colectie
		this.elemente = new ArrayList<T>();
	}
	
//	public T elem() {
//		return this.elemCurent = elemente.iterator().next();
//		
//	}
	
	public void adauga(T element) {						//adauga
		this.elemente.add(element);
	}
	
	public void sterge(T element) {						//sterge
		boolean b = this.elemente.remove(element);
	}
	
	public boolean cauta(T element) {					//cauta
		return this.elemente.contains(element);
	}
	
	public int dim() {									//dim
		return this.elemente.size();
	}
	
	public Iterator<T> iterator(){						//iterator
		return new BagIterator<T>(this); 
	}
	
	public class BagIterator<T> implements Iterator<T>{
		
		private ColectieImpl<T> b;
		private int pozitieCurenta;
		
		public BagIterator(ColectieImpl<T> b) {
			this.b = b;
			this.pozitieCurenta = 0;
		}
		
		public boolean hasNext() {
			if(this.pozitieCurenta < this.b.elemente.size()) {
				return true;
			}else {
				return false;
			}
		}
		
		public T next() {
			T current = this.b.elemente.get(this.pozitieCurenta);
			this.pozitieCurenta++;
			return current;
		}
		
	}// end BagIterator
	
	
}
