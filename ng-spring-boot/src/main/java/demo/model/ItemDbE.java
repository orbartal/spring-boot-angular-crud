package demo.model;

import javax.persistence.*;

@Entity
@Table(name = "items") 
public class ItemDbE {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column (name = "id")
  private Long id;
  
  @Column (name = "name")
  private String name;
  
  	public Long getId() {
		return id;
  	}

	public void setId(Long value) {
		id = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String value) {
		name = value;
	}

 
}
