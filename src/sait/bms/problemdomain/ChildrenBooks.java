package sait.bms.problemdomain;

public class ChildrenBooks extends Book {

	private String Author;
	private String Format;

	public ChildrenBooks() {

	}

	public ChildrenBooks(long isbn, String callnum, int available, int total,  String title, String author,
			String format) {
		ISBN = isbn;
		CallNum = callnum;
		this.available = available;
		this.total = total;
		this.title = title;
		Author = author;
		Format = format;
	}

	public String getAuthor() {
		return Author;
	}

	public void setAuthor(String author) {
		Author = author;
	}

	public String getFormat() {
		return Format;
	}

	public void setFormat(String format) {
		Format = format;
	}

	@Override
	public String toString() {
		return super.toString() + "Author:\t\t" + Author + "\n" + "Format:\t\t" + Format + "\n";
	}

	public String rawString() {
		
		return String.format("%s;%s;%s;%s;%s;%s;%s", getISBN(), getCallNum(),getAvailable(),getTotal(), getTitle(),
				getAuthor(), getFormat());
	}

}
