package sait.bms.problemdomain;

public class CookBooks extends Book {
	private String publisher;
	private String diet;

	public CookBooks() {
	}

	public CookBooks(long isbn, String callnum, int available, int total, String title, String publisher,
			String diet) {
		ISBN = isbn;
		CallNum = callnum;
		this.available = available;
		this.total = total;
		this.title = title;
		this.publisher = publisher;
		this.diet = diet;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getDiet() {
		return diet;
	}

	public void setDiet(String diet) {
		this.diet = diet;
	}

	@Override
	public String toString() {
		return super.toString() + "Publisher:\t" + publisher + "\n" + "Diet:\t\t" + diet + "\n";
	}

	public String rawString() {
		return String.format("%s;%s;%s;%s;%s;%s;%s",getISBN(), getCallNum(),getAvailable(),getTotal() , getTitle(),
				getPublisher(), getDiet());
	}
}
