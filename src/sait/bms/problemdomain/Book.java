package sait.bms.problemdomain;

public class Book {
		
	
protected long ISBN;
protected String CallNum;
protected int available;
protected int total;
protected String title;

public Book(){
	
}

public Book(long iSBN, String callNum, int available,int total , String title) {
	this.ISBN = iSBN;
	this.CallNum = callNum;
	this.available = available;
	this.total = total;
	this.title = title;
}


public long getISBN() {
	return ISBN;
}

public void setISBN(long iSBN) {
	ISBN = iSBN;
}

public String getCallNum() {
	return CallNum;
}

public void setCallNum(String callNum) {
	CallNum = callNum;
}

public int getTotal() {
	return total;
}

public void setTotal(int total) {
	this.total = total;
}

public int getAvailable() {
	return available;
}

public void setTitle(String title) {
	this.title = title;
}

@Override
public String toString() {
	return "ISBN:\t\t" + ISBN + "\n"
			+ "Call Number:\t" + CallNum + "\n"
			+ "Available:\t" + available + "\n"
			+ "Total:\t\t" + total + "\n"
			+ "Title:\t\t" + title + "\n";
}

public void setAvailable(int available) {
	this.available = available;
}

public String getTitle() {
	return title;
}

public String rawString() {
    return "";
}

}
