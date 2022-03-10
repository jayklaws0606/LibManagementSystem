package sait.bms.problemdomain;

public class PaperBacks extends Book {
	
	private String Author;
	private int year;
	private String genre;

	public PaperBacks() {
			this.setTitle(title);
	}

	public PaperBacks(long isbn , String callnum ,int available, int total,
			String title ,String author, int year, String genre) {
		ISBN = isbn;
		CallNum = callnum;
		this.available = available;
		this.total = total;
		this.title = title;
		Author = author;
		this.year = year;
		this.genre = genre;
	}

	@Override
	public String toString() {
		return super.toString()
				+"Author:\t\t" + Author + "\n"
				+"Year:\t\t" + year + "\n"
				+"Genre:\t\t" + genre + "\n";
	}

	public String getAuthor() {
		return Author;
	}

	public void setAuthor(String author) {
		Author = author;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String rawString() {
		return String.format("%s;%s;%s;%s;%s;%s;%s;%s",getISBN(), getCallNum(),getAvailable(),getTotal() , getTitle(),
				getAuthor(), getYear(), getGenre());
    }

}
