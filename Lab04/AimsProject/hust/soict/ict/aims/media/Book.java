package hust.soict.ict.aims.media;

import java.util.*;

public class Book extends Media {
    private List<String> authors = new ArrayList<String>();
    
 // Constructor 
    public Book(String title) {
        super(title);
    }
    public Book(String title, String category) {
        super(title, category);
    }
    public Book(String title, String category, float cost) {
        super(title, category, cost);
    }

	public List<String> getAuthors() {
		return authors;
	}

	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}
    
	public void addAuthor(String authorName) {
		if(!this.authors.contains(authorName)) {
			this.authors.add(authorName);
		}else {
			System.out.println("This author has already been in the list!");
		}
	}
	
	public void removeAuthor(String authorName) {
		if(this.authors.contains(authorName)) {
			this.authors.remove(authorName);
		}else {
			System.out.println("No author has been found to remove!");
		}
	}
	
}
