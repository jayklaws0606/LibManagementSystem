package sait.bms.problemdomain;

public class Periodicals extends Book {
	private String frequency;

	public Periodicals() {
	}

	public Periodicals(long isbn, String callnum, int available, int total, String title, String frequency) {
		ISBN = isbn;
		CallNum = callnum;
		this.available = available;
		this.total = total;
		this.title = title;
		this.frequency = frequency;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	@Override
	public String toString() {
		return super.toString() + "Frequency:\t" + frequency + "\n";
	}

//extra toString method
	public String toStringFormat() {
		return super.toString();
	}

	public String rawString() {
		return String.format("%s;%s;%s;%s;%s;%s", getISBN(), getCallNum(),getAvailable(),getTotal() , getTitle(),
				getFrequency());
	}
}
