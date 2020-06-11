package blockbuster;

public class Movie {
	private int id;
	  private String title;
	  private String length;
	  private int copies;
	  private int available;

	  public Movie(int id, String title, String length, int copies, int available)
	  {
	    super();

	    this.id = id;
	    this.title = title;
	    this.length = length;
	    this.copies = copies;
	    this.available = available;
	  }
	  
	  public int getId()
	  {
	    return id;
	  }

	  public String getTitle()
	  {
	    return title;
	  }
	    
	  public String getLength()
	  {
	    return length;
	  }

	  public int getCopies()
	  {
	    return copies;
	  }
	    
	  public void setCopies(int copies)
	  {
	    this.copies = copies;
	  }
	    
	  public int getAvailable()
	  {
	    return available;
	  }
	    
	  public void rentMe()
	  {
	    if (available > 0) {
	      available--;
	    }
	  }
	  
	  public void returnMe()
	  {
	    if (available < copies) {
	      available++;
	    }
	  }
	  
	  public void setTitle(String title)
	  {
	    this.title = title;
	  }

	  public void setLength(String length)
	  {
	    this.length = length;
	  }

	  public void setAvailable(int available)
	  {
	    this.available = available;
	  }
}
